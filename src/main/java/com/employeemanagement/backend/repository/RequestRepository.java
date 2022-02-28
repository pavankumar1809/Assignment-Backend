package com.employeemanagement.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeemanagement.backend.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

}
