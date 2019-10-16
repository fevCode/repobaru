<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dosen List</title>
<script type="text/javascript" src="js/jspdf.min.js"></script>
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

label {
	font-weight: bold;
}

.btn {
	color: white;
	font-weight: bold;
	background-color: red;
}
</style>
</head>
<body>
	<div class="form">
		<form action="dosen" method="GET">
			<fieldset>
				<legend>Insert:</legend>
				<p>
					<i> *Isilah table department dulu (sebap FK ke DEPT_NO)</i>
				</p>

				<label>ID Dosen : <input type="text" name="IDDosen">
				</label> <br /> <label> Nama Dosen :<input type="text"
					name="namaDosen"> <br />
				</label>
				<!-- <label> dept_no<input type="text" name="dept_no"> <br /> -->
				<%-- <select items="${dept_nos}" > </select> --%>
				<label> DEPT_NO : <select name="dept_no">
						<c:forEach var="item" items="${tempDeptNO}">
							<option value="${item}">${item}</option>
						</c:forEach>
				</select>
				</label>
				<!-- <label>IDDosen <input type="text" name="IDDosen"></label>  -->
				</label> <input type="submit" value="go">
			</fieldset>
		</form>


		<form action="updatedosen" method="GET">
			<fieldset>
				<legend>Update:</legend>
				<label>ID Dosen : <input type="text" name="IDDosen">
				</label> <br /> <label> Nama Dosen : <input type="text"
					name="namaDosen"> <br />
				</label> <label> dept_no<input type="text" name="dept_no"> <br />

					<!-- <label>IDDosen <input type="text" name="IDDosen"></label>  -->
				</label> <input type="submit" value="go">
			</fieldset>
		</form>

		<form action="deletedosen" method="GET">
			<fieldset>
				<legend>Delete:</legend>
				<label>Delete IDDosen : <input type="text" name="IDDosen">

				</label> <input type="submit" value="go">
			</fieldset>

		</form>
		<form action="finddosen" method="GET">
			<fieldset>
				<legend>Find Dosen:</legend>
				<label>ID Dosen <input type="text" name="IDDosen">

				</label> <input type="submit" value="go">
			</fieldset>
		</form>
		<img alt="relasi" src="pic/relasi.png" align="left">
	</div>

	<div class="container">
		<fieldset>
			<div class="row">
				<div class="col-xs-12">
					<div id="content">
						<div align="center">
							<button class="btn" id="export">Export PDF</button>
						</div>
						<div align="center">
							<h1>Table Data Dosen</h1>
							<table border="1">
								<tr>
									<th>No.</th>
									<th>IDDosen</th>
									<th>namaDosen</th>
									<th>dept_no</th>

								</tr>
								<c:forEach var="dos" items="${dosens}" varStatus="status">
									<tr>
										<td>${status.index + 1}</td>
										<td><b>${dos.IDDosen}</b></td>
										<td>${dos.namaDosen}</td>
										<td><b><u>${dos.dept_no}</u></b></td>
									</tr>
								</c:forEach>
							</table>
							<br />
							
						</div>

					</div>
				</div>
			</div>
		</fieldset>
	</div>
 <br /> <a href="mahasiswa"><b>&gt;&gt;Pergi ke
									Mahasiswa</b></a> <br> <a href="department"><b>&gt;&gt;Pergi
									ke Department</b></a> <br> <br> <br> <br> <b>REST
								(Representational state transfer)</b> <br> <a
								href="getalldosen"><i>&gt;&gt;json representation</i></a>

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