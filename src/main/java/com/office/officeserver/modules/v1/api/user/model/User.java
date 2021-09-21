package com.office.officeserver.modules.v1.api.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.office.officeserver.modules.v1.api.employee.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name = "personal_id", columnDefinition = "nvarchar(10)", unique = true)
    private String personal_id;


    @Column(name = "first_name", columnDefinition = "nvarchar(20)")
    private String first_name;


    @Column(name = "last_name", columnDefinition = "nvarchar(20)")
    private String Last_name;


    @Column(columnDefinition = "nvarchar(25)")
    private String full_name;


    @Column(columnDefinition = "nvarchar(10)")
    private String finger;


    @Column(columnDefinition = "nvarchar(20)")
    private String job;


    @Column(name = "active")
    private int active;


    @Column(name = "created_at", updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;


    @Column(name = "updated_at")
    @CreationTimestamp
    private LocalDateTime updatedAt;


    @Column(columnDefinition = "LONGBLOB")
    @JsonIgnore
    private String emza;


    @Column(name = "password")
    @JsonIgnore
    private String pass;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Employee> employees;


//    @ManyToMany(cascade = {CascadeType.DETACH,
//            CascadeType.MERGE,
//            CascadeType.REFRESH,
//            CascadeType.PERSIST})
//    @JoinTable(
//            name = "role_user",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role_id"})})
////    @JsonIgnoreProperties("employees")
//    private List<Role> roles;
}
