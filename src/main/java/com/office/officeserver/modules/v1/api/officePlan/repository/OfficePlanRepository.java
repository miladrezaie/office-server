package com.office.officeserver.modules.v1.api.officePlan.repository;

import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficePlanRepository extends JpaRepository<OfficePlan, Long> {
}
