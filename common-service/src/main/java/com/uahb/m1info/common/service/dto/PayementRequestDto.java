package com.uahb.m1info.common.service.dto;

import com.uahb.m1info.common.service.event.PayementStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayementRequestDto {

    private Long commandeId;
    private Long clientId;
    private int montant;
    private ZonedDateTime created_at;
    private PayementStatus payementStatus;
}
