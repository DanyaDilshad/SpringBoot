package com.demo.springBoot.service;


import com.demo.springBoot.entity.DepartmentInfo;
import com.demo.springBoot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    DepartmentInfo saveDepartment(DepartmentInfo department);

    public List<DepartmentInfo> fetchDepartmentList();

    public DepartmentInfo fetchDepartmentById(int DepartmentId ) throws DepartmentNotFoundException;

    public void deleteDepartmentById(int departmentId) throws DepartmentNotFoundException;

    public DepartmentInfo updateDepartment(int departmentId, DepartmentInfo department);

    public DepartmentInfo fetchDepartmentByName(String DepartmentName) throws DepartmentNotFoundException;

}
