package eu.codschool.project.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import eu.codschool.project.entities.Device;
import eu.codschool.project.entities.Room;
import eu.codschool.project.entities.User;
import eu.codschool.project.services.AdminService;
import eu.codschool.project.services.UserService;

/**
 * Controller that handles all administrator specific actions
 * @author geost
 *
 */

@Controller
public class AdminController {
	
    @Autowired
    private AdminService adminService;
	
    @Autowired
    private UserService userService;
    
    //User specific controllers
    
    /**
     * Returns the page where the administrator can see all users, and change their access
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin", "/admin/manageusers"}, method = RequestMethod.GET)
    public String manageUsers(Model model) {
    	model.addAttribute("users", userService.findAll());
    	model.addAttribute("userViewDevices", new User());
        return "manageusers";
    }
    
    //Device specific controllers
    
    /**
     * Returns the page where the administrator can access view/add/delete devices
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/managedevices"}, method = RequestMethod.GET)
    public String manageDevices(Model model) {
    	model.addAttribute("adddevice", new Device());
    	model.addAttribute("devices", adminService.getAllDevices());
    	model.addAttribute("rooms", adminService.getAllRooms());
    	model.addAttribute("deviceTypes", adminService.getAllDeviceTypes());
        return "managedevices";
    }

    
    /**
     * Handles the add device request, and redirects to managedevices page
     * @param device
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/managedevices", method = RequestMethod.POST)
    public String addDevice(@ModelAttribute("adddevice") Device device, Model model) {
        adminService.addDevice(device);
        return "redirect:/admin/managedevices";
    }

	
    /**
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/viewdevices"}, method = RequestMethod.GET)
    public String viewDevices(Model model) {
    	model.addAttribute("devices", adminService.getAllDevices());
        return "viewdevices";
    }
    
    //Room specific controllers
    
    /**
     * Returns the page where the administrator can view/add/delete rooms
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/managerooms"}, method = RequestMethod.GET)
    public String manageRooms(Model model) {
    	model.addAttribute("rooms", adminService.getAllRooms());
    	model.addAttribute("addroom", new Room());
    	model.addAttribute("deleteroom", new Room());
        return "managerooms";
    }
    
    
    /**
     * Handles the add room request, and redirects to managerooms page
     * @param room
     * @param model
     * @return
     */
    @RequestMapping(value = {"/admin/managerooms"}, method = RequestMethod.POST)
    public String addRoom(@ModelAttribute("addroom") Room room, Model model) {
        adminService.addRoom(room);
        return "redirect:/admin/managerooms";
    }
    
    /**
     * Handles the delete room request, and redirects to managerooms page
     * @param roomId
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/deleteroom", method = RequestMethod.POST)
    public String deleteRoom(@RequestParam(name = "deleteRoomId") Integer roomId, Model model) {
    	Room room = adminService.getRoomById(roomId);
        adminService.deleteRoom(room);
        return "redirect:/admin/managerooms";
    }
}
