package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Models.Bouquet;
import com.ipsas.WebService.Services.BouquetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bouquets")
public class BouquetController {
    private final BouquetService commandeService;

    public BouquetController(BouquetService commandeService) {
        this.commandeService = commandeService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Bouquet>> index(){
        List<Bouquet> l = commandeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bouquet> findById(@PathVariable("id") Long id){
        Bouquet e = commandeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Bouquet> add(@RequestBody Bouquet bouquet){
        Bouquet e = commandeService.addBouquet(bouquet);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Bouquet> update(@RequestBody Bouquet bouquet){
        Bouquet e = commandeService.updateBouquet(bouquet);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commandeService.deleteBouquet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
