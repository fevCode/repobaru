package org.pallar.dao;


import java.util.List;

import org.pallar.model.Dosen;


public interface DosenDAOImplement {
     int getMaxDeptId();
      Dosen findDosen(String IDDosen);
     List<Dosen> listDosen();
      public void insertDosen(String IDDosen,String namaDosen, String dept_no);
  public void deleteDosen(String IDDosen);
  void updateDosen(String IDDosen,String namaDosen, String dept_no);

}
 