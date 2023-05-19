package com.uahb.m1info.common.service.dto;

import com.uahb.m1info.common.service.event.CommandeStatus;
import com.uahb.m1info.common.service.event.PayementStatus;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {

    private Date date;
    private String adresse;
    private int total;
    private Long idClient;
    private String codeClient;
    private String nomClient;
    private String prenomClient;
    private List<DetailDto> detailDtos;
    private CommandeStatus commandeStatus;
    private PayementStatus payementStatus;



}
