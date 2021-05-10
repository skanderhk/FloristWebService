package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Models.Bouquet;
import com.ipsas.WebService.Services.BouquetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bouquets")
@Tag(name = "Bouquets Controller",description = "Full CRUD for Bouquets Model")
public class BouquetController {
    private final BouquetService commandeService;

    public BouquetController(BouquetService commandeService) {
        this.commandeService = commandeService;
    }

    @Operation(summary = "Index",description = "Return List of all Bouquets")
    @GetMapping("/")
    public ResponseEntity<List<Bouquet>> index(){
        List<Bouquet> l = commandeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @Operation(summary = "findById",description = "Return a selected Bouquet")
    @GetMapping("/{id}")
    public ResponseEntity<Bouquet> findById(@PathVariable("id") Long id){
        Bouquet e = commandeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Add",description = "Add new Bouquet")
    @PostMapping ("/add")
    public ResponseEntity<Bouquet> add(@RequestBody Bouquet bouquet){
        Bouquet e = commandeService.addBouquet(bouquet);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @Operation(summary = "Update",description = "Update an existing Bouquet")
    @PutMapping  ("/update")
    public ResponseEntity<Bouquet> update(@RequestBody Bouquet bouquet){
        Bouquet e = commandeService.updateBouquet(bouquet);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @Operation(summary = "Delete",description = "Delete a selected Bouquet")
    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commandeService.deleteBouquet(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
