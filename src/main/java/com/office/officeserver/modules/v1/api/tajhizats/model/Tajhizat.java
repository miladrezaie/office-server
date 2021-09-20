package com.office.officeserver.modules.v1.api.tajhizats.model;

import com.fasterxml.jackson.annotation.*;
import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tajhizats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Tajhizat {

    //    private static final long serialVersionUID = 1L;
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

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    private List<OfficePlan> OfficePlan;


//    @ManyToOne
//    @JoinColumn(name="location_id", nullable=false)
//    @Nullable
//    private Location location;

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "location_id", nullable = false)
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    private Location location;

    @ManyToOne
    @JoinColumn(name = "location_id")
//    @JsonManagedReference
    private Location location;


}
