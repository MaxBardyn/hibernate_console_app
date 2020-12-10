package lab_5.controller;



import lab_5.model.dao.EventDAO;
import lab_5.model.entity.Event;

import java.util.List;

public class EventController implements GeneralController<Event> {


    EventDAO eventDAO = new EventDAO();

    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    @Override
    public Event findOne(Integer id) {
        return eventDAO.findOne(id);
    }

    @Override
    public void create(Event event) {
        eventDAO.create(event);
    }

    @Override
    public void update(Integer id, Event event) {
        eventDAO.update(id, event);
    }

    @Override
    public void delete(Integer id) {
        eventDAO.delete(id);
    }
}
