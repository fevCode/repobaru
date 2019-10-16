<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mahasiswa</title>

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
label {
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
		<form action="mahasiswa" method="GET">
			<fieldset>
				<legend>Insert :</legend>
				<p><i> *Isilah table department dulu (sebap FK ke DEPT_NO)</i></p>
				<label>ID Mahasiswa : <input type="text" name="IDMahasiswa">
				</label> <br /> <label> Nama Mahasiswa : <input type="text"
					name="namaMahasiswa"></label> <br />
					<label>
		DEPT_NO :
		<select name="dept_no" >
		 <c:forEach var="item" items="${tempDeptNO}">
            <option value="${item}">${item}</option>
          </c:forEach>
		</select>
		</label>
				<label> <input type="submit" value="go"></label>
			</fieldset>
		</form>


		<form action="updatemahasiswa" method="GET">
			<fieldset>
				<legend>Update:</legend>
				<label>ID Mahasiswa : <input type="text" name="IDMahasiswa">
				</label> <br /> <label> Nama Mahasiswa :<input type="text"
					name="namaMahasiswa"> <br />
				</label> <label> dept_no : <input type="text" name="dept_no"> <br />

					<!-- <label>IDMahasiswa <input type="text" name="IDMahasiswa"></label>  -->
				</label> <input type="submit" value="go">
			</fieldset>
		</form>

		<form action="deletemahasiswa" method="GET">
			<fieldset>
				<legend>Delete:</legend>
				<label>Delete ID Mahasiswa <input type="text"
					name="IDMahasiswa">

				</label> <input type="submit" value="go">
			</fieldset>

		</form>
		<form action="findmahasiswa" method="GET">
			<fieldset>
       <legend>Find Mahasiswa</legend>
			<label>ID Mahasiswa <input type="text" name="IDMahasiswa">

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
						<h1>Table Mahasiswa</h1>
						<table border="1">
							<tr>
								<th>No.</th>
								<th>IDMahasiswa</th>
								<th>namaMahasiswa</th>
								<th>dept_no</th>

							</tr>
							<c:forEach var="mas" items="${mahasiswas}" varStatus="status">
								<tr>
									<td>${status.index + 1}</td>
									<td><b>${mas.IDMahasiswa}</b></td>
									<td>${mas.namaMahasiswa}</td>
									<td><b><u>${mas.dept_no}</b></u></td>
								</tr>
							</c:forEach>
						</table>
						<br/>
				
						<a href="dosen"><b>&gt;&gt;Pergi ke Dosen</b></a>
						<br>
						<a href="department"><b>&gt;&gt;Pergi ke Department</b></a>
						<br> <br> <br> <br> <b>REST
								(Representational state transfer)</b> <br> <a
								href="getallmahasiswa"><i>&gt;&gt;json representation</i></a>
					</div>

				</div>
			</div>
		</div>
	</div>
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