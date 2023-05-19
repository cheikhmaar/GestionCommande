package com.uahb.m1info.commande.service.controller;

import com.uahb.m1info.commande.service.entity.Commande;
import com.uahb.m1info.commande.service.service.CommandeService;
import com.uahb.m1info.commande.service.service.exception.CommandeException;
import com.uahb.m1info.common.service.dto.CommandeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public ResponseEntity<Commande> saveCommande(@RequestBody CommandeDto commandeDto) throws CommandeException {
        return ResponseEntity.ok(commandeService.processCommande(commandeDto));

        //return new ResponseEntity<>(commandeService.processCommande(commandeDto), HttpStatus.OK);
    }
}
