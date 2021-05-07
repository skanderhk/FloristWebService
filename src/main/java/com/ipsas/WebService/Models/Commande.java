package com.ipsas.WebService.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipsas.WebService.Enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Florist florist;
    @ManyToOne
    private Client client;
    private Status status;
    @OneToMany
    private List<Bouquet> bouquetList;
    @OneToMany
    private List<Flower> flowerList;
    private double total;

    public Commande(Florist florist, Client client, List<Bouquet> bouquetList, List<Flower> flowerList) {
        this.florist = florist;
        this.client = client;
        this.status = Status.PENDING;
        this.bouquetList = bouquetList;
        this.flowerList = flowerList;
        this.total = setTotal();
    }

    public Commande() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Florist getFlorist() {
        return florist;
    }

    public void setFlorist(Florist florist) {
        this.florist = florist;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Bouquet> getBouquetList() {
        return bouquetList;
    }

    public void setBouquetList(List<Bouquet> bouquetList) {
        this.bouquetList = bouquetList;
    }

    public double getTotal() {
        return total;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public double setTotal() {
        List<Bouquet> bouquetList = this.getBouquetList();
        List<Flower> flowerList = this.getFlowerList();
        if (bouquetList.size()!= 0){
            for (Bouquet bouquet: bouquetList){
                this.total += bouquet.getPrice();
            }
        }else this.total += 0;
        if (flowerList.size()!= 0) {
            for (Flower flower : flowerList) {
                this.total += flower.getPrice();
            }
        }else this.total += 0;
        return this.total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
