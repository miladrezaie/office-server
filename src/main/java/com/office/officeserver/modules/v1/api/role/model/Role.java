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

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition="nvarchar(20)")
    private String nameBarname;

    @Column(columnDefinition="nvarchar(20)")
    private String tahayekonande;

    @Column(columnDefinition="nvarchar(50)")
    private String tarikh;

    @Column(columnDefinition="nvarchar(50)")
    private String tarikhsodur;

    @Column(columnDefinition="nvarchar(50)")
    private String saat;

    @Column(columnDefinition="nvarchar(25)")
    private String location;



    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tajhizat> Tajhizats;

    @Column(columnDefinition="smallint")
    private Integer laghv;

    @Column(columnDefinition="nvarchar(25)")
    private String khodro;

    @Column(columnDefinition="nvarchar(25)")
    private String ranande;

    @Column(columnDefinition="nvarchar(10)")
    private String ranandeid;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza2;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza3;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza4;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza5;

    @Column(columnDefinition="LONGBLOB")
    private String tasviremza6;

    @Column(columnDefinition="LONGBLOB")
    private String sedaemza;

    @Column(columnDefinition="LONGBLOB")
    private String mdarkhastemza;

    @Column(columnDefinition="LONGBLOB")
    private String poshemza;

    @Column(columnDefinition="LONGBLOB")
    private String hamlonaghlemza;

    @Column(columnDefinition="LONGBLOB")
    private String vherasatemza;

    @Column(columnDefinition="LONGBLOB")
    private String khherasatemza;

    @Column(columnDefinition="LONGBLOB")
    private String tahayeemza;

    @Column(columnDefinition="nvarchar(25)")
    private String saatvorod;

    @Column(columnDefinition="nvarchar(25)")
    private String saatkhoroj;


}
