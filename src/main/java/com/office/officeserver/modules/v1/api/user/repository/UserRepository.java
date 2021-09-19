package com.office.officeserver.modules.v1.api.user.repository;

import com.office.officeserver.modules.v1.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
