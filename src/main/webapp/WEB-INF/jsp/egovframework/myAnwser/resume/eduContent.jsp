<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="eduContent">
	<input type="hidden" name="eduStr">
	
	<div class="row">
		<div class="col-12 text-right">
			<a class="delConBtn">x</a>
		</div>
	</div>

	<div class="row mb-1">

		<div class="col-8 px-0">
			<input type="text" class="form-control" placeholder="학교명" readonly="readonly">
			<input type="hidden" class="resumeVal" data-key="schoolCode">
		</div>

		<div class="col-4 pl-1">
			<a class="form-control text-center eduModalBtn">대학검색</a>
		</div>

	</div>

	<div class="row mb-1">
		<div class="col-4 px-0">
			<input type="month" class="form-control resumeVal" data-key="attendDay" placeholder="입학 날짜">
		</div>

		<div class="col-4 pl-1 pr-0">
			<input type="month" class="form-control resumeVal" data-key="graduateDay" placeholder="졸업 날짜">
		</div>

		<div class="col-4 pl-1">
			<select class="form-control resumeVal" data-key="attendType">
				<option value="A">졸업예정</option>
				<option value="B">졸업</option>
				<option value="C">편입</option>
			</select>
		</div>

	</div>

	<div class="row mb-1">
		<div class="col-4 px-0">
			<input type="text" class="form-control resumeVal" data-key="major" placeholder="전공명">
		</div>
		<div class="col-4 pl-1 pr-0">
			<select class="form-control resumeVal" data-key="maxGrade">
				<option>4.5</option>
				<option>4.0</option>
				<option>100</option>
			</select>
		</div>
		<div class="col-4 pl-1">
			<input type="number" class="form-control resumeVal" data-key="grade" placeholder="학점">
		</div>
	</div>

</div>