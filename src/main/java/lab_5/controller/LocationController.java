package lab_5.controller;



import lab_5.model.dao.LocationDAO;
import lab_5.model.entity.Location;

import java.util.List;

public class LocationController implements GeneralController<Location> {


    LocationDAO locationDAO = new LocationDAO();

    @Override
    public List<Location> findAll() {
        return locationDAO.findAll();
    }

    @Override
    public Location findOne(Integer id) {
        return locationDAO.findOne(id);
    }

    @Override
    public void create(Location location) {
        locationDAO.create(location);
    }

    @Override
    public void update(Integer id, Location location) {
        locationDAO.update(id, location);
    }

    @Override
    public void delete(Integer id) {
        locationDAO.delete(id);
    }
}
