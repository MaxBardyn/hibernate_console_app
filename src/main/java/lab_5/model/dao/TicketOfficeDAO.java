package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.TicketOffice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class TicketOfficeDAO implements GeneralDAO<TicketOffice> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<TicketOffice> findAll() {
        List<TicketOffice> ticketOffices = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ticketOffices = session.createQuery("from TicketOffice").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketOffices;
    }

    @Override
    public TicketOffice findOne(Integer id) {
        TicketOffice ticketOffice = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            ticketOffice = session.get(TicketOffice.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticketOffice;
    }

    @Override
    public void create(TicketOffice ticketOffice) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(ticketOffice);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, TicketOffice ticketOffice) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(ticketOffice);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            TicketOffice ticketOffice = session.get(TicketOffice.class, id);
            if (ticketOffice != null) {
                session.delete(ticketOffice);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
