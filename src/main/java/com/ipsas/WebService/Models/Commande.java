package com.ipsas.WebService.Models;

import com.ipsas.WebService.Enums.Status;

import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Florist florist;
    @OneToOne
    private Client client;
    private Status status;
    @OneToMany
    private List<Bouquet> bouquetList;
    private double total;

    public Commande(Florist florist, Client client, Status status, List<Bouquet> bouquetList) {
        this.florist = florist;
        this.client = client;
        this.status = Status.NOT_SHIPPED;
        this.bouquetList = bouquetList;
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

    public void setTotal() {
        List<Bouquet> bouquetList = this.getBouquetList();
        for (Bouquet bouquet: bouquetList){
            this.total += bouquet.getPrice();
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
