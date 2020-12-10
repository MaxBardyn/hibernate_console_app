package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;
import java.util.Set;

@Data
@Entity
@Table(name = "event")
@Accessors(chain = true)
@NoArgsConstructor
public class Event {


    private static final Scanner SCANNER = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private Location locationId;

    @OneToOne
    @JoinColumn(name = "artist_id", referencedColumnName = "id", nullable = false)
    private Artist artistId;

    @OneToMany(mappedBy = "eventId", fetch = FetchType.EAGER)
    private Set<Ticket> tickets;

    public Event(String name, Location locationId, Artist artistId) {
        this.name = name;
        this.locationId = locationId;
        this.artistId = artistId;
    }
}
