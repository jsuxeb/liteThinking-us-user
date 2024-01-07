package com.litethinking.msuser.controller;

import com.litethinking.msuser.model.ClientModel;
import com.litethinking.msuser.service.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;

    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientModel>> listar() {
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> guardar(@RequestBody ClientModel client) {
        return ResponseEntity.ok(clientService.saveOrUpdate(client));
    }

    @DeleteMapping(path = "/eliminar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.deleteClient(id));
    }

    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientModel> actualizar(@RequestBody ClientModel cliente) {
        return ResponseEntity.ok(clientService.saveOrUpdate(cliente));
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ClientModel> obtenerId(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getById(id));
    }
}
