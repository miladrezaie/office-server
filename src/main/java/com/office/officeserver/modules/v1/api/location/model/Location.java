package com.office.officeserver.modules.v1.api.location.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "locations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Location {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "nvarchar(20)")
    private String name;

//    @JsonIgnore
//    @OneToMany(mappedBy = "location")
//    private List<Tajhizat> tajhiz;
//    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
//    private Set<Tajhizat> tajhizats = new HashSet<>();
//    @OneToMany(mappedBy="cart")
//    private Set<Items> items;

    @OneToMany(mappedBy = "location")
//    @JsonBackReference
    private List<Tajhizat> tajhizats;

}
