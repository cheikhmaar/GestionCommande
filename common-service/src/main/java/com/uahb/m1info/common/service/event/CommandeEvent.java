package com.uahb.m1info.common.service.event;

import com.uahb.m1info.common.service.dto.CommandeDto;

import java.util.Date;
import java.util.UUID;

public class CommandeEvent implements Event{

    private UUID eventId = UUID.randomUUID();
    private Date eventDate = new Date();
    private CommandeDto commandeDto;
    private CommandeStatus commandeStatus;

    public CommandeEvent(CommandeDto commandeDto, CommandeStatus commandeStatus) {
        this.commandeDto = commandeDto;
        this.commandeStatus = commandeStatus;
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
