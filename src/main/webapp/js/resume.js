/**
 * 
 */
var resume = {
		init : function() {
			
			//레프트
			this.$resumeUl 	= $("#resume-ul");
			//이력서 컨텐츠
			this.$resume 		= $(".resume");	
			//학교 검색 모달창
			this.$eduModal 	= $("#eduModal");	

			this.$eduContentList 	= this.$resume.find("#eduContentList");
			this.$carContentList 	= this.$resume.find("#carContentList");
			this.$actContentList 	= this.$resume.find("#actContentList");
			this.$licContentList 	= this.$resume.find("#licContentList");
			this.$awaContentList 	= this.$resume.find("#awaContentList");
			
			this.connEvt();
		},
		connEvt : function() {
			var that = this;
			
			that.$resumeUl.on("click", "li", function() {
				that.leftLiClick(this);
			});
			
			that.$resume.on("click", ".resumePlusBtn", function() {
				that.plusBtnClick(this);
			});
			
			that.$resume.on("click", ".delConBtn", function() {
				var 	$this 				= $(this)
					,	$thisRow 		= $this.closest(".row")
					, 	$delContent 	= $thisRow.parent();
				
				$delContent.remove();
			});

			that.$resume.on("click", ".eduModalBtn", function() {
				var 	$this 				= $(this)
					, 	$eduContent 	= $this.closest(".eduContent");
				
				that.$eduModal	.data("index", $eduContent.index())
											.modal("show");
			});
			
			that.$eduModal.on("click", ".searchBtn", function() {
				that.schoolSearch();
			});
			
			that.$eduModal.on("click", "#schoolList .col-12", function() {
				that.schoolClick(this);
			});
			
			that.$resume.on("click", ".saveBtn", function() {
				that.saveBtnClick();
			});
			
		},
		leftLiClick : function(li) {
			var 	$this 		= $(li)
				,	url 			= $this.data("url")
				, 	$content 	= $("#" + url + "List");
		
			if ($this.hasClass("selected")) { 
				console.log($this.children().eq(1).children())
				$this.removeClass("selected")
						.children().eq(1).children()	// +/- 아이콘
						.attr("class", "fa fa-plus-circle fa-lg");
				
				$content	.closest(".resumeCon").css("display", "none");		//이력서 항목 컨테츠 부분을 숨기기
				$content	.children("." + url)	//인풋 내용만 제거
								.remove();
			} else {
				$this.addClass("selected")
						.children().eq(1).children()	// +/- 아이콘
						.attr("class", "fa fa-minus-circle fa-lg");
				
				$.ajax({
					url 			: url + ".do",
					type 			: 'get',
					dataType 	: "html",
					contentType : "application/html; charset=UTF-8;",
					success 	: function(data) {
						$content	.prepend(data)
									 	.closest(".resumeCon")
									 	.css("display", "block");
					}
				}); // ajax 종료
			}
		},
		schoolClick : function(schoolNmTag) {
			var 	index 	= this.$eduModal.data("index")
				, 	$this 	= $(schoolNmTag)
				, 	schoolName	= $.trim($this.text())
				, 	schoolCode 		= $this.data("school-code");
			
			this.$eduModal.find("#schoolList").children().remove();
			this.$eduModal.find("input").val("");
			this.$eduModal.modal("hide");
			this.$eduContentList	.children(".eduContent")
												.eq(index).find("input")
												.eq(1).val(schoolName)
												.next().val(schoolCode);
		},
		schoolSearch : function() {
			var 	that 				= this
				,	schoolNm	= that.$eduModal.find("input").val();
			
			$.ajax({
				url 			: 'schollSearch.do',
				type 			: 'get',
				data 		: {"schoolNm" : schoolNm},
				dataType 	: "html",
				contentType : "application/html; charset=UTF-8;",
				success 	: function(data) {
					//학교 리스트를 모달창에 추가
					that.$eduModal.find("#schoolList").html(data);
				}
			}); // ajax 종료
		},
		plusBtnClick : function(plusBtn) {
			var 	$this	= $(plusBtn)
					, url 		= $this.data("url");
		
			$.ajax({
				url 			: url + '.do',
				type 			: 'get',
				dataType 	: "html",
				contentType : "application/html; charset=UTF-8;",
				success 	: function(data) {
					$this.before(data);	//클릭한 플러스 버튼 위에 추가
				}
			}); // ajax 종료
		},
		saveBtnClick : function() {
			var 	that = this
				,	validation 	= true
				, 	$resumeVal	= $(".resumeVal")
				, 	validation 	= true
				, 	paramobj 	= {};
			
			//NULL 체크
			$resumeVal.each(function(i,input) {
				if (!$resumeVal.eq(i).val()) {
					$resumeVal.eq(i).focus();
					alert("값이 비어있습니다.");
					validation = false;
					return validation;
				}
			});
			
			//학력 리스트 검사
			that.$eduContentList.children(".eduContent").each(function(i) {
				paramobj = {};
				
				that.$eduContentList.children(".eduContent").eq(i).find(".resumeVal").each(function(i,input) {
					paramobj[input.getAttribute("data-key")] = input.value;
				});
				
				that.$eduContentList.children(".eduContent").eq(i).children("input").val(JSON.stringify(paramobj));
			});
			//학력 리스트 검사 종료
			
			//경력 리스트 검사 시작
			that.$carContentList.children(".carContent").each(function(i) {
				paramobj = {};
				
				that.$carContentList.children(".carContent").eq(i).find(".resumeVal").each(function(i,input) {
					paramobj[input.getAttribute("data-key")] = input.value;
				});
				
				that.$carContentList.children(".carContent").eq(i).children("input").val(JSON.stringify(paramobj));
			});
			//경력 리스트 검사 종료

			//대외활동 리스트 검사 시작
			that.$actContentList.children(".actContent").each(function(i) {
				paramobj = {};
				
				that.$actContentList.children(".actContent").eq(i).find(".resumeVal").each(function(i,input) {
					paramobj[input.getAttribute("data-key")] = input.value;
				});
				
				that.$actContentList.children(".actContent").eq(i).children("input").val(JSON.stringify(paramobj));
			});
			//대외활동 리스트 검사 종료

			//자격증 리스트 검사 시작
			that.$licContentList.children(".licContent").each(function(i) {
				paramobj = {};
				
				that.$licContentList.children(".licContent").eq(i).find(".resumeVal").each(function(i,input) {
					paramobj[input.getAttribute("data-key")] = input.value;
				});
				
				that.$licContentList.children(".licContent").eq(i).children("input").val(JSON.stringify(paramobj));
			});
			//자격증 리스트 검사 종료
			
			//수상 내역 리스트 검사 시작
			that.$awaContentList.children(".awaContent").each(function(i) {
				paramobj = {};
				
				that.$awaContentList.children(".awaContent").eq(i).find(".resumeVal").each(function(i,input) {
					paramobj[input.getAttribute("data-key")] = input.value;
				});
				
				that.$awaContentList.children(".awaContent").eq(i).children("input").val(JSON.stringify(paramobj));
			});
			//수상 내역 리스트 검사 종료
			
			if (validation) {
				$("#resumeFrm")	.attr("action", "saveResume.do")
												.attr("method", "post")
												.submit();
			}
		}
}