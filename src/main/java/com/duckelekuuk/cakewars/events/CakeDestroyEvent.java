package com.duckelekuuk.cakewars.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CakeDestroyEvent extends Event {

    private static final HandlerList HANDLERLIST = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERLIST;
    }

    public static HandlerList getHandlerlist() {
        return HANDLERLIST;
    }
}
