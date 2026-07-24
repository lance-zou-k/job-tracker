//Handle http requests
package com.lance.jobtracker;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/applications")
    public ResponseEntity<Application> createApplication(@RequestBody Application applications){
        return ResponseEntity.status(201).body(applicationService.createApplication(applications));
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<Application> readApplication(@PathVariable Long id){
        if(applicationService.readApplication(id) == null){
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(applicationService.readApplication(id)); //200
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<Application> updateApplication(@PathVariable Long id, @RequestBody Application applications){
        if(applicationService.readApplication(id) == null){
            return ResponseEntity.notFound().build(); //404
        }
        return ResponseEntity.ok(applicationService.updateApplication(id, applications));
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id){
        if(applicationService.readApplication(id) == null){
            return ResponseEntity.notFound().build(); //404
        }
        applicationService.deleteApplication(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/applications")
    public ResponseEntity<List<Application>> getAllApplications(){
        return ResponseEntity.ok(applicationService.getAllApplications());
    }

    @GetMapping("/test")
    public String testConnection(){
        return "Job Tracker is running";
    }
}


