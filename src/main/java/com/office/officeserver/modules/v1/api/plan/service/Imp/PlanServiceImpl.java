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

    @Autowired
    private PlanRepository tajhizatRepository;


    public List<Plan> getList() {
        List<Plan> tajhizats = new ArrayList<>();
        List<Plan> allTajhizat = tajhizatRepository.findAll();
        for (Plan tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Plan>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Plan save(Plan t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
