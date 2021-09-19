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

    @Autowired
    private OfficePlanRepository tajhizatRepository;


    public List<OfficePlan> getList() {
        List<OfficePlan> tajhizats = new ArrayList<>();
        List<OfficePlan> allTajhizat = tajhizatRepository.findAll();
        for (OfficePlan tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<OfficePlan>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public OfficePlan save(OfficePlan t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
