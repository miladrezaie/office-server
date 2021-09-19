package com.office.officeserver.modules.v1.api.employee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tajhizats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "nvarchar(20)")
    private String name;

    @Column(columnDefinition = "nvarchar(30)")
    private String amvalid;

    @Column(columnDefinition = "nvarchar(20)")
    private String type;

    @Column(columnDefinition = "nvarchar(20)")
    private String daste;

    @Column(columnDefinition = "LONGBLOB")
    private String image;
}
