package com.office.officeserver.modules.v1.api.location.contoller;

import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.location.service.Imp.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class LocationController {

    final private LocationServiceImpl locationService;

    public LocationController(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }


    @GetMapping("/locations")
    public List<Location> getAll() {
        return locationService.getList();
    }


    @PostMapping("/locations")
    public Location saveLocation(@RequestBody Location location) {
        return locationService.save(location);
    }


    @GetMapping("/locations/{id}")
    public ResponseEntity<Optional<Location>> getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }


    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.delete(id);

    }
}
