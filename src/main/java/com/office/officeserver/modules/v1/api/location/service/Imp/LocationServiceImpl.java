package com.office.officeserver.modules.v1.api.location.service.Imp;

import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.location.repository.LocationRepository;
import com.office.officeserver.modules.v1.api.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    public List<Location> getList() {
        List<Location> locations = new ArrayList<>();
        List<Location> allLocation = locationRepository.findAll();
        for (Location location : allLocation) {
            locations.add(location);
        }
        return locations;
    }


    public ResponseEntity<Optional<Location>> getLocation(Long id) {
        return new ResponseEntity<>(locationRepository.findById(id), HttpStatus.ACCEPTED);
    }


    public Location save(Location t) {
        return locationRepository.save(t);
    }


    public void delete(Long id) {
        locationRepository.deleteById(id);
    }
}
