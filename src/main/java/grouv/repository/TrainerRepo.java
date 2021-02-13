package grouv.repository;

import grouv.entity.Trainer;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class TrainerRepo extends HibernateUtil<Trainer>{
    
    public List<Trainer> findAll(){
        return super.findAll("Trainer.findAll");
    }
    
    @Override
    public Trainer save(Trainer trainer){
        return super.save(trainer);
    }

    public Trainer find(int id){
        return super.find(Trainer.class, id);
    }
    
}
