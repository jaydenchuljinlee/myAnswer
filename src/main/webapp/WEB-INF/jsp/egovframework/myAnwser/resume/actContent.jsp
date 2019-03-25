<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="actContent">
	<input type="hidden" name="actStr">
	
	<div class="row">
		<div class="col-12 text-right">
			<a class="delConBtn">x</a>
		</div>
	</div>

	<div class="row">
		<div class="col-12">
			
			<div class="row mb-1">
				<div class="col-4 px-0">
					<select class="form-control resumeVal" data-key="activityType">
						<option value="4y">활동 구분</option>
						<option value="3y">대학교(3년)</option>
						<option value="2y">대학교(2년)</option>
						<option value="h">고졸</option>
						<option value="n">기타</option>
					</select>
				</div>	
				<div class="col-4 pl-1 pr-0">
					<input type="month" class="form-control resumeVal" data-key="startDay" placeholder="시작일 ">
				</div>
				<div class="col-4 pl-1">
					<input type="month" class="form-control resumeVal" data-key="endDay" placeholder="종료일">
				</div>
			</div>

			<div class="row mb-1">
				<div class="col-4 px-0">
					<input type="text" class="form-control resumeVal" data-key="agency" placeholder="기관명">
				</div>
				<div class="col-8 pl-1">
					<input type="text" class="form-control resumeVal" data-key="actName" placeholder="교육명">
				</div>
			</div>
			
		</div>
	</div>

</div>