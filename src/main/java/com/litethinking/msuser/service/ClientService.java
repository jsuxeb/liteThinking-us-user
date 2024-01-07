package com.litethinking.msuser.service;

import com.litethinking.msuser.model.ClientModel;

import java.util.List;


public interface ClientService {

    List<ClientModel> getAllClients();

    ClientModel saveOrUpdate(ClientModel clientModel);

    String deleteClient(Long id);

    ClientModel getById(Long id);
}
