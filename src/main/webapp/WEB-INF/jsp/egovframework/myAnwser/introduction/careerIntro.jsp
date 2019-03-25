<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${careerQList }" var="careerQList">
	<div class="form-group">
		<h4 class="text-center mt-5 mb-3" style="font-size: 20px;">
			Q .
			<c:out value="${careerQList.company }" />
			(
			<c:out value="${careerQList.joinDay }" />
			~
			<c:out value="${careerQList.leaveDay }" />
			)
		</h4>
		<input class="qestFrmVal" type="hidden" name="joinDay" value="<c:out value="${careerQList.joinDay }"/>">
		<input class="qestFrmVal" type="hidden" name="leaveDay" value="<c:out value="${careerQList.leaveDay }"/>">
		<textarea class="form-control qestFrmVal" placeholder="답변" name="content" rows="10"><c:out value="${careerQList.content }" /></textarea>
	</div>
</c:forEach>