package org.pallar.model;


public class Dosen {
 

    private String IDDosen;

    private String namaDosen;

    private String dept_no;
 
    public Dosen() {
 
    }
 
    public Dosen(String deptIDDosen, String namaDosen,
            String dept_no) {
        this.IDDosen = deptIDDosen;
        this.namaDosen = namaDosen;
        this.dept_no = dept_no;
       
    }

	public String getIDDosen() {
		return IDDosen;
	}

	public void setIDDosen(String iDDosen) {
		IDDosen = iDDosen;
	}

	public String getNamaDosen() {
		return namaDosen;
	}

	public void setNamaDosen(String namaDosen) {
		this.namaDosen = namaDosen;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
 
   
}