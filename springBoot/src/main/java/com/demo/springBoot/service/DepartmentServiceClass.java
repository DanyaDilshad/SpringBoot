package com.demo.springBoot.service;

import com.demo.springBoot.entity.DepartmentInfo;
import com.demo.springBoot.error.DepartmentNotFoundException;
import com.demo.springBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceClass implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentInfo saveDepartment(DepartmentInfo department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<DepartmentInfo> fetchDepartmentList() {
          return departmentRepository.findAll();
    }

    @Override
    public DepartmentInfo fetchDepartmentById(int DepartmentId) throws DepartmentNotFoundException {
        Optional <DepartmentInfo> department= departmentRepository.findById(DepartmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        else {
            return department.get();
        }

    }

    @Override
    public void deleteDepartmentById(int departmentId) throws DepartmentNotFoundException {
        Optional <DepartmentInfo> department= departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        else {
            departmentRepository.deleteById(departmentId);
        }
    }

    @Override
    public DepartmentInfo updateDepartment(int departmentId, DepartmentInfo department) {
        DepartmentInfo dept = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())){
            dept.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())){
            dept.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentManager()) && !"".equalsIgnoreCase(department.getDepartmentManager())){
            dept.setDepartmentManager(department.getDepartmentManager());
        }
        if(!"".equalsIgnoreCase(department.getDepartmentCode())){
            dept.setDepartmentCount(department.getDepartmentCount());
        }

        return departmentRepository.save(dept);

    }

    @Override
    public DepartmentInfo fetchDepartmentByName(String DepartmentName) throws DepartmentNotFoundException {
        Optional <DepartmentInfo> department = Optional.ofNullable(departmentRepository.findByDepartmentNameIgnoreCase(DepartmentName));
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Found");
        }
        else {
            return department.get();
        }
    }

}
