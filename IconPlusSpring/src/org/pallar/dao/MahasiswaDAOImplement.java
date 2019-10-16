package org.pallar.dao;


import java.util.List;

import org.pallar.model.Mahasiswa;
public interface MahasiswaDAOImplement {
     int getMaxDeptId();
      Mahasiswa findMahasiswa(String IDMahasiswa);
     List<Mahasiswa> listMahasiswa();
      public void insertMahasiswa(String IDMahasiswa,String namaMahasiswa, String dept_no);
      public void deleteMahasiswa(String IDMahasiswa);
      void updateMahasiswa(String IDMahasiswa,String namaMahasiswa, String dept_no);
}
 