package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Enums.Role;
import com.ipsas.WebService.Models.Flower;
import com.ipsas.WebService.Services.FlowerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Flower>> index(){
        List<Flower> l = flowerService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flower> findById(@PathVariable("id") Long id){
        Flower e = flowerService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Flower> add(@RequestBody Flower flower){
        Flower e = flowerService.addFlower(flower);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Flower> update(@RequestBody Flower flower){
        Flower e = flowerService.updateFlower(flower);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        flowerService.deleteFlower(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
