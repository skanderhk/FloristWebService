package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.Bouquet;
import com.ipsas.WebService.Models.Commande;
import com.ipsas.WebService.Models.Flower;
import com.ipsas.WebService.Repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {
    private CommandeRepository commandeRepo;

    @Autowired
    public CommandeService(CommandeRepository commandeRepo) {
        this.commandeRepo = commandeRepo;
    }

    public Commande addCommande(Commande C){
        return commandeRepo.save(C);
    }

    public Commande addBouquet(Commande C, Bouquet B){
        C.getBouquetList().add(B);
        return commandeRepo.save(C);
    }

    public Commande addFlower(Commande C, Flower F){
        C.getFlowerList().add(F);
        return commandeRepo.save(C);
    }

    public List<Commande> addCommandes(List<Commande> flowerList){
        return commandeRepo.saveAll(flowerList);
    }

    public List<Commande> findAll(){
        return commandeRepo.findAll();
    }

    public Commande findOneById(Long id){
        return commandeRepo.findById(id).orElseThrow(()-> new RuntimeException("Commande by id : "+id+" is not found !" ));
    }

    public Commande updateCommande(Commande E){
        return commandeRepo.save(E);
    }

    public void deleteCommande(Long id){
        commandeRepo.deleteById(id);
    }



}
