package lab_5.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Scanner;

@Data
@Entity
@Table(name = "artist")
@Accessors(chain = true)
@NoArgsConstructor
public class Artist {


    private static final Scanner scanner = new Scanner(System.in);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "alias")
    private String alias;

    public Artist(String name, String surname, Integer age, String alias) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.alias = alias;
    }
}

