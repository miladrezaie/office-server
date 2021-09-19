package com.office.officeserver.modules.v1.api.plan.contoller;

import com.office.officeserver.modules.v1.api.plan.model.Plan;
import com.office.officeserver.modules.v1.api.plan.service.Imp.PlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class PlanController {

    private final PlanServiceImpl PlanService;

    public PlanController(PlanServiceImpl PlanService) {
        this.PlanService = PlanService;
    }


    @GetMapping("/Plans")
    public List<Plan> getAll() {
        return PlanService.getList();
    }


    @PostMapping("/Plans")
    public Plan savePlan(@RequestBody Plan Plan) {
        return PlanService.save(Plan);
    }


    @GetMapping("/Plans/{id}")
    public ResponseEntity<Optional<Plan>> getPlan(@PathVariable Long id) {
        return PlanService.getPlan(id);
    }


    @DeleteMapping("/Plans/{id}")
    public void deletePlan(@PathVariable Long id) {
        PlanService.delete(id);

    }
}
