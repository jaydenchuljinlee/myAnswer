<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="col-lg-9">

	<div class="container">
		<div class="row my-3">
			<tiles:insertAttribute name="left" />

			<div class="col-lg-9">
				<tiles:insertAttribute name="content" />
			</div>
		</div>
	</div>
	<!-- JavaScript Libraries -->
</div>
