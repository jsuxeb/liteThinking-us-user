package com.litethinking.msuser.service.impl;

import com.litethinking.msuser.exceptionhandler.ResourceNotFoundException;
import com.litethinking.msuser.model.ClientModel;
import com.litethinking.msuser.repository.ClientRepository;
import com.litethinking.msuser.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<ClientModel> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientModel saveOrUpdate(ClientModel clientModel) {
        if (clientModel.getId() == null) {
            return clientRepository.save(clientModel);
        } else {
            //Actualza el modelo
            Optional<ClientModel> client = clientRepository.findById(clientModel.getId());
            if (client.isPresent()) {
                return clientRepository.save(clientModel);
            } else {
                throw new ResourceNotFoundException("usuario con ID: " + clientModel.getId() + " no encontrado");
            }

        }
    }

    @Override
    public String deleteClient(Long id) {
        return null;
    }

    @Override
    public ClientModel getById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client no encontrado con el ID: " + id));

    }
}
