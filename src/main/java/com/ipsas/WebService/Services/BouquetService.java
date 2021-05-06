package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.Bouquet;
import com.ipsas.WebService.Models.Flower;
import com.ipsas.WebService.Repositories.BouquetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BouquetService {
    private BouquetRepository bouquetRepo;

    @Autowired
    public BouquetService(BouquetRepository bouquetRepo) {
        this.bouquetRepo = bouquetRepo;
    }

    public Bouquet addBouquet(Bouquet B){
        return bouquetRepo.save(B);
    }

    public Bouquet addFlower(Bouquet B, Flower F){
        B.getFlowersList().add(F);
        return bouquetRepo.save(B);
    }

    public List<Bouquet> addBouquets(List<Bouquet> bouquetList){
        return bouquetRepo.saveAll(bouquetList);
    }

    public List<Bouquet> findAll(){
        return bouquetRepo.findAll();
    }

    public Bouquet findOneById(Long id){
        return bouquetRepo.findById(id).orElseThrow(()-> new RuntimeException("Bouquet by id : "+id+" is not found !" ));
    }

    public Bouquet updateBouquet(Bouquet E){
        return bouquetRepo.save(E);
    }

    public void deleteBouquet(Long id){
        bouquetRepo.deleteById(id);
    }

}
