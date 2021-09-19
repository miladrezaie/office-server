package com.office.officeserver.modules.v1.api.Job.repository;

import com.office.officeserver.modules.v1.api.Job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
}
