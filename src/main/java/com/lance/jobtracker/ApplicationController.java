//Handle http requests
package com.lance.jobtracker;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/applications")
    public Application createApplication(@RequestBody Application applications){
        return applicationService.createApplication(applications);
    }

    @GetMapping("/applications/{id}")
    public Application readApplication(@PathVariable Long id){
        return applicationService.readApplication(id);
    }

    @PutMapping("/applications/{id}")
    public Application updateApplication(@PathVariable Long id, @RequestBody Application applications){
        return applicationService.updateApplication(id, applications);
    }

    @DeleteMapping("/applications/{id}")
    public void deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);
    }

    @GetMapping("/applications")
    public List<Application> getAllApplications(){
        return applicationService.getAllApplications();
    }

    @GetMapping("/test")
    public String testConnection(){
        return "Job Tracker is running";
    }
}


