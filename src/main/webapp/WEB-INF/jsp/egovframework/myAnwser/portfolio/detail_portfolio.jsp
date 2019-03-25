<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-9">

	<div class=" mt-4">
		<br>
		<div class="pofol-tile" style="width: 100%; text-align: center">
			<h3>내가 다했다</h3>
		</div>
		<br>
		<div>
			<ul class="tabs">
				<li class="active" rel="tab_images">이미지</li>
				<li rel="tab_video">영상</li>
				<li rel="tab_comments">상세설명</li>
			</ul>
		</div>
		<div class="tab_connect">
			<div id="tab_images" class="tab_contents">
				<div id="img_slider">
					<div style="width: 100%; text-align: center;">
						<span style="font-family: Georgia; font-size: 50px; border-bottom: 3px solid black;">
							<i class="fa fa-picture-o"></i>
							Slide Show
						</span>
					</div>
					<div class="big-slider slider-for form-inline">
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_1" src="images/seq_1.png">
						</div>
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_2" src="images/seq_2.png">
						</div>
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_3" src="images/seq_3.png">
						</div>
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_4" src="images/seq_4.png">
						</div>
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_5" src="images/seq_5.png">
						</div>
						<div class="image-wrapper" style="height: 400px; border: 2px solid #e4e1e1">
							<img id="thum_img_6" src="images/seq_6.png">
						</div>
					</div>
					<div class="slider-nav form-inline">
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_1" src="images/seq_1.png">
						</div>
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_2" src="images/seq_2.png">
						</div>
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_3" src="images/seq_3.png">
						</div>
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_4" src="images/seq_4.png">
						</div>
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_5" src="images/seq_5.png">
						</div>
						<div class="image-wrapper" style="margin: 10px; border: 1px solid #e4e1e1;">
							<img id="thum_img_6" src="images/seq_6.png">
						</div>
					</div>
				</div>
				<br>
			</div>
			<div id="tab_video" class="tab_contents">
				<div class="form-inline" style="width: 100%; text-align: center; margin: 10px">

					<span style="font-family: Georgia; font-size: 50px; border-bottom: 3px solid black;">
						<i class="fa fa-caret-square-o-right"></i>
						Video
					</span>
				</div>
				<div class="form-inline" style="width: 100%;">
					<iframe width="100%" height="450px" src="https://www.youtube.com/embed/s8_TQplIxhk?autoPlay=1"></iframe>
				</div>
				<br>
			</div>
			<div id="tab_comments" class="tab_contents">
				<div style="width: 100%; text-align: center; margin: 10px">
					<span style="font-family: Georgia; font-size: 50px; border-bottom: 3px solid black;">
						<i class="fa fa-file-text-o"></i>
						Comments
					</span>
				</div>
				<div class="form-inline" style="width: 100%;">
					<table style="width: 100%; border: 1px solid #e4e1e1">
						<tbody>
							<tr>
								<td style="width: 20%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">프로젝트 명</td>
								<td style="width: 30%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">??</td>
								<td style="width: 20%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">참여 인원</td>
								<td style="width: 30%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">??</td>
							</tr>
							<tr>
								<td style="width: 20%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">개발 기간</td>
								<td style="width: 30%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">??</td>
								<td style="width: 20%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">URL</td>
								<td style="width: 30%; border: 1px solid #e4e1e1; text-align: center; height: 50px; font-family: Georgia;">??</td>
							</tr>
							<tr>
								<td colspan=2 style="width: 50%; border: 1px solid #e4e1e1; text-align: center; height: 200px; font-family: Georgia;">개발 환경</td>
								<td colspan=2 style="width: 50%; border: 1px solid #e4e1e1; text-align: center; height: 200px; font-family: Georgia;">??</td>
							</tr>
							<tr>
								<td colspan=2 style="width: 50%; border: 1px solid #e4e1e1; text-align: center; height: 200px; font-family: Georgia;">상세 설명</td>
								<td colspan=2 style="width: 50%; border: 1px solid #e4e1e1; text-align: center; height: 200px; font-family: Georgia;">??</td>
							</tr>
						</tbody>
					</table>
				</div>
				<br>
			</div>
		</div>

	</div>
</div>