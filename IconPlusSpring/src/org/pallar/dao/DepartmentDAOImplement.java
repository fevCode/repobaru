package org.pallar.dao;


import java.util.List;

import org.pallar.model.Department;


public interface DepartmentDAOImplement {
     int getMaxDeptId();
      Department findDepartment(String deptNo);
      List<Department> listDepartment();
      public void insertDepartment(String deptNo,String deptName, String location);
      public void deleteDepartment(String DEPT_NO);
      void updateDepartment(String DEPT_NO,String DEPT_NAME, String LOCATION);
}
 