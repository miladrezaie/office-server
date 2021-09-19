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
    private UserRepository userRepository;


    public List<User> getList() {
        List<User> users = new ArrayList<>();
        List<User> allUser = userRepository.findAll();
        for (User user : allUser) {
            users.add(user);
        }
        return users;
    }


    public ResponseEntity<Optional<User>> getUser(Long id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public User save(User t) {
        return userRepository.save(t);
    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
