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

    @Autowired
    private RoleRepository tajhizatRepository;


    public List<Role> getList() {
        List<Role> tajhizats = new ArrayList<>();
        List<Role> allTajhizat = tajhizatRepository.findAll();
        for (Role tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Role>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Role save(Role t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
