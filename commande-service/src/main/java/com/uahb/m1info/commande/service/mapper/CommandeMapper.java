package com.uahb.m1info.commande.service.mapper;

import com.uahb.m1info.commande.service.entity.Client;
import com.uahb.m1info.commande.service.entity.Commande;
import com.uahb.m1info.commande.service.entity.Detail;
import com.uahb.m1info.commande.service.entity.Produit;
import com.uahb.m1info.commande.service.repository.ProduitRepository;
import com.uahb.m1info.common.service.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandeMapper {

    @Autowired
    ProduitRepository produitRepository;

    public Client clientDtoToClientEntity(CommandeDto commandeDto){
        return new Client(commandeDto.getIdClient(),commandeDto.getCodeClient(),commandeDto.getNomClient(),commandeDto.getPrenomClient(),null);
    }

    public Commande commandeDtoToCommandeEntity(CommandeDto commandeDto){
        List<Detail> detail = commandeDto.getDetailDtos().stream().map(detailDto -> {
            Produit produit = produitRepository.findById(Long.parseLong(detailDto.getProduitId())).get();
            return new Detail(null, null, produit, detailDto.getPrix(),detailDto.getQuantite(),detailDto.getSous_total());
        }).toList();

        Commande cmd = new Commande(null, commandeDto.getDate(), commandeDto.getAdresse(),commandeDto.getTotal(),detail,clientDtoToClientEntity(commandeDto), commandeDto.getCommandeStatus(),commandeDto.getPayementStatus());
        cmd.setDetail(detail.stream().map(detailEntity -> {
            detailEntity.setCommande(cmd);
            return detailEntity;
        }).toList());
        return cmd;
    }

}
