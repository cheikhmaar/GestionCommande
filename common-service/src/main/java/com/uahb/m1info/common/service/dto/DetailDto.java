package com.uahb.m1info.common.service.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DetailDto {

    private String produitId;
    private int prix;
    private int quantite;
    private int sous_total;


}
