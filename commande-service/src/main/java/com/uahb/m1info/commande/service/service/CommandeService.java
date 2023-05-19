package com.uahb.m1info.commande.service.service;

import com.uahb.m1info.commande.service.entity.Client;
import com.uahb.m1info.commande.service.entity.Commande;
import com.uahb.m1info.commande.service.mapper.CommandeMapper;
import com.uahb.m1info.commande.service.repository.ClientRepository;
import com.uahb.m1info.commande.service.repository.CommandeRepository;
import com.uahb.m1info.commande.service.repository.ProduitRepository;
import com.uahb.m1info.commande.service.service.exception.CommandeException;
import com.uahb.m1info.common.service.dto.CommandeDto;
import com.uahb.m1info.common.service.event.CommandeStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final ProduitRepository produitRepository;
    private final ClientRepository clientRepository;
    private final CommandeMapper commandeMapper;

    public CommandeService(CommandeRepository commandeRepository, ProduitRepository produitRepository, ClientRepository clientRepository, CommandeMapper commandeMapper) {
        this.commandeRepository = commandeRepository;
        this.produitRepository = produitRepository;
        this.clientRepository = clientRepository;
        this.commandeMapper = commandeMapper;
    }

    public Commande processCommande(CommandeDto commandeDto) throws CommandeException {
        Commande commande = commandeMapper.commandeDtoToCommandeEntity(commandeDto);
        //Rattacher les produits
        commande.setDetail(
                commande.getDetail().stream().map(detail -> {
                    detail.setProduit(produitRepository.findById(detail.getProduit().getProduitId()).get());
                    detail.setCommande(commande);
                    return detail;
                }
            ).toList()
        );

        //Initialiser le status de la commande
        commande.setCommandeStatus(CommandeStatus.COMMANDE_CREATED);
        //gestion du client
        Client client = clientRepository.findByCode(commandeDto.getCodeClient());
        if (client == null){
           client = commandeMapper.clientDtoToClientEntity(commandeDto);
        }

        commande.setClient(client);
        validatPrix(commande);
        return commandeRepository.save(commande);
    }

    private void validatPrix(Commande commande) throws CommandeException {
        int total = commande.getDetail().stream().map(detail -> detail.getPrix()*detail.getQuantite()
        ).reduce(0,(a,b)->a+b);
        if (total != commande.getTotal()){
            log.info("prix total invalid");
            throw new CommandeException("prix total invalid");
        }
    }
}
