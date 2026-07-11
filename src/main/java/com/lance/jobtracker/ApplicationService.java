//CRUD -> Create, Read, Update, Delete
//API — Application Programming Interface. It's the set of rules/doors
// a server exposes that let other programs (your frontend, Postman, another service) interact with it.
//Endpoint — one specific door on that API.
package com.lance.jobtracker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ApplicationService {
    private Map<Long, Application> applications = new HashMap<>();
    private Long nextId = 1L;

    public Application createApplication(Application application){
        application.setId(nextId);
        applications.put(nextId, application);
        nextId++;
        return application;
    }
    public Application readApplication(Long id){
        return applications.get(id);
    }

    public Application updateApplication(Long id, Application updatedApplication) {
        updatedApplication.setId(id);
        applications.put(id, updatedApplication);
        return updatedApplication;
    }

    public void deleteApplication(Long id){
        applications.remove(id);
    }

    //get all for dashboard & table to show every application.
    public List<Application> getAllApplications() {
        return new ArrayList<>(applications.values());
    }
}
