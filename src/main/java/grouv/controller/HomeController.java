package grouv.controller;

import grouv.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")//This will be inherited from all the methods of the controller.
public class HomeController {
    
    @Autowired
    private HomeService homeService;
    
    //gets the value of the message variable from the getWelcomeMessage() method of the HomeService class 
    //and adds it in the model as the value of an attribute named "myMessage" that it creates. It finally
    //loads the home.jsp.
    @RequestMapping("/")
    public String showHome(Model model){
        String message = homeService.getWelcomeMessage();
        model.addAttribute("myMessage", message);
        return "home";
    }
    
    //gets the value of the getApplicationName() method of the HomeService class and adds it in the model as 
    //the value of an attribute named "myMessage" that it creates. It then sets it as the name of the application. 
    //It finally loads the home.jsp.
    @RequestMapping("/appName")
    public String showNameOfApplication(Model model){
        String appName = homeService.getApplicationName();
        model.addAttribute("myMessage", appName);
        return "home";
    }
}
