package com.ipsas.WebService.Services;

import com.ipsas.WebService.Enums.Role;
import com.ipsas.WebService.Models.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class DbInit implements CommandLineRunner {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private ClientService clientService;
    private FloristService floristService;
    private FlowerService flowerService;
    private BouquetService bouquetService;
    private CommandeService commandeService;

    public DbInit(UserService userService, PasswordEncoder passwordEncoder, ClientService clientService, FloristService floristService, FlowerService flowerService, BouquetService bouquetService, CommandeService commandeService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.clientService = clientService;
        this.floristService = floristService;
        this.flowerService = flowerService;
        this.bouquetService = bouquetService;
        this.commandeService = commandeService;
    }

    @Override
    public void run(String... args) {
        Client client = new Client("Skander","Hkacem","SkanderHk", passwordEncoder.encode("12325135"));
        this.clientService.addClient(client);
        Florist florist = new Florist("First","Seller","Seller", passwordEncoder.encode("12325135"));
        this.floristService.addFlorist(florist);
        User admin = new User ("First","Admin","Admin", passwordEncoder.encode("12325135"), Role.ADMIN );
        this.userService.addUser(admin);

        Flower F = new Flower("Red",10.0);
        Flower F1 = new Flower("Pink",13.0);
        Flower F2 = new Flower("Green",15.0);
        List<Flower> flowerList = Arrays.asList(F,F1,F2);
        this.flowerService.addFlowers(flowerList);
        Bouquet B = new Bouquet(flowerList);
        this.bouquetService.addBouquet(B);
        Flower F3 = new Flower("Black",25.0);
        this.flowerService.addFlower(F3);

        Commande C = new Commande(florist,client,Arrays.asList(B),Arrays.asList(F3));
        this.commandeService.addCommande(C);

    }
}
