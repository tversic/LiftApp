package com.liftapp.model.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LU_JOB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "location")
    String location;

    @OneToOne
    @JoinColumn(name = "driver_id", referencedColumnName = "id")
    User driver;

    @OneToOne
    @JoinColumn(name ="issuer_id", referencedColumnName = "id")
    User issuer;
}
