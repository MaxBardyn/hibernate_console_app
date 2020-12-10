package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Event;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class EventDAO implements GeneralDAO<Event> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            events = session.createQuery("from Event").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public Event findOne(Integer id) {
        Event event = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            event = session.get(Event.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public void create(Event event) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(event);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Event event) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(event);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Event event = session.get(Event.class, id);
            if (event != null) {
                session.delete(event);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
