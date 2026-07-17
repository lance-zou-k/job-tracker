//CRUD -> Create, Read, Update, Delete
//API — Application Programming Interface. It's the set of rules/doors
// a server exposes that let other programs (your frontend, Postman, another service) interact with it.
//Endpoint — one specific door on that API.
package com.lance.jobtracker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(Application application){
        return applicationRepository.save(application);
    }

    public Application readApplication(Long id){
        return applicationRepository.findById(id).orElse(null);
    }

    public Application updateApplication(Long id, Application updatedApplication) {
        updatedApplication.setId(id);
        return applicationRepository.save(updatedApplication);
    }

    public void deleteApplication(Long id){
        applicationRepository.deleteById(id);
    }

    //get all for dashboard & table to show every application.
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }
}
