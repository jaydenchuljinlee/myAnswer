<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<script src="http://kenwheeler.github.io/slick/slick/slick.min.js"></script>

<script type="text/javascript">
	var footer = {
		pageSubmitFn : function(pageName) {
			$("#pageSubmit").attr("action", pageName + ".do");
			$("input[name=pageName]").val(pageName);
			$("#pageSubmit").submit();
		}
	}

	var fileControll = {
		fileList : [],
		readURL : function(inputTag) {
			var input = inputTag, div = $("#img_insert").children().eq(2)
					.children().eq(1).children(), length = 0;

			if (input.files && input.files[0]) {

				$.each(div, function(i, item) {

					var valid = $(item).children().attr("src");

					if (valid) {
						length++;
					} else {

						if (length === 4) {
							console.log(length);
							fileControll.createReader(i, input);

							$("#images").attr("disabled", true);

							return false;
						} else {

							fileControll.createReader(i, input);

							return false;
						}
					}
				})

			} else { //사진을 등록했다가 취소했을 경우
				return;
			}
		},

		createReader : function(index, file) {

			var reader = new FileReader(), imageDiv = document
					.createElement("div"), imageA = document.createElement("a");
			imageI = document.createElement("i");

			reader.onload = function() {
				$("#thum_img_" + (index + 1)).attr('src', reader.result);
				$("#thum_img").attr('src', reader.result);
			}
			reader.readAsDataURL(file.files[0]);

			imageDiv.setAttribute("class", "darkBox");
			imageA.setAttribute("class", "removeImg");
			imageA.setAttribute("href", "#");
			imageI.setAttribute("class", "fa fa-trash fa-2x");

			imageA.appendChild(imageI);

			$("#thum_img_" + (index + 1)).parent().append(imageDiv);
			$("#thum_img_" + (index + 1)).parent().append(imageA);

			fileControll.fileList.push(file.files[0]);

		},

		relocate : function() {
			var file_location = [], $div = $("#img_insert").children().eq(3)
					.children(), nextImage = "", imageDiv = document
					.createElement("div"), imageA = document.createElement("a");
			imageI = document.createElement("i");

			imageDiv.setAttribute("class", "darkBox");
			imageA.setAttribute("class", "removeImg");
			imageA.setAttribute("href", "#");
			imageI.setAttribute("class", "fa fa-trash fa-2x");

			imageA.appendChild(imageI);

			$
					.each(
							$div,
							function(i, item) {

								if (typeof $(item).children("img").attr("src") !== "undefined") {

									nextImage = $(item).next().children("img")
											.attr("src");

									// 현재 이미지는 있는데 다음 이미지가 없을 때, 지금 요소를 비워주기 위함 
									if (typeof nextImage !== "undefined") {

										return;

									} else {
										$(item).children("img").removeAttr(
												"src");
										$(item).children(".darkBox").remove();
										$(item).children(".removeImg").remove();
									}

								} else {

									nextImage = $(item).next().children("img")
											.attr("src");

									// 현재 이미지가 없을 때, 다음 이미지를 현재 이미지에 넣고  위함
									if (typeof nextImage !== "undefined") {

										$(item).append(imageDiv);
										$(item).append(imageA);

										$(item).children("img").attr("src",
												nextImage);
									} else {
										return;
									}
								}
							})
		}
	}

	$(function() {

		$("#images").on('change', function() {

			fileControll.readURL(this);
		});

		$(".navi_menu").on("click", function() {
			console.log(this);
			var pageName = $(this).attr("id");

			footer.pageSubmitFn(pageName);
		})

		$(".image-wrapper").on("click", "a", function() {

			var fileIdx = $(".image-wrapper").index($(this).parent());

			fileControll.fileList.splice(fileIdx, 1);

			$(this).prev().prev().removeAttr("src");
			$(this).prev().remove();
			$(this).parent().parent().prev().children().removeAttr("src");
			$(this).remove();

			fileControll.relocate();
		})

		$("input[name='videoFile']").on(
				"click",
				function() {
					var radio = $(this).val();
					console.log($(this).next().next());
					if (radio === "1") {
						$(this).next().next().removeAttr("disabled");
						$(this).parent().next().children(".media-video").attr(
								"disabled", true);
					} else {
						$(this).next().next().removeAttr("disabled");
						$(this).parent().prev().children(".media-video").attr(
								"disabled", true);
					}
				})

		$('.slider').slick({
			slidesToShow : 5, //작은이미지 몇개 보여줄것인지..
			slidesToScroll : 1,
			focusOnSelect : true,
			swipe : true,
			infinite : false,
			dots : true
		});

		$('.slider-for').slick({
			slidesToShow : 1,
			slidesToScroll : 1,
			arrows : false,
			fade : true,
			asNavFor : '.slider-nav',
			infinite : true,
		});
		$('.slider-nav').slick({
			slidesToShow : 3,
			slidesToScroll : 1,
			asNavFor : '.slider-for',
			dots : true,
			centerMode : true,
			focusOnSelect : true,
			infinite : true,
		});

		$("ul.tabs li").on("click", function() {

			var activeTab = $(this).attr("rel");

			var offset = $("#" + activeTab);

			$(window).scrollTop(offset.offset().top - 100);

		});
	})
</script>



<!-- lnb -->
<aside class="col-lg-3">
	<div class="leftBox p-1 mb-2">
		<div>
			<span>나의 포트폴리오</span>
		</div>
		<ul>
			<li id="update_portfolio" class="navi_menu m-3" data-cont="edu">
				<button class="w-80 text-left">
					<i class="fa fa-graduation-cap fa-lg"></i>
					<span>포트폴리오 수정</span>
				</button>
			</li>
			<li id="create_portfolio" class="navi_menu m-3" data-cont="edu">
				<button class="w-80 text-left">
					<i class="fa fa-graduation-cap fa-lg"></i>
					<span>포트폴리오 등록</span>
				</button>
			</li>
			<li id="detail_portfolio" class="navi_menu m-3" data-cont="edu">
				<button class="w-80 text-left">
					<i class="fa fa-graduation-cap fa-lg"></i>
					<span>포트폴리오 상세</span>
				</button>
			</li>
			<li id="list_portfolio" class="navi_menu m-3" data-cont="edu">
				<button class="w-80 text-left">
					<i class="fa fa-graduation-cap fa-lg"></i>
					<span>포트폴리오 목록</span>
				</button>
			</li>
		</ul>
	</div>
	<div class="resume-left">
		<div>
			<div class="form-inline w-100 mb-1">
				<div class="w-100 p-1">
					<div class="align-middle p-2">대표 포트폴리오 지정</div>
				</div>
			</div>
			<div class="form-inline w-100 mb-1">
				<div class="w-100 p-1">
					<div class="align-middle p-2">수정하기</div>
				</div>
			</div>
		</div>
		<div class="w-100 p-1">
			<div class="align-middle p-2">작성완료</div>
		</div>
	</div>
</aside>
<!--// lnb -->