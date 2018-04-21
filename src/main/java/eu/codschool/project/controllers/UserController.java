package eu.codschool.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;
import eu.codschool.project.services.AdminService;
import eu.codschool.project.services.UserService;
import eu.codschool.project.validators.UserValidator;

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
    
}
