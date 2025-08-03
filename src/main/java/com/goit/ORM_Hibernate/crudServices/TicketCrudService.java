package com.goit.ORM_Hibernate.crudServices;

import com.goit.ORM_Hibernate.dao.TicketDao;
import com.goit.ORM_Hibernate.dao.impl.TicketDaoImpl;
import com.goit.ORM_Hibernate.entity.Ticket;
import com.goit.ORM_Hibernate.utils.TicketValidator;

import java.util.List;

public class TicketCrudService {

    private final TicketDao dao = new TicketDaoImpl();

    public void create(Ticket ticket) {
        TicketValidator.validate(ticket);
        dao.save(ticket);
    }

    public Ticket read(Long id) {
        return dao.findById(id);
    }

    public List<Ticket> readAll() {
        return dao.findAll();
    }

    public void update(Ticket ticket) {
        TicketValidator.validate(ticket);
        dao.update(ticket);
    }

    public void delete(Long id) {
        dao.deleteById(id);
    }
}
