package com.office.officeserver.modules.v1.api.user.service.Imp;

import com.office.officeserver.modules.v1.api.user.model.User;
import com.office.officeserver.modules.v1.api.user.repository.UserRepository;
import com.office.officeserver.modules.v1.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository tajhizatRepository;


    public List<User> getList() {
        List<User> tajhizats = new ArrayList<>();
        List<User> allTajhizat = tajhizatRepository.findAll();
        for (User tajhizat : allTajhizat) {
            tajhizats.add(tajhizat);
        }
        return tajhizats;
    }


    public ResponseEntity<Optional<User>> getTajhizat(Long id) {
        return new ResponseEntity<>(tajhizatRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public User save(User t) {
        return tajhizatRepository.save(t);
    }


    public void delete(Long id) {
        tajhizatRepository.deleteById(id);
    }
}
