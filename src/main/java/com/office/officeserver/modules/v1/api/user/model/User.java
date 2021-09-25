package com.office.officeserver.modules.v1.api.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.office.officeserver.modules.v1.api.employee.model.Employee;
import com.office.officeserver.modules.v1.api.role.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.*;
import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "username", columnDefinition = "nvarchar(10)", unique = true)
    @NotBlank
    private String username;


    @Column(name = "first_name", columnDefinition = "nvarchar(20)")
    private String first_name;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


//    @NotBlank
//    @Pattern(regexp = "(^$|[0-9]{10})")
    private String mobile;

    @Column(name = "last_name", columnDefinition = "nvarchar(20)")
    private String Last_name;


    @Column(columnDefinition = "nvarchar(10)")
    private String finger;


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
    @NotBlank
    @Size(max = 120)
    private String password;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Employee> employees;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


}
