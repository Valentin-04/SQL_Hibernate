package models;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "students")
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Column(name = "mentor_id")
    int mentorId;
}
