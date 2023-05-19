package com.uahb.m1info.commande.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Builder;

import java.io.Serializable;

@Embeddable
@Builder
public class CommandeProduitId implements Serializable {

    @Column(name = "produit_id")
    private long produit_id;

    @Column(name = "commande_id")
    private long commande_id;

    public long getProduit_id() {
        return produit_id;
    }

    public void setProduit_id(int produit_id) {
        this.produit_id = produit_id;
    }

    public long getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public void setProduit_id(long produit_id) {
        this.produit_id = produit_id;
    }

    public void setCommande_id(long commande_id) {
        this.commande_id = commande_id;
    }
}
