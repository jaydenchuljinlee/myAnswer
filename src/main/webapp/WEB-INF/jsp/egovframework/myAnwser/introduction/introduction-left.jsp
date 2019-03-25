<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<style>
.downMenu {
	display: none;
}
</style>

<script>
	var introLeft = {
		init : function() {
			this.$myIntroList = $("#myIntroList")

			this.connEvt();
		},
		connEvt : function() {
			var that = this;
			
			that.$myIntroList.on("click", ".navi_menu", function() {
				var 	$this = $(this)
					,	h4Tag = undefined
					,	dataUrl = $this.data("url");	
				
				that.$myIntroList.children(".navi_menu").removeClass("active");
				$this.addClass("active");
				
				if (dataUrl === "plusQ") {
					h4Tag = document.createElement("h4");
					h4Tag.setAttribute("class", "text-center mt-5 mb-3");
					h4Tag.setAttribute("style", "font-size: 20px;");
					h4Tag.textContent = "Q. 기본질문";
					
					$.ajax({
						url 			: dataUrl + '.do',
						type 			: 'get',
						dataType 	: "html",
						contentType : "application/html; charset=UTF-8;",
						success 	: function(data) {
							$("#qestFrm").html(h4Tag).append(data);
						}
					}); // ajax 종료
					
				} else {
					$.ajax({
						url 			: dataUrl + '.do',
						type 			: 'get',
						dataType 	: "html",
						contentType : "application/html; charset=UTF-8;",
						success 	: function(data) {
							$("#qestFrm").html(data);
						}
					}); // ajax 종료
				}
			});

		}
	}
	$(function() {
		introLeft.init();
	})
</script>

<!-- lnb -->
<aside class="col-lg-3">
	<div class="leftBox p-1 mb-2">
		<div class="my-3">
			<span>이철진님의 자기소개서</span>
		</div>
		<ul id="myIntroList">
			<li class="navi_menu p-3 active" data-url="plusQ">
				<button class="w-80 text-left">
					<i class="fa  fa-user-circle-o fa-lg"></i>
					<span>기본 질문</span>
				</button>
			</li>
			<li class="navi_menu p-3" data-url="careerQ">
				<button class="w-80 text-left">
					<i class="fa  fa-user-circle-o fa-lg"></i>
					<span>경력 질문</span>
				</button>
			</li>
			<li class="navi_menu p-3" data-url="activityQ">
				<button class="w-80 text-left">
					<i class="fa  fa-user-circle-o fa-lg"></i>
					<span>대외 활동 질문</span>
				</button>
			</li>
		</ul>
	</div>

	<div class="training-left">
		<div class="w-100 p-1">
			<div class="align-middle m-3">작성완료</div>
		</div>
	</div>
</aside>
<!--// lnb -->