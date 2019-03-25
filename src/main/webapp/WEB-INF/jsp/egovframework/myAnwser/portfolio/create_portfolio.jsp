<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-9">
	<form id="pofolFrm" method="post" enctype="multipart/form-data">
		<div class="portfolio mt-4">
			<span>제목</span>
			<div class="row" style="width: 70%; background: #9fcff3; margin: 1%; border: 1px solid #e8ecef">
				<input class="form-control" type="text" placeholder="제목을 입력해 주세요..">
			</div>
			<br>

			<div id="img_insert">
				<span>이미지 등록</span>
				<div class="row">
					<input id="images" class="form-control" type="file" name="upload" placeholder="파일 업로드" multiple="multiple">
				</div>
				<!-- <div>
			<img id="thum_img">
		</div> -->
				<div class="slider form-inline">
					<div class="image-wrapper">
						<img id="thum_img_1" src="images/bootstrap/mask.png">
					</div>
					<div class="image-wrapper">
						<img id="thum_img_2" src="images/bootstrap/mask.png">
					</div>
					<div class="image-wrapper">
						<img id="thum_img_3" src="images/bootstrap/mask.png">
					</div>
					<div class="image-wrapper">
						<img id="thum_img_4" src="images/bootstrap/mask.png">
					</div>
					<div class="image-wrapper">
						<img id="thum_img_5" src="images/bootstrap/mask.png">
					</div>
					<div class="image-wrapper">
						<img id="thum_img_6" src="images/bootstrap/mask.png">
					</div>
				</div>
			</div>
			<br>

			<span>동영상 등록</span>
			<div class="form-inline" style="width: 100%;">
				<input type="radio" name="videoFile" value="1">
				<div class="row" style="width: 15%; margin: 1%">
					<span>URL 업로드 :</span>
				</div>
				<input class="form-control media-video" type="text" style="width: 60%; margin: 1%" placeholder="url을 입력해 주세요">
			</div>
			<div class="form-inline" style="width: 100%">
				<input type="radio" name="videoFile" value="2">
				<div class="row" style="width: 15%; margin: 1%">
					<span>파일 업로드 :</span>
				</div>
				<input id="multi" class="form-control media-video" type="file" name="upload" style="width: 40%; margin: 1%" placeholder="파일 업로드" multiple>
			</div>
			<br>

			<span>상세 설명</span>
			<div class="form-inline" style="width: 100%">
				<input class="form-control" type="text" style="width: 90%; height: 500px; margin: 1%" placeholder="url을 입력해 주세요">
			</div>
			<br>
		</div>
	</form>
</div>