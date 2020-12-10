package lab_5.model.dao;

import lab_5.DatabaseConnector;
import lab_5.model.entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class LocationDAO implements GeneralDAO<Location> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Location> findAll() {
        List<Location> locations = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            locations = session.createQuery("from Location").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return locations;
    }

    @Override
    public Location findOne(Integer id) {
        Location location = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            location = session.get(Location.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    @Override
    public void create(Location location) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(location);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Location location) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(location);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Location location = session.get(Location.class, id);
            if (location != null) {
                session.delete(location);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
