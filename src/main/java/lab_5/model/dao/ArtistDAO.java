package lab_5.model.dao;


import lab_5.DatabaseConnector;
import lab_5.model.entity.Artist;
import lab_5.model.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unchecked"})
public class ArtistDAO implements GeneralDAO<Artist> {

    protected final SessionFactory sessionFactory = DatabaseConnector.getSessionFactory();

    @Override
    public List<Artist> findAll() {
        List<Artist> artists = new ArrayList<>();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artists = session.createQuery("from Artist").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artists;
    }


    @Override
    public Artist findOne(Integer id) {
        Artist artist = null;
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            artist = session.get(Artist.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return artist;
    }

    @Override
    public void create(Artist artist) {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(artist);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Artist artist) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.update(artist);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                session.delete(user);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




