<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>
<tiles:insertAttribute name="head" />
</head>

<body id="body">

	<!--==========================
    Top Bar
  ============================-->
	<tiles:insertAttribute name="topbar" />

	<!--==========================
    Header
  ============================-->
	<tiles:insertAttribute name="nav" />
	<!-- #header -->

	<tiles:insertAttribute name="content" />
	
	<!--==========================
    Footer
  ============================-->
	<tiles:insertAttribute name="footer" />

	<!-- #footer -->

	<a href="#" class="back-to-top">
		<i class="fa fa-chevron-up"></i>
	</a>

	
	<script src="lib/superfish/hoverIntent.js"></script>
	<script src="lib/superfish/superfish.min.js"></script>
	<script src="lib/sticky/sticky.js"></script>

	<!-- Template Main Javascript File -->
	<script src="js/main.js"></script>

</body>
</html>
