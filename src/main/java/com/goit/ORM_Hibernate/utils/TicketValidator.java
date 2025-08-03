package com.goit.ORM_Hibernate.utils;


import com.goit.ORM_Hibernate.entity.Ticket;

public class TicketValidator {

    public static void validate(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket must not be null");
        }

        if (ticket.getClient() == null || ticket.getClient().getId() == null) {
            throw new IllegalArgumentException("Ticket must have a valid client");
        }

        if (ticket.getFromPlanet() == null || ticket.getFromPlanet().getId() == null) {
            throw new IllegalArgumentException("Ticket must have a valid fromPlanet");
        }

        if (ticket.getToPlanet() == null || ticket.getToPlanet().getId() == null) {
            throw new IllegalArgumentException("Ticket must have a valid toPlanet");
        }
    }
}