package com.office.officeserver.modules.v1.api.plan.service.Imp;

import com.office.officeserver.modules.v1.api.plan.model.Plan;
import com.office.officeserver.modules.v1.api.plan.repository.PlanRepository;
import com.office.officeserver.modules.v1.api.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository PlanRepository;

    public PlanServiceImpl(PlanRepository PlanRepository) {
        this.PlanRepository = PlanRepository;
    }


    public List<Plan> getList() {
        List<Plan> Plans = new ArrayList<>();
        List<Plan> allPlan = PlanRepository.findAll();
        for (Plan Plan : allPlan) {
            Plans.add(Plan);
        }
        return Plans;
    }


    public ResponseEntity<Optional<Plan>> getPlan(Long id) {
        return new ResponseEntity<>(PlanRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Plan save(Plan t) {
        return PlanRepository.save(t);
    }


    public void delete(Long id) {
        PlanRepository.deleteById(id);
    }
}
