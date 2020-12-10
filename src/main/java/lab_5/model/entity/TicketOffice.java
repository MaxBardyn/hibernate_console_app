package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;

@Data
@Entity
@Table(name = "ticket_office")
@Accessors(chain = true)
@NoArgsConstructor
public class TicketOffice {


    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @OneToMany(mappedBy = "ticketOfficeId", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    public TicketOffice(Location location) {
        this.location = location;
    }
}
