<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${activityQList }" var="activityQList">
	<div class="form-group">
		<h4 class="text-center mt-5 mb-3" style="font-size: 20px;">
			Q .
			<c:out value="${activityQList.actName }" />
			(
			<c:out value="${activityQList.startDay }" />~
			<c:out value="${activityQList.endDay }" />
			)
		</h4>
		<input class="qestFrmVal" type="hidden" name="startDay" value="<c:out value="${activityQList.startDay }"/>">
		<input class="qestFrmVal" type="hidden" name="endDay" value="<c:out value="${activityQList.endDay }"/>">
		<textarea class="form-control qestFrmVal" placeholder="답변" name="content" rows="10"><c:out value="${activityQList.content }" /></textarea>
	</div>
</c:forEach>