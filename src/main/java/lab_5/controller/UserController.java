package lab_5.controller;

import lab_5.model.dao.UserDAO;
import lab_5.model.entity.User;

import java.util.List;

public class UserController implements GeneralController<User> {


    UserDAO artistDAO = new UserDAO();

    @Override
    public List<User> findAll() {
        return artistDAO.findAll();
    }

    @Override
    public User findOne(Integer id) {
        return artistDAO.findOne(id);

    }

    @Override
    public void create(User user) {
        artistDAO.create(user);

    }

    @Override
    public void update(Integer id, User user) {
        artistDAO.update(id, user);

    }

    @Override
    public void delete(Integer id) {
        artistDAO.delete(id);

    }
}
