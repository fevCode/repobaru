package org.pallar.controller;

import java.util.List;

import org.pallar.dao.DepartmentDAOImplement;
import org.pallar.dao.DosenDAOImplement;
import org.pallar.dao.LoginDAOImplement;
import org.pallar.dao.MahasiswaDAOImplement;
import org.pallar.model.Department;
import org.pallar.model.Dosen;
import org.pallar.model.Login;
import org.pallar.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class MainController {
	/*
	 * ============================================= create database mydatabase;
	 * use mydatabase; create table DEPARTMENT ( DEPT_ID integer not null,
	 * DEPT_NAME varchar(255) not null, DEPT_NO varchar(20) not null, LOCATION
	 * varchar(255), primary key (DEPT_ID), unique (DEPT_NO) );
	 * 
	 * 
	 * DEPENDENCY : mysql-connector-java-5.1.28-bin.jar
	 * com.springsource.org.aopalliance-1.0.0.jar
	 * 
	 * =====================================
	 */
	@Autowired
	private DepartmentDAOImplement departmentDAO;
	@Autowired
	private DosenDAOImplement dosenDAO;
	@Autowired
	private MahasiswaDAOImplement mahasiswaDAO;
	@Autowired
	private LoginDAOImplement loginDAO;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String indeks(Model model) {
		return "login";
	}

	@RequestMapping(value = { "/log" }, method = RequestMethod.GET)
	public String log(Model model) {

		return "login";

	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String logn(
			Model model,
			@RequestParam(value = "username", defaultValue = "fevly") String username,
			@RequestParam(value = "password", defaultValue = "fevly") String password) {

		List<Login> listLogin = loginDAO.listLogin();
		if (username.trim().equalsIgnoreCase(
				listLogin.get(0).getUsername().trim())
				&& password.trim().equalsIgnoreCase(
						listLogin.get(0).getpassword().trim())) {
			List<Department> list = departmentDAO.listDepartment();
			model.addAttribute("departments", list);
			// System.out.println("benarndak");
			return "index";
		}

		else {
			model.addAttribute("message",
					"Kombinasi username & password salah!");
			return "login";
		}

	}

	// ==============================================================================
	@RequestMapping(value = "/getalldepartment", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody List<Department> getAllDepartment(){
		List<Department> listDept = departmentDAO.listDepartment();
		return listDept;
	}
	
	
	@RequestMapping(value = { "/department" }, method = RequestMethod.GET)
	public String insert(
			Model model,
			@RequestParam(value = "DEPT_NO", defaultValue = "not") String DEPT_NO,
			@RequestParam(value = "DEPT_NAME", defaultValue = "not") String DEPT_NAME,
			@RequestParam(value = "LOCATION", defaultValue = "not") String LOCATION) {

	
		List<Department> listDept = departmentDAO.listDepartment();
	
		model.addAttribute("departments", listDept);
		
		if (!DEPT_NO.equalsIgnoreCase("not")) {
			departmentDAO.insertDepartment(DEPT_NO, DEPT_NAME, LOCATION);
			List<Department> list2 = departmentDAO.listDepartment();
			model.addAttribute("departments", list2);
			return "index";

		}

		else {
			return "index";
		}

	}

	@RequestMapping(value = { "/updatedepartment" }, method = RequestMethod.GET)
	public String updateDepartment(
			Model model,
			@RequestParam(value = "DEPT_NO", defaultValue = "fevly") String DEPT_NO,
			@RequestParam(value = "DEPT_NAME", defaultValue = "fevly") String DEPT_NAME,
			@RequestParam(value = "LOCATION", defaultValue = "fevly") String LOCATION) {

		departmentDAO.updateDepartment(DEPT_NO, DEPT_NAME, LOCATION);
		List<Department> list = departmentDAO.listDepartment();
		model.addAttribute("departments", list);
		System.out.println("coba");
		return "index";
	}

	@RequestMapping(value = { "/deletedepartment" }, method = RequestMethod.GET)
	public String deleteDepartment(
			Model model,
			@RequestParam(value = "DEPT_NO", defaultValue = "fevly") String DEPT_NO) {
		departmentDAO.deleteDepartment(DEPT_NO);
		List<Department> list = departmentDAO.listDepartment();
		model.addAttribute("departments", list);
		System.out.println("coba");
		return "index";
	}

	@RequestMapping(value = { "/finddepartment" }, method = RequestMethod.GET)
	public String findDepartment(
			Model model,
			@RequestParam(value = "DEPT_NO", defaultValue = "fevly") String DEPT_NO) {

		System.out.println("Dapat " + departmentDAO.findDepartment(DEPT_NO));
		List<Department> list = departmentDAO.listDepartment();
		model.addAttribute("departments", list);
		System.out.println("cobaDept");
		return "index";
	}

	// ==============================================================================
	@RequestMapping(value = "/getalldosen", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody List<Dosen> getAllDosen(){
		List<Dosen> listDosen = dosenDAO.listDosen();
		return listDosen;
	}
	
	
	@RequestMapping(value = { "/dosen" }, method = RequestMethod.GET)
	public String insertDosen(
			Model model,
			@RequestParam(value = "IDDosen", defaultValue = "not") String IDDosen,
			@RequestParam(value = "namaDosen", defaultValue = "not") String namaDosen,
			@RequestParam(value = "dept_no", defaultValue = "not") String dept_no) {

		List<Dosen> list = dosenDAO.listDosen();
		List<Department> listDept = departmentDAO.listDepartment();
		String tempDeptNO[] = new String[1000];


		// generasi dropdown DEPT_NO
		for (int i = 0; i < listDept.size(); i++) {
			tempDeptNO[i] = listDept.get(i).getDeptNo();
		}
		model.addAttribute("tempDeptNO", tempDeptNO);
		model.addAttribute("dosens", list);
		
		
		if (!IDDosen.equalsIgnoreCase("not")) {
			dosenDAO.insertDosen(IDDosen, namaDosen, dept_no);
			List<Dosen> list2 = dosenDAO.listDosen();
			model.addAttribute("dosens", list2);
			return "dosen";

		}

		else {
			return "dosen";
		}

	}

	@RequestMapping(value = { "/deletedosen" }, method = RequestMethod.GET)
	public String deleteDosen(
			Model model,
			@RequestParam(value = "IDDosen", defaultValue = "fevly") String IDDosen) {
		dosenDAO.deleteDosen(IDDosen);
		List<Dosen> list = dosenDAO.listDosen();
		model.addAttribute("dosens", list);
		System.out.println("cobaDosen");
		return "dosen";
	}

	@RequestMapping(value = { "/finddosen" }, method = RequestMethod.GET)
	public String findDosen(
			Model model,
			@RequestParam(value = "IDDosen", defaultValue = "fevly") String IDDosen) {

		System.out.println("Dapat " + dosenDAO.findDosen(IDDosen));
		List<Dosen> list = dosenDAO.listDosen();
		model.addAttribute("dosens", list);
		System.out.println("cobaDosen");
		return "dosen";
	}

	@RequestMapping(value = { "/updatedosen" }, method = RequestMethod.GET)
	public String updateDosen(
			Model model,
			@RequestParam(value = "IDDosen", defaultValue = "not") String IDDosen,
			@RequestParam(value = "namaDosen", defaultValue = "not") String namaDosen,
			@RequestParam(value = "dept_no", defaultValue = "not") String dept_no) {

		
		List<Dosen> list = dosenDAO.listDosen();
		List<Department> listDept = departmentDAO.listDepartment();
		String tempDeptNO[] = new String[1000];

		// generasi dropdown DEPT_NO
		for (int i = 0; i < listDept.size(); i++) {
			tempDeptNO[i] = listDept.get(i).getDeptNo();
		}
		model.addAttribute("tempDeptNO", tempDeptNO);
		model.addAttribute("dosens", list);
		

		if (!IDDosen.equalsIgnoreCase("not")) {
			dosenDAO.updateDosen(IDDosen, namaDosen, dept_no);
			List<Dosen> list2 = dosenDAO.listDosen();
			model.addAttribute("dosens", list2);
			return "dosen";

		}

		else {
			return "dosen";
		}
	}

	// ==============================================================================
	@RequestMapping(value = "/getallmahasiswa", method = RequestMethod.GET, produces = "application/json")
	public  @ResponseBody List<Mahasiswa> getAllMahasiswa(){
		List<Mahasiswa> listMahasiswa =mahasiswaDAO.listMahasiswa();
		return listMahasiswa;
	}
	@RequestMapping(value = { "/mahasiswa" }, method = RequestMethod.GET)
	public String insertMahasiswa(
			Model model,
			@RequestParam(value = "IDMahasiswa", defaultValue = "not") String IDMahasiswa,
			@RequestParam(value = "namaMahasiswa", defaultValue = "not") String namaMahasiswa,
			@RequestParam(value = "dept_no", defaultValue = "not") String dept_no) {


		List<Mahasiswa> list = mahasiswaDAO.listMahasiswa();
		List<Department> listDept = departmentDAO.listDepartment();
		String tempDeptNO[] = new String[1000];

		// generasi dropdown DEPT_NO
		for (int i = 0; i < listDept.size(); i++) {
			tempDeptNO[i] = listDept.get(i).getDeptNo();
		}
		model.addAttribute("tempDeptNO", tempDeptNO);
		model.addAttribute("mahasiswas", list);
		
		
		if (!IDMahasiswa.equalsIgnoreCase("not")) {
			mahasiswaDAO.insertMahasiswa(IDMahasiswa, namaMahasiswa, dept_no);
			List<Mahasiswa> list2 = mahasiswaDAO.listMahasiswa();
			model.addAttribute("mahasiswas", list2);
			return "mahasiswa";

		}

		else {
			return "mahasiswa";
		}
	}

	@RequestMapping(value = { "/deletemahasiswa" }, method = RequestMethod.GET)
	public String deleteMahasiswa(
			Model model,
			@RequestParam(value = "IDMahasiswa", defaultValue = "fevly") String IDMahasiswa) {
		mahasiswaDAO.deleteMahasiswa(IDMahasiswa);
		List<Mahasiswa> list = mahasiswaDAO.listMahasiswa();
		model.addAttribute("mahasiswas", list);
		System.out.println("cobaMahasiswa");
		return "mahasiswa";
	}

	@RequestMapping(value = { "/findmahasiswa" }, method = RequestMethod.GET)
	public String findMahasiswa(
			Model model,
			@RequestParam(value = "IDMahasiswa", defaultValue = "fevly") String IDMahasiswa) {

		System.out.println("Dapat " + mahasiswaDAO.findMahasiswa(IDMahasiswa));
		List<Mahasiswa> list = mahasiswaDAO.listMahasiswa();
		model.addAttribute("mahasiswas", list);
		System.out.println("cobaMahasiswa");
		return "mahasiswa";
	}

	@RequestMapping(value = { "/updatemahasiswa" }, method = RequestMethod.GET)
	public String updateMahasiswa(
			Model model,
			@RequestParam(value = "IDMahasiswa", defaultValue = "not") String IDMahasiswa,
			@RequestParam(value = "namaMahasiswa", defaultValue = "not") String namaMahasiswa,
			@RequestParam(value = "dept_no", defaultValue = "not") String dept_no) {

		List<Mahasiswa> list = mahasiswaDAO.listMahasiswa();
		List<Department> listDept = departmentDAO.listDepartment();
		String tempDeptNO[] = new String[1000];

		
		for (int i = 0; i < listDept.size(); i++) {
			tempDeptNO[i] = listDept.get(i).getDeptNo();
		}
		model.addAttribute("tempDeptNO", tempDeptNO);
		model.addAttribute("mahasiswas", list);
		
		
		if (!IDMahasiswa.equalsIgnoreCase("not")) {
			mahasiswaDAO.updateMahasiswa(IDMahasiswa, namaMahasiswa, dept_no);
			List<Mahasiswa> list2 = mahasiswaDAO.listMahasiswa();
			model.addAttribute("mahasiswas", list2);
			return "mahasiswa";

		}

		else {
			return "mahasiswa";
		}
	}

}