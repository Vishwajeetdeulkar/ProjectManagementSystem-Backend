package com.iiitb.projectmanagementsystembackend.data.repository;

import com.iiitb.projectmanagementsystembackend.data.model.EffortTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EffortDao extends JpaRepository<EffortTable,Long> {
}
