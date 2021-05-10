package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Models.Commande;
import com.ipsas.WebService.Models.Florist;
import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Services.CommandeService;
import com.ipsas.WebService.Services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/commandes")
@Tag(name = "Commandes Controller",description = "Full CRUD for Commande Model")
public class CommandeController {
    private final CommandeService commandeService;
    private final UserService userService;

    public CommandeController(CommandeService commandeService, UserService userService) {
        this.commandeService = commandeService;
        this.userService = userService;
    }

    @Operation(summary = "Index",description = "Return List of all Commandes")
    @GetMapping("/")
    public ResponseEntity<List<Commande>> index(){
        List<Commande> l = commandeService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Commande> findById(@PathVariable("id") Long id){
        Commande e = commandeService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @PostMapping ("/add")
    public ResponseEntity<Commande> add(@RequestBody Commande commande){
        Commande e = commandeService.addCommande(commande);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Commande> update(@RequestBody Commande commande){
        Commande e = commandeService.updateCommande(commande);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        commandeService.deleteCommande(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
