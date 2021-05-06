package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Enums.Role;
import com.ipsas.WebService.Models.Florist;
import com.ipsas.WebService.Services.FloristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/florists")
public class FloristController {
    private final FloristService floristService;

    @Autowired
    public FloristController(FloristService floristService) {
        this.floristService = floristService;
    }
    @GetMapping("/")
    public ResponseEntity<List<Florist>> index(){
        List<Florist> l = floristService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Florist> findById(@PathVariable("id") Long id){
        Florist e = floristService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Florist> add(@RequestBody Florist florist){
        florist.setRole(Role.FLORIST);
        Florist e = floristService.addFlorist(florist);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Florist> update(@RequestBody Florist florist){
        Florist e = floristService.updateFlorist(florist);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        floristService.deleteFlorist(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
