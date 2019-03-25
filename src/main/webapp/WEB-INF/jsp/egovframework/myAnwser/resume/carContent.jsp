<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="carContent">
	<input type="hidden" name="carStr">
	
	<div class="row">
		<div class="col-12 text-right">
			<a class="delConBtn">x</a>
		</div>
	</div>

	<div class="row mb-1">
		
		<div class="col-6 px-0">
			<input type="text" class="form-control resumeVal" data-key="company" placeholder="회사명">
		</div>
		<div class="col-3 pl-1 pr-0">
			<input type="month" class="form-control resumeVal" data-key="joinDay" placeholder="입사 날짜">
		</div>
		<div class="col-3 pl-1">
			<input type="month" class="form-control resumeVal" data-key="leaveDay" placeholder="퇴사 날짜">
		</div>
	
	</div>

	<div class="row mb-1">
	
		<div class="col-3 px-0">
			<input type="text" class="form-control resumeVal" data-key="department" placeholder="부서명">
		</div>
		<div class="col-3 pl-1 pr-0">
		<input type="text" class="form-control resumeVal" data-key="position" placeholder="직책">
		</div>
		<div class="col-3 pl-1 pr-0">
		<input type="text" class="form-control resumeVal" data-key="duty" placeholder="직무">
		</div>
		<div class="col-3 pl-1">
			<input type="text" class="form-control resumeVal" data-key="salary" placeholder="연봉">
		</div>
	
	</div>

</div>