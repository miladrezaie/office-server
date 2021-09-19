package com.office.officeserver.modules.v1.api.role.service.Imp;

import com.office.officeserver.modules.v1.api.role.model.Role;
import com.office.officeserver.modules.v1.api.role.repository.RoleRepository;
import com.office.officeserver.modules.v1.api.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public List<Role> getList() {
        List<Role> roles = new ArrayList<>();
        List<Role> allRole = roleRepository.findAll();
        for (Role role : allRole) {
            roles.add(role);
        }
        return roles;
    }


    public ResponseEntity<Optional<Role>> getRole(Long id) {
        return new ResponseEntity<>(roleRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Role save(Role t) {
        return roleRepository.save(t);
    }


    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}
