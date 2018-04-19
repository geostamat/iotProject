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

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.DeviceType;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;
import eu.codschool.project.services.AdminService;
import eu.codschool.project.services.UserService;
import eu.codschool.project.validators.UserValidator;


@Controller
public class AdminController {
	
    @Autowired
    private AdminService adminService;
	
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/admin", "/admin/manageusers"}, method = RequestMethod.GET)
    public String manageUsers(Model model) {
    	model.addAttribute("users", userService.findAll());
        return "manageusers";
    }
    
    @RequestMapping(value = {"/admin/managerooms"}, method = RequestMethod.GET)
    public String manageRooms(Model model) {
    	model.addAttribute("rooms", adminService.getAllRooms());
    	model.addAttribute("addroom", new Room());
        return "managerooms";
    }
    
    @RequestMapping(value = {"/admin/managedevices"}, method = RequestMethod.GET)
    public String manageDevices(Model model) {
    	model.addAttribute("adddevice", new Device());
    	model.addAttribute("devices", adminService.getAllDevices());
    	model.addAttribute("rooms", adminService.getAllRooms());
    	model.addAttribute("deviceTypes", adminService.getAllDeviceTypes());
        return "managedevices";
    }
    
    @RequestMapping(value = "/admin/managerooms", method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("addroom") Room room, Model model) {
    	System.out.println("POST controller");
        adminService.addRoom(room);
        System.out.println(room);
        System.out.println("Success");
        return "managerooms";
    }
    
    @RequestMapping(value = "/admin/managedevices", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("adddevice") Device device, Model model) {
    	System.out.println("POST controller");
        adminService.addDevice(device);
        return "managedevices";
    }
	
    
}
