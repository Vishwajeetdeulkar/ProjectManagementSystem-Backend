package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.Risk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RiskDao extends JpaRepository<Risk,Long> {
}
