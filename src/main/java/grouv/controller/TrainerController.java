package grouv.controller;

import grouv.entity.Trainer;
import grouv.service.TrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/trainer")
public class TrainerController {
    
    @Autowired
    private TrainerService service;
    
    //creates the list of Trainer trainers by running the getTrainers() method of the TrainerService class. 
    //it then stores the resulting list in modelandview under the key named "listOfTrainers" and sets the
    //view for it in the viewname "trainerList".
    @RequestMapping
    public ModelAndView showTrainers(ModelAndView modelAndView){
        List<Trainer> trainers = service.getTrainers();
        modelAndView.addObject("listOfTrainers", trainers);
        modelAndView.setViewName("trainerList");
        return modelAndView;
    }
    
    //loads the trainerForm.jsp.
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showForm(){
        return "trainerForm";
    }
    
    //runs the addTrainer method of the TrainerService class for the Trainer object and then creates a 
    //String that gets stored in the flash attribute with the name "message". It finally instructs the 
    //client to send a new GET request to /trainer.
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Trainer trainer, RedirectAttributes attributes){
        service.addTrainer(trainer);
        String minima = "Trainer "+ trainer.getFirstName() + " " + trainer.getLastName() + " successfully created!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    //runs the deleteTrainer method of the TrainerService class for the id parameter obtained from the URI 
    //and then creates a String that gets stored in the flash attribute with the name "message". It finally 
    //instructs the client to send a new GET request to /trainer.
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, RedirectAttributes attributes){
        service.deleteTrainer(id);
        String minima = "Trainer successfully deleted!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    //runs the getTrainerById method of the TrainerService class for the trainerID parameter obtained from 
    //the URI Template and then stores the Trainer object that it got as result in the model as an attribute 
    //named "trainerToEdit" with the Trainer object as its value. Finally it loads the trainerForm.jsp.
    @GetMapping("/update/{trainerID}")
    public String showFormUpdate(@PathVariable("trainerID") int trainerID, Model model){
        Trainer trainer = service.getTrainerById(trainerID);
        model.addAttribute("trainerToEdit", trainer);
        return "trainerForm";
    }
    
    //runs the updateTrainer method of the TrainerService class for the Trainer object and then creates a String 
    //that gets stored in the flash attribute under the name "message". It finally instructs the client to send a 
    //new GET request to /trainer.
    @PostMapping("/update")
    public String update(Trainer trainer, RedirectAttributes attributes){
        service.updateTrainer(trainer);
        String minima = "Trainer "+ trainer.getFirstName() + " " + trainer.getLastName() + " successfully updated!!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }
    
    //a generic Exception handler that every time the application runs to an exception it creates a String 
    //that stores it in the flash atrribute under the name "message" and then instructs the client to send 
    //a new GET request to /trainer.
    @ExceptionHandler(Exception.class)
    public String handleException(RedirectAttributes attributes) {
        String minima = "Could not complete the selected task!";
        attributes.addFlashAttribute("message", minima);
        return "redirect:/trainer";
    }

    
}