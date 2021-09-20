package com.office.officeserver.modules.v1.api.tajhizats.service.Imp;

import com.office.officeserver.modules.v1.api.location.service.Imp.LocationServiceImpl;
import com.office.officeserver.modules.v1.api.tajhizats.model.Tajhizat;
import com.office.officeserver.modules.v1.api.tajhizats.repository.TajhizatRepository;
import com.office.officeserver.modules.v1.api.tajhizats.service.TajhizatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class TajhizatServiceImpl implements TajhizatService {

    @Autowired
    private TajhizatRepository tajhizatRepository;
    @Autowired
    private LocationServiceImpl locationService;


    public List<Tajhizat> getList() {
        List<Tajhizat> tajhizats = new ArrayList<>();
        List<Tajhizat> allTajhizat = tajhizatRepository.findAll();
        for (Tajhizat tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<Tajhizat>> getTajhizat(Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tajhizatRepository.findById(id));
    }


    public Tajhizat save(Tajhizat t, MultipartFile file) {
        System.out.println("is ok...............fu......");
        System.out.println(file.getOriginalFilename());

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
//                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
                System.out.println("not a valid file");
            }
            t.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException ex) {
//            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
            System.out.println("errrrrorr");
        }

        return tajhizatRepository.save(t);
    }

    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
