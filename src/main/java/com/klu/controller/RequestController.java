package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.klu.model.Request;
import com.klu.repository.RequestRepository;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "*") // VERY IMPORTANT
public class RequestController {

    @Autowired
    private RequestRepository repo;

    // ✅ ADD REQUEST
    @PostMapping
    public Request addRequest(@RequestBody Request req) {
        req.setStatus("Pending"); // default status
        return repo.save(req);
    }

    // ✅ GET ALL REQUESTS
    @GetMapping
    public List<Request> getAllRequests() {
        return repo.findAll();
    }
}