package com.example.company_structure.model.dto;

public class EmployeeResponse {
    private Long id;
    private String name;
    private double finalSalary;
    private String level;
    private Long departmentId;

    // Constructor
    public EmployeeResponse(Long id, String name, double finalSalary, String level, Long departmentId) {
        this.id = id;
        this.name = name;
        this.finalSalary = finalSalary;
        this.level = level;
        this.departmentId = departmentId;
    }

    // Getters and setters

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
    public String  getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getFinalSalary(){
        return finalSalary;
    }
    public void setId(double finalSalary){
        this.finalSalary=finalSalary;
    }
    public String getLevel(){
        return level;
    }
    public void setLevel(String level){
        this.level=level;
    }
    public Long getdepartmentId(){
        return departmentId;
    }
    public void setdepartmentId(Long departmentId){
        this.departmentId=departmentId;
    }
}
