package org.pallar.model;
 
public class Department {
 
    
    private String deptNo;
    private String deptName;
    private String location;
 
    public Department() {
 
    }
 
    public Department( String deptNo, String deptName,
            String location) {
      
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }
 
  
    public String getDeptNo() {
        return deptNo;
    }
 
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
 
    public String getDeptName() {
        return deptName;
    }
 
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
 
    public String getLocation() {
        return location;
    }
 
    public void setLocation(String location) {
        this.location = location;
    }
}