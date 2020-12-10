package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "ticket")
@Accessors(chain = true)
@NoArgsConstructor
public class Ticket {


    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "sector")
    private String sector;

    @Column(name = "place_number")
    private String placeNumber;

    @Column(name = "event_id")
    private Integer eventId;

    @Column(name = "ticket_office_id")
    private Integer ticketOfficeId;

    public Ticket(Integer price, String sector, String placeNumber, Integer eventId, Integer ticketOfficeId) {
        this.price = price;
        this.sector = sector;
        this.placeNumber = placeNumber;
        this.eventId = eventId;
        this.ticketOfficeId = ticketOfficeId;
    }
}
