package com.goit.ORM_Hibernate.dao.impl;

import com.goit.ORM_Hibernate.entity.Ticket;
import com.goit.ORM_Hibernate.utils.HibernateUtil;
import com.goit.ORM_Hibernate.dao.TicketDao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class TicketDaoImpl implements TicketDao {

    @Override
    public void save(Ticket ticket) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(ticket);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public Ticket findById(Long id) {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public List<Ticket> findAll() {
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            return session.createQuery("from Ticket", Ticket.class).list();
        }
    }

    @Override
    public void update(Ticket ticket) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(ticket);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getInstance().getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.remove(ticket);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}
