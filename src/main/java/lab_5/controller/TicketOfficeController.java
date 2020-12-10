package lab_5.controller;


import lab_5.model.dao.TicketOfficeDAO;
import lab_5.model.entity.TicketOffice;

import java.util.List;

public class TicketOfficeController implements GeneralController<TicketOffice> {


    TicketOfficeDAO ticketOfficeDAO = new TicketOfficeDAO();

    @Override
    public List<TicketOffice> findAll() {
        return ticketOfficeDAO.findAll();
    }

    @Override
    public TicketOffice findOne(Integer id) {
        return ticketOfficeDAO.findOne(id);
    }

    @Override
    public void create(TicketOffice ticketOffice) {
        ticketOfficeDAO.create(ticketOffice);
    }

    @Override
    public void update(Integer id, TicketOffice ticketOffice) {
        ticketOfficeDAO.update(id, ticketOffice);
    }

    @Override
    public void delete(Integer id) {
        ticketOfficeDAO.delete(id);
    }
}
