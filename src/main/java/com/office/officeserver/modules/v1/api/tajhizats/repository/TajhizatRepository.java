package com.office.officeserver.modules.v1.api.tajhizats.repository;

import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TajhizatRepository extends JpaRepository<Tajhizat, Long> {
}
