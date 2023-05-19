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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 40, nullable = false)
    private String code;

    @Column(length = 40, nullable = false)
    private String nom;

    @Column(length = 40, nullable = false)
    private String prenom;

    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

}
