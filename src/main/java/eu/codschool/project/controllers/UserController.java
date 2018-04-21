package eu.codschool.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = {"/viewdevices"}, method = RequestMethod.GET)
    public String manageUsers(Model model) {
    	model.addAttribute("loggedUser", userService.getLoggedUser());
    	if(userService.getLoggedUser().getRole() == 0) {
    		model.addAttribute("devices", adminService.getAllDevices());
    	}else{
    		model.addAttribute("devices", userService.getLoggedUser().getDevices());
    	}
        return "viewdevices";
    }
    
}
