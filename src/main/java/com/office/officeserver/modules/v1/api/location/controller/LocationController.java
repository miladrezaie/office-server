package com.office.officeserver.modules.v1.api.location.controller;

import com.office.officeserver.modules.v1.api.location.model.Location;
import com.office.officeserver.modules.v1.api.location.response.ResponseHandler;
import com.office.officeserver.modules.v1.api.location.service.Imp.LocationServiceImpl;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Object> getAll() {
        try {
            List<Location> result = locationService.getList();
            if (result.isEmpty()) {
                return ResponseHandler.generateResponse("Successfully Empty Location", HttpStatus.OK, result);
            }
            return ResponseHandler.generateResponse("Successfully All Location!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @PostMapping("/locations")
    public ResponseEntity<Object> saveLocation(@RequestBody Location location) {
        try {
            Location result = locationService.save(location);
            return ResponseHandler.generateResponse("Successfully Created!", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @GetMapping("/locations/{id}")
    public ResponseEntity<Object> getLocation(@PathVariable Long id) {
        try {
            Optional<Location> result = locationService.getLocation(id);
            return ResponseHandler.generateResponse("Successfully Is Ok Return Data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }


    @DeleteMapping("/locations/{id}")
    public ResponseEntity<Object> deleteLocation(@PathVariable Long id) {
        try {
            String result = locationService.delete(id);
            if (result == null) {
                return ResponseHandler.generateResponse("Successfully Not Content!", HttpStatus.NO_CONTENT, null);
            }
            return ResponseHandler.generateResponse("Successfully Deleted item!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }
}
