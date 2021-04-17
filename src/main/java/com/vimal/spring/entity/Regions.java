package com.vimal.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="regions")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Regions {
    @Id
    @GeneratedValue
    @Column(name = "region_id",length = 11)
    private Integer regionId;
    @Column(name ="region_name",length = 25,nullable = true)
    private String regionName;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "regions")
    @JsonIgnore
    private List<Country> countries;
}