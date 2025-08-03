package com.goit.ORM_Hibernate.dao;

import com.goit.ORM_Hibernate.entity.Ticket;

import java.util.List;

public interface TicketDao {
    void save(Ticket ticket);

    Ticket findById(Long id);

    List<Ticket> findAll();

    void update(Ticket ticket);

    void deleteById(Long id);
}
