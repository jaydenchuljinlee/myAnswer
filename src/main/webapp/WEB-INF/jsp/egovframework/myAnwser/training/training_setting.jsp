<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-9">
	<div class="row resume mt-4">
		<div class="tit">
			<div class="form-inline row">
				<span>관심분야 :</span>
				<select class="form-control" style="margin: 10px">
					<option value="">IT/웹/통신</option>
				</select>
				<select class="form-control">
					<option value="">2차 산업군</option>
				</select>
			</div>

			<div class="form-inline row">
				<span>관심기업 :</span>
				<input class="form-control" placeholder="기업명으로 검색(최대 5개 입력 가능) " style="width: 70%" />
				<button class="form-control " style="height: 38px;">
					<i class='fa fa-search pull-right'></i>
				</button>
				<button class="searchBar form-control ">추가</button>
			</div>
			<div id="search-content" class="form-inline row">
				<!-- 검색한 내용이 들어감 -->
			</div>

			<div class="row" style="margin-top: 30px">
				<span>모드 상세 설정</span>
			</div>
			<div class="form-inline row">
				<div style="text-align: center; background: #fff; border: 2px solid #1b43da; padding: 10px; width: 17%">
					<span>지정 질문 모드</span>
				</div>
				<div style="text-align: center; width: 13%; margin: 20px">
					<span>출제 질문 수 :</span>
				</div>
				<div style="text-align: center; width: 15%;">
					<input class="form-control" type="text" placeholder="숫자입력" style="width: 75%">
					개
				</div>
				<div style="text-align: center; width: 7%; margin: 10px">
					<label>
						<input class="checkbox" type="checkbox">
						<span>랜덤</span>
					</label>
				</div>
				<div style="text-align: center; width: 7%; margin: 10px">
					<label>
						<input class="checkbox" type="checkbox">
						<span>순차</span>
					</label>
				</div>
			</div>
			<div class="form-inline row">
				<div style="text-align: center; background: #fff; border: 2px solid #1b43da; padding: 10px; width: 17%">
					<span>실전 모드</span>
				</div>
				<div style="text-align: center; width: 13%; margin: 20px">
					<span>답변 시간:</span>
				</div>
				<div style="text-align: center; width: 15%;">
					<input class="form-control" type="text" placeholder="숫자입력" style="width: 75%">
					분
				</div>
			</div>


			<div class="row" style="margin-top: 30px">
				<span>면접관 설정</span>
			</div>
			<div class="form-inline row">
				<div class="gender-control"
					style="text-align: center; background: #1b43da; border: 2px solid #1b43da; padding: 10px; width: 17%; color: #fff; margin: 10px">
					<span>남</span>
				</div>
				<div class="gender-control"
					style="text-align: center; background: #fff; border: 2px solid #1b43da; padding: 10px; width: 17%; color: #000000; margin: 10px">
					<span>여</span>
				</div>
			</div>
		</div>
	</div>
</div>