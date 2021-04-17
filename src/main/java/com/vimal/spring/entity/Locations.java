package com.vimal.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "locations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Locations {
    @Id
    @GeneratedValue
    @Column(name = "location_id",length = 11)
    private Integer locationId;
    @Column(name = "street_address",length = 40)
    private String streetAddress;
    @Column(name = "postal_code",length = 12)
    private String postalCode;
    @Column(name = "city",length = 30)
    private String city;
    @Column(name = "state_province",length = 25)
    private String stateProvince;
    @ManyToOne
    @JoinColumn(name = "country_id",nullable = false)

    private Country country;

    //@JsonManagedReference
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}


//    CREATE TABLE locations (
//        location_id INT (11) AUTO_INCREMENT PRIMARY KEY,
//    street_address VARCHAR (40) DEFAULT NULL,
//    postal_code VARCHAR (12) DEFAULT NULL,
//    city VARCHAR (30) NOT NULL,
//    state_province VARCHAR (25) DEFAULT NULL,
//    country_id CHAR (2) NOT NULL,
//    FOREIGN KEY (country_id) REFERENCES countries (country_id) ON DELETE CASCADE ON UPDATE CASCADE
//        );