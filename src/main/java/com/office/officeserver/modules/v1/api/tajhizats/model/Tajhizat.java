package com.office.officeserver.modules.v1.api.tajhizats.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tajhizats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tajhizat {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
}
