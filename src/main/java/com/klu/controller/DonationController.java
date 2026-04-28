package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.klu.model.Donation;
import com.klu.repository.DonationRepository;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "*") // ✅ VERY IMPORTANT
public class DonationController {

    @Autowired
    private DonationRepository repo;

    // 🔹 ADD DONATION
    @PostMapping
    public Donation addDonation(@RequestBody Donation donation) {
        return repo.save(donation);
    }

    // 🔹 GET ALL DONATIONS
    @GetMapping
    public List<Donation> getAllDonations() {
        return repo.findAll();
    }

    // 🔹 UPDATE STATUS (ADMIN)
    @PutMapping("/{id}/status")
    public Donation updateStatus(@PathVariable Long id, @RequestParam String status) {
        Donation donation = repo.findById(id).orElseThrow(() -> new RuntimeException("Donation not found"));

        donation.setStatus(status);

        return repo.save(donation);
        
        }
}

