package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.Florist;
import com.ipsas.WebService.Repositories.FloristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloristService {
    private FloristRepository floristRepo;

    @Autowired
    public FloristService(FloristRepository floristRepo) {
        this.floristRepo = floristRepo;
    }

    public Florist addFlorist(Florist C){
        return floristRepo.save(C);
    }

    public List<Florist> addFlorists(List<Florist> floristList){
        return floristRepo.saveAll(floristList);
    }

    public List<Florist> findAll(){
        return floristRepo.findAll();
    }

    public Florist findOneById(Long id){
        return floristRepo.findById(id).orElseThrow(()-> new RuntimeException("Florist by id : "+id+" is not found !" ));
    }

    public Florist updateFlorist(Florist E){
        return floristRepo.save(E);
    }

    public void deleteFlorist(Long id){
        floristRepo.deleteById(id);
    }

}
