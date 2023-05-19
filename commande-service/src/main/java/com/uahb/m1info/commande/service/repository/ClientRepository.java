package com.uahb.m1info.commande.service.repository;

import com.uahb.m1info.commande.service.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client, Long> {

    Client findByCode(String Code);
}
