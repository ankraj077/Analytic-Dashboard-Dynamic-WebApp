<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<style>
body {
	margin: 0;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}
</style>

</head>
<body>
	<div class="topnav">
		<a class="active" href="index.jsp">Total Projects</a> <a href="countrydata.jsp">Country</a> <a
			href="techdata.jsp">Technology</a> <a href="monthlychart.jsp">Monthly</a>
	</div>
	<br/>
	<center>
	
	<form action="MonthlyData" method="POST">
		<div>
			Month : <select name="m">

				<option>All</option>
				<option>Jan</option>
				<option>Feb</option>
				<option>Mar</option>
				<option>Apr</option>
				<option>May</option>
				<option>Jun</option>
				<option>Jul</option>
				<option>Aug</option>
				<option>Sep</option>
				<option>Oct</option>
				<option>Nov</option>
				<option>Dec</option>
			</select>
		</div>
		<br />

		<div>
			Total project : <input type="radio" name="r" value="asc" /> Ascending
			<input type="radio" name="r" value="desc" /> Descending
		</div>
		<br /> Project Types : Web<input type="checkbox" name="web"
			value="web" checked> Mobile<input type="checkbox" name="mob"
			value="mob" checked> Desktop<input type="checkbox"
			name="desk" value="desk" checked> Other<input type="checkbox"
			name="other" value="other" checked> <br /> 
			<br/>
			<input type="submit" value="Submit" />
	</form>
	</center>
	<br/>
	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<script>
		var web = ${web};
		var mob = ${mob};
		var desk = ${desk};
		var other = ${other};
		var mon = ${mon};

		Highcharts
				.chart(
						'container',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : 'Monthly Projects : 2016'
							},
							subtitle : {
								text : ''
							},
							xAxis : {
								categories : mon,
								crosshair : true
							},
							yAxis : {
								min : 0,
								title : {
									text : 'Number of projects'
								}
							},
							tooltip : {
								headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
								pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
										+ '<td style="padding:0"><b>{point.y} </b></td></tr>',
								footerFormat : '</table>',
								shared : true,
								useHTML : true
							},
							plotOptions : {
								column : {
									pointPadding : 0.2,
									borderWidth : 0
								}
							},
							series : [ {
								name : 'Web Projects',
								data : web

							}, {
								name : 'Mobile Projects',
								data : mob

							}, {
								name : 'Desktop Projects',
								data : desk

							}, {
								name : 'Other',
								data : other

							} ]
						});
	</script>
</body>
</html>