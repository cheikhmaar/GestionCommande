package com.uahb.m1info.commande.service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long produitId;

    @Column(length = 30)
    private String nom;

    @Column(length = 15)
    private float prix;

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<Detail> details;


}
