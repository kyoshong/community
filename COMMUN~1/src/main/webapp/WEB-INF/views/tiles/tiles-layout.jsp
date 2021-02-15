<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/vendors/iconfonts/mdi/css/materialdesignicons.css">
<!-- endinject -->
<!-- vendor css for this page -->
<!-- End vendor css for this page -->
<!-- inject:css -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/css/shared/style.css">
<!-- endinject -->
<!-- Layout style -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/assets/css/demo_1/style.css">
<!-- Layout style -->
<link rel="shortcut icon" type="text/css"
	href="${pageContext.request.contextPath}/resources/asssets/images/favicon.ico" />
</head>

<body>
	<div class='wrap'>
		<tiles:insertAttribute name="header" />
		<div class='content'>
			<div class="page-body">
				<tiles:insertAttribute name="left" />
					<div class="page-content-wrapper">
						<div class="page-content-wrapper-inner">
							<div class="content-viewport">
								<tiles:insertAttribute name="body" />
							
						</div>
					</div>
				</div>
			</div>
		</div>
		<tiles:insertAttribute name="foot" />
	</div>
</body>
<!-- plugins:js -->
<script src="<c:url value="/resources/assets/vendors/js/core.js" />"></script>
<!-- endinject -->
<!-- Vendor Js For This Page Ends-->
<script src="<c:url value="/resources/assets/vendors/apexcharts/apexcharts.min.js"/>"></script>
<script src="<c:url value="/resources/assets/vendors/chartjs/Chart.min.js" />"></script>
<script src="<c:url value="/resources/assets/js/charts/chartjs.addon.js" />"></script>
<!-- Vendor Js For This Page Ends-->
<!-- build:js -->
<script src="<c:url value="/resources/assets/js/template.js"/>"></script>
<script src="<c:url value="/resources/assets/js/dashboard.js"/>"></script>

</html>