package com.vimal.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "countries")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Country {
    @Id
    @Column(name = "country_id", length = 2)
    private String CountryId;
    @Column(name = "country_name", length = 40)
    private String countryName;
    @ManyToOne
    @JoinColumn(name = "region_id",nullable = false)
    private Regions regions;
    @OneToMany(mappedBy = "country",cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Locations> locations;

    //@JsonBackReference
    public List<Locations> getLocations() {
        return locations;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }
}

