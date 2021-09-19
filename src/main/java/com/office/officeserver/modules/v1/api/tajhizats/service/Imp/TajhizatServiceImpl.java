package com.office.officeserver.modules.v1.api.tajhizats.service.Imp;

import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import com.office.officeserver.modules.v1.api.tajhizats.repository.TajhizatRepository;
import com.office.officeserver.modules.v1.api.tajhizats.service.TajhizatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TajhizatServiceImpl implements TajhizatService {

    @Autowired
    private TajhizatRepository tajhizatRepository;


    public List<Tajhizat> getList() {
        List<Tajhizat> tajhizats = new ArrayList<>();
        List<Tajhizat> allTajhizat = tajhizatRepository.findAll();
        for (Tajhizat tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Tajhizat>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Tajhizat save(Tajhizat t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
