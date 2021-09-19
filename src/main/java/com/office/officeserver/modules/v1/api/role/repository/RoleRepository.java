package com.office.officeserver.modules.v1.api.role.repository;

import com.office.officeserver.modules.v1.api.role.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
