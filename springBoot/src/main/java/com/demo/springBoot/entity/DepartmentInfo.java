package com.demo.springBoot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int DepartmentId;

    @NotBlank(message = "Please add Department Name!")
    @Length(max = 10, min = 3, message = "Please enter valid Department Name")
    private String departmentName;
    private String DepartmentManager;
    private String DepartmentCode;
    @PositiveOrZero(message = "Enter a valid Department Count")
    private int DepartmentCount;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        departmentName = DepartmentName;
    }

    public String getDepartmentManager() {
        return DepartmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        DepartmentManager = departmentManager;
    }

//    @Override
//    public String toString() {
//        return "DepartmentInfo{" +
//                "DepartmentId=" + DepartmentId +
//                ", DepartmentName='" + departmentName + '\'' +
//                ", DepartmentManager='" + DepartmentManager + '\'' +
//                ", DepartmentCode='" + DepartmentCode + '\'' +
//                ", DepartmentCount=" + DepartmentCount +
//                '}';
//    }
//
//    public int getDepartmentId() {
//        return DepartmentId;
//    }
//
//    public void setDepartmentId(int departmentId) {
//        DepartmentId = departmentId;
//    }
//
//    public String getDepartmentCode() {
//        return DepartmentCode;
//    }
//
//    public void setDepartmentCode(String departmentCode) {
//        DepartmentCode = departmentCode;
//    }
//
//    public int getDepartmentCount() {
//        return DepartmentCount;
//    }
//
//    public void setDepartmentCount(int departmentCount) {
//        DepartmentCount = departmentCount;
//    }

}
