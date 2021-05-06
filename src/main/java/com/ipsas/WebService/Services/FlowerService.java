package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.Flower;
import com.ipsas.WebService.Repositories.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    private FlowerRepository flowerRepo;

    @Autowired
    public FlowerService(FlowerRepository flowerRepo) {
        this.flowerRepo = flowerRepo;
    }

    public Flower addFlower(Flower C){
        return flowerRepo.save(C);
    }

    public List<Flower> addFlowers(List<Flower> flowerList){
        return flowerRepo.saveAll(flowerList);
    }

    public List<Flower> findAll(){
        return flowerRepo.findAll();
    }

    public Flower findOneById(Long id){
        return flowerRepo.findById(id).orElseThrow(()-> new RuntimeException("Flower by id : "+id+" is not found !" ));
    }

    public Flower updateFlower(Flower E){
        return flowerRepo.save(E);
    }

    public void deleteFlower(Long id){
        flowerRepo.deleteById(id);
    }



}
