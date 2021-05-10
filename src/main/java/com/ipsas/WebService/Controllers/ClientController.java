package com.ipsas.WebService.Controllers;

import com.ipsas.WebService.Enums.Role;
import com.ipsas.WebService.Models.Client;
import com.ipsas.WebService.Models.Commande;
import com.ipsas.WebService.Models.User;
import com.ipsas.WebService.Services.ClientService;
import com.ipsas.WebService.Services.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.extensions.Extension;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
@Tag(name = "Clients Controller",description = "Full CRUD for Client Model")
public class ClientController {
    private final ClientService clientService;
    private final UserService userService;
    @Autowired
    public ClientController(ClientService clientService, UserService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    @Operation(summary = "Index",description = "Return List of all Clients")
    @GetMapping("/")
    public ResponseEntity<List<Client>> index(){
        List<Client> l = clientService.findAll();
        return new ResponseEntity<>(l, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable("id") Long id){
        Client e = clientService.findOneById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @GetMapping("/{id}/commandes")
    public ResponseEntity<List<Commande>> allCommandes(@PathVariable("id") Long id, Authentication authentication){
        String n = authentication.getName();
        User u = userService.findOneByUsername(n);
        Client e = clientService.findOneById(id);
        if (e.getId() == u.getId()) {
            return new ResponseEntity<List<Commande>>(e.getCommandeList(), HttpStatus.OK);
        }else{
            throw new RuntimeException("mouch enty");}
    }

    @PostMapping ("/add")
    public ResponseEntity<Client> add(@RequestBody Client client){
        client.setRole(Role.CLIENT);
        Client e = clientService.addClient(client);
        return new ResponseEntity<>(e, HttpStatus.CREATED);
    }

    @PutMapping  ("/update")
    public ResponseEntity<Client> update(@RequestBody Client client){
        Client e = clientService.updateClient(client);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    @DeleteMapping  ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
