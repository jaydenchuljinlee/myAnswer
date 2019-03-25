<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-12">
	<hr>
</div>

<c:forEach items="${schoolList }" var="schoolList">

	<div class="col-12 mt-1" data-school-code="<c:out value="${schoolList.schoolCode }" />">
		<h6>
			<c:out value="${schoolList.schoolName }" />
		</h6>
	</div>

</c:forEach>