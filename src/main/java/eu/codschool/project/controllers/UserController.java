package eu.codschool.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.codschool.project.entities.User;
import eu.codschool.project.services.AdminService;
import eu.codschool.project.services.UserService;

/**
 * Controller that handles all simple user requests (also used for administrator's
 * for non administrator specific access). 
 * @author geost
 *
 */
@Controller
public class UserController {
	
    @Autowired
    private AdminService adminService;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @RequestMapping(value = {"/viewdevices"}, method = RequestMethod.GET)
    public String viewDevices(Model model) {
    	model.addAttribute("loggedUser", userService.getLoggedUser());
    	if(userService.getLoggedUser().getRole() == 0) {
    		model.addAttribute("devices", adminService.getAllDevices());
    	}else{
    		model.addAttribute("devices", userService.getLoggedUser().getDevices());
    	}
        return "viewdevices";
    }
    
    @RequestMapping(value = {"/viewaccount"}, method = RequestMethod.GET)
    public String viewAccount(Model model) {
    	model.addAttribute("loggedUser", userService.getLoggedUser());
        return "manageaccount";
    }
    
    @RequestMapping(value = {"/viewaccount"}, method = RequestMethod.POST)
    public String updateAccount(@ModelAttribute("loggedUser") User loggedUser, Model model) {
    	//Password is not correctly encrypted, do not uncomment.
    	//loggedUser.setPassword(passwordEncoder.encode(loggedUser.getPassword()));
    	loggedUser.setPassword(userService.getLoggedUser().getPassword());
    	loggedUser.setRole(userService.getLoggedUser().getRole());
    	loggedUser.setUserID(userService.getLoggedUser().getUserID());
    	userService.setLoggedUser(loggedUser);
    	userService.save(loggedUser);
        return "redirect:/viewaccount";
    }
    
    @RequestMapping(value = {"/radio"}, method = RequestMethod.GET)
    public String viewRadio(Model model) {
    	model.addAttribute("loggedUser", userService.getLoggedUser());
        return "radio";
    }
   
}
