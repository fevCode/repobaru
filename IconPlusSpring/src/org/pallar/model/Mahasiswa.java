package org.pallar.model;
 
public class Mahasiswa {
 
   
    private String IDMahasiswa;
    private String namaMahasiswa;
    private String dept_no;
 
    public Mahasiswa() {
 
    }
 
    public Mahasiswa(String deptIDMahasiswa, String namaMahasiswa,
            String dept_no) {
        this.IDMahasiswa = deptIDMahasiswa;
		this.namaMahasiswa = namaMahasiswa;
        this.dept_no = dept_no;
       
    }

	public String getIDMahasiswa() {
		return IDMahasiswa;
	}

	public void setIDMahasiswa(String iDMahasiswa) {
		IDMahasiswa = iDMahasiswa;
	}

	public String getNamaMahasiswa() {
		return namaMahasiswa;
	}

	public void setNamaMahasiswa(String namaMahasiswa) {
		this.namaMahasiswa = namaMahasiswa;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}


 
   
}