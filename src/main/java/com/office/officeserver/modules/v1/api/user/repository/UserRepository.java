package com.office.officeserver.modules.v1.api.user.repository;

import com.office.officeserver.modules.v1.api.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String personal_id);

    Boolean existsByUsername(String personal_id);

    Boolean existsByEmail(String email);

}
