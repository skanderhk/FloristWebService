package com.ipsas.WebService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipsas.WebService.Enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@DiscriminatorValue("Client")
public class Client extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Commande> commandeList;

    public Client(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password, Role.CLIENT);
        this.commandeList = Arrays.asList();
    }

    public Client() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }
}
