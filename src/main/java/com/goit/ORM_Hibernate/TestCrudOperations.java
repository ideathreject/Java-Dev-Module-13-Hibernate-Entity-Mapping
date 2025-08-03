package com.goit.ORM_Hibernate;

import com.goit.ORM_Hibernate.crudServices.ClientCrudService;
import com.goit.ORM_Hibernate.crudServices.PlanetCrudService;
import com.goit.ORM_Hibernate.crudServices.TicketCrudService;
import com.goit.ORM_Hibernate.entity.Client;
import com.goit.ORM_Hibernate.entity.Planet;
import com.goit.ORM_Hibernate.entity.Ticket;

import java.util.List;


public class TestCrudOperations {
    public static void main(String[] args) {

        TicketCrudService ticketService = new TicketCrudService();

        //Create
        Ticket newTicket = new Ticket();
        newTicket.setClient(new Client(1L, null, null));
        newTicket.setFromPlanet(new Planet("EARTH", null));
        newTicket.setToPlanet(new Planet("MARS", null));


        //Delete
        ticketService.delete(4L);

        //Read
        List<Ticket> allTickets = ticketService.readAll();
        System.out.println("All tickets:");
        allTickets.forEach(System.out::println);



    }
}
