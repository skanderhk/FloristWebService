package com.ipsas.WebService.Services;

import com.ipsas.WebService.Models.Client;
import com.ipsas.WebService.Repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepo;

    @Autowired
    public ClientService(ClientRepository clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client C){
        return clientRepo.save(C);
    }

    public List<Client> addClients(List<Client> clientList){
        return clientRepo.saveAll(clientList);
    }

    public List<Client> findAll(){
        return clientRepo.findAll();
    }

    public Client findOneById(Long id){
        return clientRepo.findById(id).orElseThrow(()-> new RuntimeException("Client by id : "+id+" is not found !" ));
    }

    public Client updateClient(Client E){
        return clientRepo.save(E);
    }

    public void deleteClient(Long id){
        clientRepo.deleteById(id);
    }



}
