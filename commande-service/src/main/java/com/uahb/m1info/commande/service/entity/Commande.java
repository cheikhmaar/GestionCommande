package com.uahb.m1info.commande.service.entity;

import com.uahb.m1info.common.service.event.CommandeStatus;
import com.uahb.m1info.common.service.event.PayementStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Column(length = 30)
    private String adresse;

    @Column(length = 15)
    private int total;

    @OneToMany(mappedBy = "commande",cascade = CascadeType.ALL)
    private List<Detail> detail;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "client_Id")
    private Client client;
    private CommandeStatus commandeStatus;
    private PayementStatus payementStatus;


}
