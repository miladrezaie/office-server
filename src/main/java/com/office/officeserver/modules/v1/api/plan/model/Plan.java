package com.office.officeserver.modules.v1.api.plan.model;


import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.enumer.TypePlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@Table(name = "plans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "nvarchar(20)")
    private String nameBarname;

    @Column(columnDefinition = "nvarchar(20)")
    private String tahayekonande;

    @Column(columnDefinition = "nvarchar(50)")
    private String tarikh;

    @Column(columnDefinition = "nvarchar(50)")
    private String tarikhsodur;

    @Column(columnDefinition = "nvarchar(50)")
    private String saat;

    @Enumerated(EnumType.STRING)
    private TypePlan type;

    @Column(columnDefinition = "nvarchar(50)")
    private String day;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
