package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Artist;
import lab_5.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class UserDAO implements GeneralDAO<User> {


    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<User> findAll() {
        List<User> userArrayList = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            userArrayList = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userArrayList;
    }

    @Override
    public User findOne(Integer id) {
        User user = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, User user) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Artist artist = session.get(Artist.class, id);
            if (artist != null) {
                session.delete(artist);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
