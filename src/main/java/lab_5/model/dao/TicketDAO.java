package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class TicketDAO implements GeneralDAO<Ticket> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Ticket> findAll() {
        List<Ticket> tickets = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            tickets = session.createQuery("from Ticket").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket findOne(Integer id) {
        Ticket ticket = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ticket = session.get(Ticket.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void create(Ticket ticket) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Ticket ticket) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(ticket);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, id);
            if (ticket != null) {
                session.delete(ticket);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
