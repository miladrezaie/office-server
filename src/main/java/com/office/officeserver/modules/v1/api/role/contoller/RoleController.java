package com.office.officeserver.modules.v1.api.role.contoller;

import com.office.officeserver.modules.v1.api.role.model.Role;
import com.office.officeserver.modules.v1.api.role.service.Imp.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class RoleController {

    private final RoleServiceImpl roleService;

    public RoleController(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/roles")
    public List<Role> getAll() {
        return roleService.getList();
    }


    @PostMapping("/roles")
    public Role saveRole(@RequestBody Role role) {
        return roleService.save(role);
    }


    @GetMapping("/roles/{id}")
    public ResponseEntity<Optional<Role>> getRole(@PathVariable Long id) {
        return roleService.getRole(id);
    }


    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.delete(id);

    }
}
