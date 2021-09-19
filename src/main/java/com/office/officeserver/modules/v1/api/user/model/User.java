package com.office.officeserver.modules.v1.api.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer id;

    @NotEmpty(message = "*Please provide your personal id")
    @Column(name = "personal_id", columnDefinition="nvarchar(10)")
    private String personalId;

    @Column(name = "name", columnDefinition="nvarchar(20)")
    @NotEmpty(message = "*Please provide your first name")
    private String FName;

    @Column(name = "last_name", columnDefinition="nvarchar(20)")
    @NotEmpty(message = "*Please provide your last name")
    private String Lname;

    @Column(columnDefinition="nvarchar(25)")
    private String fullname;

    @Column(columnDefinition="nvarchar(2)")
    private String finger;

    @Column(columnDefinition="nvarchar(20)")
    private String job;

    @Column(name = "active")
    private int active;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;


    @Column(columnDefinition="LONGBLOB")
    @JsonIgnore
    private String emza;

    @Column(name = "password" )
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @JsonIgnore
    private String pass;

}
