package com.office.officeserver.modules.v1.api.tajhizats.model;

import com.fasterxml.jackson.annotation.*;
import com.office.officeserver.modules.v1.api.Job.model.Job;
import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tajhizats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Tajhizat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "nvarchar(20)")
    private String name;

    @Column(columnDefinition = "nvarchar(30)")
    private String amvalId;

    @Column(columnDefinition = "nvarchar(30)")
    private String serialId;

    @Column(columnDefinition = "nvarchar(20)")
    private String type;

    @Column(columnDefinition = "nvarchar(20)")
    private String daste;

    @Column(columnDefinition = "LONGBLOB")
    private String image;

    @Transient
    @JsonIgnore
    private MultipartFile file;

//    @JsonIgnore
//    @ManyToMany(fetch = FetchType.LAZY)
//    private List<OfficePlan> OfficePlan;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "office_plan_tajhizat",
            joinColumns = { @JoinColumn(name = "tajhizat_id") },
            inverseJoinColumns = { @JoinColumn(name = "office_plan_id") }
    )
    private Set<OfficePlan> officePlans = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


}
