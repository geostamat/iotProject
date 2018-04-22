package eu.codschool.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import eu.codschool.project.entities.User;
import eu.codschool.project.services.UserService;
import eu.codschool.project.validators.UserValidator;

/**
 * Controller that handles all authorization specific requests
 * @author geost
 *
 */
@Controller
public class IndexController {
	
    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;
    
    /**
     * Returns the first page of the application
     */
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
    /**
     * Returns login page
     * @param model
     * @param error
     * @param logout
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
    
    /**
     * Returns registration page
     * @param model
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }
    
    /**
     * Returns registration page on unsuccessful registration and login page on successful registration.
     * All newly registered users receive role 1 (simple user).
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
    	user.setRole(1);
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
        	System.out.println("errors!");
            return "registration";
        }
        userService.save(user);
        return "redirect:/login";
    }

}
