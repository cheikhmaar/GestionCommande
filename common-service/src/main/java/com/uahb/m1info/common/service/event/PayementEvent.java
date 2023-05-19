package com.uahb.m1info.common.service.event;

import com.uahb.m1info.common.service.dto.PayementRequestDto;

import java.util.Date;
import java.util.UUID;

public class PayementEvent implements Event{

    private UUID eventId = UUID.randomUUID();
    private Date eventDate = new Date();
    private PayementRequestDto payementRequestDto;
    private PayementStatus payementStatus;

    public PayementEvent(PayementRequestDto payementRequestDto, PayementStatus payementStatus) {
        this.payementRequestDto = payementRequestDto;
        this.payementStatus = payementStatus;
    }

    @Override
    public UUID getEventId() {
        return eventId;
    }

    @Override
    public Date getEventDate() {
        return eventDate;
    }
}
