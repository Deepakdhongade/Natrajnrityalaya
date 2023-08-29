package com.natrajnrityalaya.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.natrajnrityalaya.model.Admission;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission,String>{

}
