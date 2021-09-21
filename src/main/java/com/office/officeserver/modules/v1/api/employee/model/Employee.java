package com.office.officeserver.modules.v1.api.employee.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.office.officeserver.modules.v1.api.Job.model.Job;
import com.office.officeserver.modules.v1.api.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name", columnDefinition = "nvarchar(20)")
    private String first_name;

    @Column(name = "last_name", columnDefinition = "nvarchar(20)")
    private String last_name;

    @Column(name = "personal_id", columnDefinition = "nvarchar(30)")
    private String personal_id;

    @Column(name = "mac_address")
    private String mac_address;

    @JsonIgnore
    @Column(columnDefinition = "LONGBLOB")
    private String image;


    @Transient
    @JsonIgnore
    private MultipartFile file;



    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST})
    @JoinTable(
            name = "employee_job",
            joinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            uniqueConstraints = {@UniqueConstraint(columnNames = {"employee_id", "job_id"})})
//    @JsonIgnoreProperties("employees")
    private List<Job> jobs;




//    @ManyToOne(fetch = FetchType.LAZY)
//    private Post post;


}
