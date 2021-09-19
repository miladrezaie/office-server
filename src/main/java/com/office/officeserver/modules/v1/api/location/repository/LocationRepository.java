package com.office.officeserver.modules.v1.api.location.repository;

import com.office.officeserver.modules.v1.api.location.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
