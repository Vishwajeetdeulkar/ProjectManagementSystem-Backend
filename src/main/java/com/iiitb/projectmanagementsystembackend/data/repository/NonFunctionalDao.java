package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.NonFunctionalRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NonFunctionalDao extends JpaRepository<NonFunctionalRequirement,Long> {
}
