package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.FunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FunctionalDao extends JpaRepository<FunctionalRequirement,Long> {
}
