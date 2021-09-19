package com.office.officeserver.modules.v1.api.plan.repository;

import com.office.officeserver.modules.v1.api.plan.model.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
