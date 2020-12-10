package lab_5.view;

import lab_5.controller.*;
import lab_5.model.entity.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {


    private static final Scanner SCANNER = new Scanner(System.in);
    private final Map<String, Printable> menu = new LinkedHashMap<>();

    private final UserController userController = new UserController();
    private final ArtistController artistController = new ArtistController();
    private final EventController eventController = new EventController();
    private final LocationController locationController = new LocationController();
    private final TicketController ticketController = new TicketController();
    private final TicketOfficeController ticketOfficeController = new TicketOfficeController();


    public View() {

        menu.put("11", this::getAllUsers);
        menu.put("12", this::getUserById);
        menu.put("13", this::createUser);
        menu.put("14", this::updateUser);
        menu.put("15", this::deleteUser);

        menu.put("21", this::getAllArtists);
        menu.put("22", this::getArtistById);
        menu.put("23", this::createArtist);
        menu.put("24", this::updateArtist);
        menu.put("25", this::deleteArtist);

        menu.put("31", this::getAllEvents);
        menu.put("32", this::getEventById);
        menu.put("33", this::createEvent);
        menu.put("34", this::updateEvent);
        menu.put("35", this::deleteEvent);

        menu.put("41", this::getAllLocations);
        menu.put("42", this::getLocationById);
        menu.put("43", this::createLocation);
        menu.put("44", this::updateLocation);
        menu.put("45", this::deleteLocation);

        menu.put("51", this::getAllTickets);
        menu.put("52", this::getTicketById);
        menu.put("53", this::createTicket);
        menu.put("54", this::updateTicket);
        menu.put("55", this::deleteTicket);

        menu.put("61", this::getAllTicketOffices);
        menu.put("62", this::getTicketOfficeById);
        menu.put("63", this::createTicketOffice);
        menu.put("64", this::updateTicketOffice);
        menu.put("65", this::deleteTicketOffice);
    }

    public final void show() {
        String input;
        Menu showMenu = new Menu();
        showMenu.displayMenu();
        System.out.println("\nEnter combination:\n");
        do {
            try {
                input = SCANNER.next();
                menu.get(input).print();
            } catch (Exception ignored) {
            }
        } while (SCANNER.hasNext());
    }

    //========================== USER =================================

    private void getAllUsers() {
        System.out.println("\nGetting users...");
        System.out.println(userController.findAll() + "\n");
    }

    private void getUserById() {
        System.out.println("\nEnter user ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(userController.findOne(id) + "\n");
    }

    private User getUserInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        return new User(name, surname, age);
    }

    private void createUser() {
        System.out.println("\nCreating user...");
        User user = getUserInputs();
        userController.create(user);
        System.out.println("User has been created!\n");
    }

    private void updateUser() {
        System.out.println("\nUpdating user... Enter ID: ");
        Integer id = SCANNER.nextInt();
        User user = getUserInputs()
                .setId(id);

        userController.update(user.getId(), user);
        System.out.println("User with Id=" + id + " has been updated\n");
    }

    private void deleteUser() {
        System.out.println("\nDeleting user... Enter ID: ");
        int id = SCANNER.nextInt();

        userController.delete(id);
        System.out.println("User with ID=" + id + " has been deleted\n");
    }


//========================== ARTIST =================================

    private void getAllArtists() {
        System.out.println("\nGetting artists...");
        System.out.println(artistController.findAll() + "\n");
    }

    private void getArtistById() {
        System.out.println("\nEnter artist ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(artistController.findOne(id) + "\n");
    }

    private Artist getArtistInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("Enter surname: ");
        String surname = SCANNER.next();
        System.out.println("Enter age: ");
        Integer age = SCANNER.nextInt();
        System.out.println("Enter alias: ");
        String alias = SCANNER.next();
        return new Artist(name, surname, age, alias);
    }

    private void createArtist() {
        System.out.println("\nCreating artist...");
        Artist artist = getArtistInputs();
        artistController.create(artist);
        System.out.println("Artist has been created!\n");
    }

    private void updateArtist() {
        System.out.println("\nUpdating artist... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Artist artist = getArtistInputs()
                .setId(id);

        artistController.update(artist.getId(), artist);
        System.out.println("Artist with Id=" + id + " has been updated\n");
    }

    private void deleteArtist() {
        System.out.println("\nDeleting artist... Enter ID: ");
        int id = SCANNER.nextInt();

        artistController.delete(id);
        System.out.println("Artist with ID=" + id + " has been deleted\n");
    }

    //========================== EVENT =================================

    private void getAllEvents() {
        System.out.println("\nGetting events...");
        System.out.println(eventController.findAll() + "\n");
    }

    private void getEventById() {
        System.out.println("\nEnter event ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(eventController.findOne(id) + "\n");
    }

    public Event getEventInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter location_id: ");
        Integer locationId = SCANNER.nextInt();
        Location location = locationController.findOne(locationId);
        System.out.println("\nEnter artist_id: ");
        Integer artistId = SCANNER.nextInt();
        Artist artist = artistController.findOne(artistId);
        return new Event(name, location, artist);
    }

    private void createEvent() {
        System.out.println("\nCreating event...");
        Event event = getEventInputs();
        eventController.create(event);
        System.out.println("Event has been created!\n");
    }

    private void updateEvent() {
        System.out.println("\nUpdating event... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Event event = getEventInputs()
                .setId(id);

        eventController.update(event.getId(), event);
        System.out.println("Event with Id=" + id + " has been updated\n");
    }

    private void deleteEvent() {
        System.out.println("\nDeleting event... Enter ID: ");
        int id = SCANNER.nextInt();

        eventController.delete(id);
        System.out.println("Event with ID=" + id + " has been deleted\n");
    }

//    //========================== LOCATION =================================


    private void getAllLocations() {
        System.out.println("\nGetting locations...");
        System.out.println(locationController.findAll() + "\n");
    }

    private void getLocationById() {
        System.out.println("\nEnter location ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(locationController.findOne(id) + "\n");
    }

    public Location getLocationInputs() {
        System.out.println("\nEnter name: ");
        String name = SCANNER.next();
        System.out.println("\nEnter address: ");
        String address = SCANNER.next();
        return new Location(name, address);
    }

    private void createLocation() {
        System.out.println("\nCreating location...");
        Location location = getLocationInputs();
        locationController.create(location);
        System.out.println("Location has been created!\n");
    }

    private void updateLocation() {
        System.out.println("\nUpdating location... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Location location = getLocationInputs()
                .setId(id);

        locationController.update(location.getId(), location);
        System.out.println("Location with Id=" + id + " has been updated\n");
    }

    private void deleteLocation() {
        System.out.println("\nDeleting location... Enter ID: ");
        int id = SCANNER.nextInt();

        locationController.delete(id);
        System.out.println("Location with ID=" + id + " has been deleted\n");
    }

//    //========================== TICKET =================================

    private void getAllTickets() {
        System.out.println("\nGetting tickets...");
        System.out.println(ticketController.findAll() + "\n");
    }

    private void getTicketById() {
        System.out.println("\nEnter ticket ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ticketController.findOne(id) + "\n");
    }


    private Ticket getTicketInputs() {
        System.out.println("\nEnter price: ");
        Integer price = SCANNER.nextInt();
        System.out.println("\nEnter sector: ");
        String sector = SCANNER.next();
        System.out.println("\nEnter place_number: ");
        String placeNumber = SCANNER.next();
        System.out.println("\nEnter event_id: ");
        Integer eventId = SCANNER.nextInt();
        System.out.println("\nEnter ticket_office_id: ");
        Integer ticketOfficeId = SCANNER.nextInt();
        return new Ticket(price, sector, placeNumber, eventId, ticketOfficeId);
    }

    private void createTicket() {
        System.out.println("\nCreating ticket...");
        Ticket ticket = getTicketInputs();
        ticketController.create(ticket);
        System.out.println("Ticket has been created!\n");
    }

    private void updateTicket() {
        System.out.println("\nUpdating ticket... Enter ID: ");
        Integer id = SCANNER.nextInt();
        Ticket ticket = getTicketInputs()
                .setId(id);

        ticketController.update(ticket.getId(), ticket);
        System.out.println("Ticket with Id=" + id + " has been updated\n");
    }

    private void deleteTicket() {
        System.out.println("\nDeleting ticket... Enter ID: ");
        int id = SCANNER.nextInt();

        ticketController.delete(id);
        System.out.println("Ticket with ID=" + id + " has been deleted\n");
    }

//    //========================== TICKET OFFICE =================================


    private void getAllTicketOffices() {
        System.out.println("\nGetting offices...");
        System.out.println(ticketOfficeController.findAll() + "\n");
    }

    private void getTicketOfficeById() {
        System.out.println("\nEnter office ID: ");
        Integer id = SCANNER.nextInt();
        System.out.println(ticketOfficeController.findOne(id) + "\n");
    }

    public TicketOffice getTicketOfficeInputs() {
        System.out.println("\nEnter location_id: ");
        Integer locationId = SCANNER.nextInt();
        Location location = locationController.findOne(locationId);
        return new TicketOffice(location);
    }

    private void createTicketOffice() {
        System.out.println("\nCreating office...");
        TicketOffice ticketOffice = getTicketOfficeInputs();
        ticketOfficeController.create(ticketOffice);
        System.out.println("Office has been created!\n");
    }

    private void updateTicketOffice() {
        System.out.println("\nUpdating office... Enter ID: ");
        Integer id = SCANNER.nextInt();
        TicketOffice ticketOffice = getTicketOfficeInputs()
                .setId(id);

        ticketOfficeController.update(ticketOffice.getId(), ticketOffice);
        System.out.println("Office with Id=" + id + " has been updated\n");
    }

    private void deleteTicketOffice() {
        System.out.println("\nDeleting office... Enter ID: ");
        int id = SCANNER.nextInt();

        ticketOfficeController.delete(id);
        System.out.println("Office with ID=" + id + " has been deleted\n");
    }
}
