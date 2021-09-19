package com.office.officeserver.modules.v1.api.officePlan.service.Imp;

import com.office.officeserver.modules.v1.api.officePlan.model.OfficePlan;
import com.office.officeserver.modules.v1.api.officePlan.repository.OfficePlanRepository;
import com.office.officeserver.modules.v1.api.officePlan.service.OfficePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfficePlanServiceImpl implements OfficePlanService {

    private final OfficePlanRepository officePlanRepository;

    public OfficePlanServiceImpl(OfficePlanRepository officePlanRepository) {
        this.officePlanRepository = officePlanRepository;
    }


    public List<OfficePlan> getList() {
        List<OfficePlan> officePlans = new ArrayList<>();
        List<OfficePlan> allOfficePlan = officePlanRepository.findAll();
        for (OfficePlan officePlan : allOfficePlan) {
            officePlans.add(officePlan);
        }
        return officePlans;
    }


    public ResponseEntity<Optional<OfficePlan>> getOfficePlan(Long id) {
        return new ResponseEntity<>(officePlanRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public OfficePlan save(OfficePlan t) {
        return officePlanRepository.save(t);
    }


    public void delete(Long id) {
        officePlanRepository.deleteById(id);
    }
}
