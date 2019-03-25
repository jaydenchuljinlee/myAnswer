<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="form-group">
	<span style="float: right;">
		<a class="closeBtn p-2" >x</a>
	</span>
	<label>
		Q<c:out value="${param.qNo }" />.
	</label>
	<input class="form-control" placeholder="질문" name="quest">
	<label class="mt-2">
		A<c:out value="${param.qNo }" />.
	</label>
	<textarea class="form-control" placeholder="답변" name="answer"></textarea>
</div>