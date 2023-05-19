package com.uahb.m1info.common.service.event;

import java.util.Date;
import java.util.UUID;

public interface Event {

    UUID getEventId();
    Date getEventDate();
}
