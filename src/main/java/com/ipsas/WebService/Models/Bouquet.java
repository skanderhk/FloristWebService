package com.ipsas.WebService.Models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bouquet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<Flower> flowersList;
    private double price;

    public Bouquet(List<Flower> flowersList) {
        this.flowersList = flowersList;
        this.price = setPrice();
    }

    public Bouquet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Flower> getFlowersList() {
        return flowersList;
    }

    public void setFlowersList(List<Flower> flowersList) {
        this.flowersList = flowersList;
    }

    public double getPrice() {
        return price;
    }

    public double setPrice() {
        List<Flower> flowersList = this.getFlowersList();
        for (Flower flower:flowersList ) {
            this.price += flower.getPrice();
        }
        return this.price;
    }
}
