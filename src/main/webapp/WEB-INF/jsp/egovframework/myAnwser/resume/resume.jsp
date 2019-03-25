<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-lg-9">
	<form id="resumeFrm" enctype="multipart/form-data">
		<div class="row resume mt-4">
			
			<div class="required">
				<h3 class="my-2">인적사항</h3>
				<div class="card mb-2 card-body">
					<div class="row">
						<div class="col-2 px-0">
							<img class="form-control" id="replaceMe" style="height: 130px; width: 100%" />
							<button class="form-control" id="upload">
								<span>사진추가</span>
							</button>
							<input type="file" name="photo" style="display: none;" onchange="imageURL(this)">
						</div>
						<div class="col-10 pl-2">
							<div class="row mb-1">
								<div class="col-4 pr-0">
									<input type="text" class="form-control resumeVal" name="name" placeholder="이름">
								</div>
								<div class="col-4 pl-1 pr-0">
									<input type="date" class="form-control resumeVal" name="birthday" placeholder="생년월일">
								</div>
								<div class="col-4 pl-1 pr-1">
									<select class="form-control resumeVal" name="gender">
										<option value="m">남자</option>
										<option value="f">여자</option>
									</select>
								</div>
							</div>

							<div class="row mb-1">
								<div class="col-5 pr-0">
									<input type="text" class="form-control resumeVal" name="email" placeholder="이메일">
								</div>
								<div class="col-1 px-1">
									<a class="form-control text-center">@</a>
								</div>
								<div class="col-6 pl-0 pr-1">
									<select class="form-control resumeVal" name="domain">
										<option>naver.com</option>
									</select>
								</div>
							</div>

							<div class="row mb-1">
								<div class="col-12 pr-1">
									<input type="text" class="form-control resumeVal" name="phone" placeholder="휴대폰번호">
								</div>
							</div>

							<div class="row mb-1">
								<div class="col-12 pr-1">
									<input type="text" class="form-control resumeVal" name="address" placeholder="주소">
								</div>
							</div>

						</div>
					</div>
				</div>
			</div>

			<div class="required">
				<h3 class="my-2">희망 직군</h3>
				<div class="card mb-2 card-body">
					<div class="row mb-1">
						<div class="col-3 px-0">
							<select class="form-control resumeVal" name="hopeClass">
								<option>정규직</option>
								<option>계약직</option>
								<option>인턴</option>
							</select>
						</div>
						<div class="col-9 px-1">
							<input type="text" class="form-control resumeVal" name="hopeSalary" placeholder="희망연봉">
						</div>
					</div>

					<div class="row">
						<div class="col-12 pl-0 pr-1">
							<input type="text" class="form-control w-100 resumeVal" name=hopeWerkspace placeholder="희망 근무지">
						</div>
					</div>

				</div>
			</div>
			<!-- 학력 -->
			<div class="resumeCon">
				<h3 class="my-2">학력</h3>
				<div class="card mb-2 card-body py-0 pr-2" id="eduContentList">
					
					<div class="text-center py-2 resumePlusBtn" data-url="eduContent">
						<i class="fa fa-plus-circle">
							<span>추가</span>
						</i>
					</div>
				</div>
			</div>
			<!-- 학력 끝 -->
			<!-- 경력 -->
			<div class="resumeCon">
				<h3 class="my-2">경력</h3>
				<div class="card mb-2 card-body py-0 pr-2" id="carContentList">

					<div class="text-center py-2 resumePlusBtn" data-url="carContent">
						<i class="fa fa-plus-circle">
							<span>추가</span>
						</i>
					</div>

				</div>
			</div>
			<!-- 경력 끝 -->
			<!-- 대외활동 -->
			<div class="resumeCon">
				<h3 class="my-2">인턴 및 대외 활동</h3>
				<div class="card mb-2 card-body py-0 pr-2" id="actContentList">
					
					<div class="text-center py-2 resumePlusBtn" data-url="actContent">
						<i class="fa fa-plus-circle">
							<span>추가</span>
						</i>
					</div>
				</div>
			</div>
			<!-- 대외활동 끝 -->
			<!-- 자격증 -->
			<div class="resumeCon">
				<h3 class="my-2">자격증</h3>
				<div class="card mb-2 card-body py-0 pr-2" id="licContentList">

					<div class="text-center py-2 resumePlusBtn" data-url="licContent">
						<i class="fa fa-plus-circle">
							<span>추가</span>
						</i>
					</div>

				</div>
			</div>
			<!-- 자격증 끝 -->
			<!-- 수상 -->
			<div class="resumeCon">
				<h3 class="my-2">수상</h3>
				<div class="card mb-2 card-body py-0 pr-2" id="awaContentList">

					<div class="text-center py-2 resumePlusBtn" data-url="awaContent">
						<i class="fa fa-plus-circle">
							<span>추가</span>
						</i>
					</div>

				</div>
			</div>
			<!-- 수상 끝 -->
				
			<a class="form-control text-center saveBtn">저장하기</a>

		</div>
	</form>
</div>

<!-- Modal -->
<div class="modal fade" id="eduModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">대학검색</h4>
				<button type="button" class="close" data-dismiss="modal">×</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-9 pr-0">
						<input class="form-control">
					</div>
					<div class="col-3 pl-1">
						<button class="form-control text-center searchBtn">검색</button>
					</div>
				</div>
				<div class="row" id="schoolList"></div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>


<script src="js/resume.js"></script>
<script>
	function imageURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#replaceMe').attr('src', e.target.result).css("width",
						"100%").css("height", "130px");
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$(function() {
		$("#upload").click(function(e) {
			$(this).next().click();
			return false;
		});

		$("#eduModalBtn").on("")

		resume.init();
	})
</script>
