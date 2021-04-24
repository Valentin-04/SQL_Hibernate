package models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "mentors")
@Table(name = "mentors")
@Data
public class Mentors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
}
