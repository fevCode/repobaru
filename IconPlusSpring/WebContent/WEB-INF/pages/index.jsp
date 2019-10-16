<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department List</title>
<script type="text/javascript"
	src="js/jspdf.min.js"></script>
<style type="text/css">
.container {
   position: relative;
  width: 50%;
  float: left;
  height: 100%;
  z-index: 1010101010;

} 
.form {
	position: relative;
  width: 50%;
  float: left;
  height: 100%;
  z-index: 1010101010
}
label{
font-weight: bold;
}
.btn{
color:white;
font-weight:bold;
background-color: red;
}
</style>

</head>
<body>


	<div class="form">
		<form action="department" method="GET">
			<fieldset>
				<legend>Insert:</legend>
				<label> DEPT_NO<input type="text" name="DEPT_NO">
				</label> <br /> <label> DEPT_NAME<input type="text"
					name="DEPT_NAME"> <br />
				</label> <label> LOCATION<input type="text" name="LOCATION">
					<br />
				</label> <input type="submit" value="go">
			</fieldset>
		</form>


		<form action="updatedepartment" method="GET">
			<fieldset>
				<legend>Update:</legend>
				<label> DEPT_NO<input type="text" name="DEPT_NO">
				</label> <br /> <label> DEPT_NAME :<input type="text"
					name="DEPT_NAME"> <br />
				</label> <label> LOCATION<input type="text" name="LOCATION">
					<br />
				</label> <input type="submit" value="go">
			</fieldset>
		</form>

		<form action="deletedepartment" method="GET">
			<fieldset>
				<legend>Delete:</legend>
				<label>Delete DEPT_NO <input type="text" name="DEPT_NO">

				</label> <input type="submit" value="go">
			</fieldset>

		</form>
		<form action="finddepartment" method="GET">
			<fieldset>
       <legend>Find Dept</legend>
			<label>DEPT_NO<input type="text" name="DEPT_NO">

			</label> <input type="submit" value="go">
</fieldset>
		</form>
		<img alt="relasi" src="pic/relasi.png">
	</div>


	<fieldset>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div id="content">
				<div align="center">
						<button class="btn" id="export">Export PDF</button>
					</div>
					<div align="center">
						<h2>Table Department</h2>
						<table border="1">
							<tr>
								<th>No</th>
								<th>Dept No</th>
								<th>Dept Name</th>
								<th>Location</th>
							</tr>
							<c:forEach var="dept" items="${departments}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td><b>${dept.deptNo}</b></td>
									<td>${dept.deptName}</td>
									<td>${dept.location}</td>
								</tr>
							</c:forEach>
						</table>
						
						<br/>
						<a href="mahasiswa"><b>&gt;&gt;Pergi ke Mahasiswa</b></a>
						<br>
						<a href="dosen"><b>&gt;&gt;Pergi ke Dosen</b></a>
					</div>
					<br>
					 <b>      REST (Representational state transfer)</b>
						<br>
						<a href="getalldepartment"><i>&gt;&gt;json representation</i></a>
				</div>
			</div>
		</div>
	</div>
	
	<br/>
						
					
						
	</fieldset>


</body>

<script>
	document.getElementById('export').addEventListener('click', exportPDF);

	var specialElementHandlers = {
		// element with id of "bypass" - jQuery style selector
		'.no-export' : function(element, renderer) {
			// true = "handled elsewhere, bypass text extraction"
			return true;
		}
	};

	function exportPDF() {

		var doc = new jsPDF('p', 'pt', 'a4');
		//A4 - 595x842 pts
		//https://www.gnu.org/software/gv/manual/html_node/Paper-Keywords-and-paper-size-in-points.html

		//Html source 
		var source = document.getElementById('content').innerHTML;

		var margins = {
			top : 10,
			bottom : 10,
			left : 10,
			width : 595
		};

		doc.fromHTML(source, // HTML string or DOM elem ref.
		margins.left, margins.top, {
			'width' : margins.width,
			'elementHandlers' : specialElementHandlers
		},

		function(dispose) {
			// dispose: object with X, Y of the last line add to the PDF 
			//          this allow the insertion of new lines after html
			doc.save('Test.pdf');
		}, margins);
	}
</script>
</html>