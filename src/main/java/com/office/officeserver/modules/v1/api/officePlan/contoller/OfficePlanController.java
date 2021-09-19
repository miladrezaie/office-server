package com.office.officeserver.modules.v1.api.officePlan.contoller;

import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import com.office.officeserver.modules.v1.api.officePlan.service.Imp.OfficePlanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class OfficePlanController {

    @Autowired
    OfficePlanServiceImpl officePlanService;



    @GetMapping("/officePlans")
    public List<OfficePlan> getAll() {
        return officePlanService.getList();
    }


    @PostMapping("/officePlans")
    public OfficePlan saveOfficePlan(@RequestBody OfficePlan officePlan) {
        return officePlanService.save(officePlan);
    }


    @GetMapping("/officePlans/{id}")
    public ResponseEntity<Optional<OfficePlan>> getOfficePlan(@PathVariable Long id) {
        return officePlanService.getOfficePlan(id);
    }


    @DeleteMapping("/officePlans/{id}")
    public void deleteOfficePlan(@PathVariable Long id) {
        officePlanService.delete(id);

    }
}
