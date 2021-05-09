package com.ipsas.WebService.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ipsas.WebService.Enums.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@DiscriminatorValue("Florist")
public class Florist extends User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "florist")
    @JsonIgnoreProperties(value = {"florist"})
    private List<Commande> commandeList;

    public Florist(String firstname, String lastname, String username, String password) {
        super(firstname, lastname, username, password, Role.FLORIST);
        this.commandeList = Arrays.asList();
    }

    public Florist() {
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
