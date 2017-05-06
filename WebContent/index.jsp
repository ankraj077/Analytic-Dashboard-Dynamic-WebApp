<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>

<script>
	$(function() {
		$(".datepicker").datepicker();
	});
</script>

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
		<a class="active" href="index.jsp">Total Projects</a> <a
			href="countrydata.jsp">Country</a> <a href="techdata.jsp">Technology</a>
		<a href="monthlychart.jsp">Monthly</a>
	</div>
	<br />
	<center>
		<form action="DashboardData" method="POST">
			<div>
				Start Date : <input class="datepicker" type="text" name="start_date" />
			</div>
			<br />
			<div>
				End Date : <input class="datepicker" type="text" name="end_date" />
			</div>
			<br />
			<div>
				Year : <select name="y">

					<option>All</option>
					<option>2008</option>
					<option>2008</option>
					<option>2009</option>
					<option>2010</option>
					<option>2011</option>
					<option>2012</option>
					<option>2013</option>
					<option>2014</option>
					<option>2015</option>
					<option>2016</option>
					<option>2017</option>
				</select>
			</div>
			<br />

			<div>
				<input type="radio" name="r" value="asc" /> Ascending <input
					type="radio" name="r" value="desc" /> Descending
			</div>
			<br /> <input type="submit" value="Submit" />
		</form>
	</center>
	<br />
	<br />

	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<script type="text/javascript">
		var years = ${years};
		var total = ${total};

		// Create the chart
console.log(years);
		Highcharts
				.chart(
						'container',
						{
							chart : {
								type : 'column'
							},
							title : {
								text : 'Yearly project and total cost. '
							},
							subtitle : {
								text : 'From January, 2008 to March, 2017'
							},
							xAxis : {
								title : {
									text : '<b>Year</b>'

								},
								categories : years,
								type : 'category',

							},
							yAxis : {
								title : {
									text : 'Total projects completed',

								}

							},
							legend : {
								enabled : false
							},
							plotOptions : {
								series : {
									borderWidth : 0,
									dataLabels : {
										enabled : true,
										format : '{point.y}'
									}
								}
							},

							tooltip : {
								headerFormat : '<span style="font-size:11px">{series.name}</span><br>',
								pointFormat : '<span style="color:{point.color}">{point.name}</span>: <b>{point.y}</b> of total<br/>'
							},

							series : [ {
								name : 'Projects',
								colorByPoint : true,
								data : total
							} ]
						});
	</script>
</body>
</html>