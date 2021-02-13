package grouv.service;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
    
    public String getWelcomeMessage(){
        String message = "Welcome to our Trainer CRUD Application.";
        return message;
    }
    
    public String getApplicationName(){
        return "Application Name: TrainersMVCCRUD";
    }
}
