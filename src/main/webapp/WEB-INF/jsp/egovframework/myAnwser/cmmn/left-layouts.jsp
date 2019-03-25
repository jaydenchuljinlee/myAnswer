<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="container">
	<div class="row my-3">
		<tiles:insertAttribute name="left" />

		<tiles:insertAttribute name="content" />
	</div>
</div>