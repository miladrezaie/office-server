package com.office.officeserver.modules.v1.api.role.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import com.office.officeserver.modules.v1.api.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

//        @JsonIgnore
//    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
//    private List<User> users;


}
