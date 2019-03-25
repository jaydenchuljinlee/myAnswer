/**
 * 
 */
var introduction = {
		qNum : 0,
		init : function() {
			this.$newIntroBtn = $("#newIntroBtn");
			this.$questionList = $("#questionList");
			this.$qestFrm = $("#qestFrm");
			
			this.connectEvent();
		},
		connectEvent : function() {
			var that = this
			
			that.$newIntroBtn.on("click", function() {
				var $this = $(this);
				
				that.plusQuestionAjax(function(data) {
					$this.remove();
					that.newIntroFn(data);
				});
				
			})	//자기소개서 추가 버튼 이벤트 종료
			
			that.$qestFrm.on("click", ".pulsAtag", function() {
				var $this = $(this);

				that.plusQuestionAjax(function(data) {
					that.$questionList.append(data);
				});
				
			});
			
			that.$questionList.on("click", ".closeBtn", function() {
				var $this = $(this);
				$this.closest(".form-group").remove();
			});
			
			that.$qestFrm.on("click", ".saveBtn", function() {
				var input = that.$qestFrm.find("input, textarea"), 
					 validation = true;

				for (var i = 0; i < input.length; i++) {
					if (input[i].value === "") {
						validation = false;
						return alert("값이 비어있습니다.");
					}
				}

				if (validation) {
					that.$qestFrm.attr("method", "post")
									  .attr("action", "saveIntroduction.do")
									  .submit();
				}
			})
			
		},
		
		plusQuestionAjax : function(successFn) {
			$.ajax({
				url : 'plusQuestion.do',
				type : 'get',
				data : {
					"qNo" : this.qNum +=1
				},
				dataType : "html",
				contentType : "application/html; charset=UTF-8;",
				success : successFn
			}); // ajax 종료
		},
		
		newIntroFn : function(html) {
			var that = this,
				 titleInput = document.createElement("input"),
				 plusBtn = document.createElement("i"),
				 saveBtn = document.createElement("a"),
				 newLeft = document.createElement("li"),
				 newLeft2 = document.createElement("button"),
				 newLeft3 = document.createElement("i"),
				 newLeft4 = document.createElement("span");
			
			newLeft.setAttribute("class", "navi_menu m-3 active mt-3");
			newLeft2.setAttribute("class", "w-80 text-left");
			newLeft3.setAttribute("class", "fa  fa-user-circle-o fa-lg");
			newLeft4.textContent = "새로운 자기소개서";
			
			newLeft2.append(newLeft3)
			newLeft2.append(newLeft4)
		
			newLeft.append(newLeft2)
			
			//레프트에 추가
			introLeft.$myIntroList.append(newLeft);	
				
			titleInput.setAttribute("class", "form-control mb-3");
			titleInput.setAttribute("placeholder", "자기소개서 제목");
			
			plusBtn.setAttribute("class", "fa fa-plus pulsAtag");
			plusBtn.textContent = "질문 추가";
			
			saveBtn.setAttribute("class", "form-control mt-5 text-center saveBtn");
			saveBtn.textContent = "저장하기"
			
			//자기소개서 제목과 질문추가 버튼과 저장 버튼
			that.$qestFrm.prepend(titleInput)
							  .append(plusBtn)
							  .append(saveBtn);
			
			that.$questionList.append(html);
		}
	}