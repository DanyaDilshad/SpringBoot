package com.demo.springBoot.repository;

import com.demo.springBoot.entity.DepartmentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentInfo, Integer> {


    //public DepartmentInfo findByDepartmentName(String DepartmentName);
    public DepartmentInfo findByDepartmentNameIgnoreCase(String departmentName);

}
