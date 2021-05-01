package com.ipsas.WebService.Models;

import com.ipsas.WebService.Enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("Florist")
public class Florist extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    private List<Commande> commandeList;

    public Florist(String firstname, String lastname, String username, String password, Role role, Long id, String name, List<Commande> commandeList) {
        super(firstname, lastname, username, password, role);
        this.name = name;
        this.commandeList = commandeList;
    }

    public Florist() {
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Commande> getCommandeList() {
        return commandeList;
    }

    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }
}
