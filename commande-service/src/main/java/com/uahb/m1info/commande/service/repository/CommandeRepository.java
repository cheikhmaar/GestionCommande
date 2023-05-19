package com.uahb.m1info.commande.service.repository;

import com.uahb.m1info.commande.service.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository <Commande, Long> {
}
