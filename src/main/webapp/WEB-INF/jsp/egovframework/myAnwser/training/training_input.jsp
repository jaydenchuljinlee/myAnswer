<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	var question = {
		qNum : 0,
		init : function(qNum) {
			this.qNum = qNum;
		},
		create : function(questionTxt) {
			var questionDiv = document.createElement("div"), questionSpan_1 = document
					.createElement("span"), questionSpan_2 = document
					.createElement("span"), questionButton = document
					.createElement("button");

			this.qNum += 1;

			questionDiv.setAttribute("class", "form-inline");

			questionSpan_1.textContent = "Q" + this.qNum + ".";
			questionSpan_2.textContent = questionTxt;
			questionButton.textContent = "x";

			questionDiv.appendChild(questionSpan_1);
			questionDiv.appendChild(questionSpan_2);
			questionDiv.appendChild(questionButton);

			$("#completed_q").append(questionDiv);

		}
	}
	$(function() {
		question.init(1);

		$("#completed_q").on("click", "button", function() {

			$(this).parent().remove();
		})

		$("#question_plus").on("click", function() {
			var $questionTxt = $(this).parent().prev().children().eq(1);

			if ($questionTxt.val().trim() === "") {
				return alert("질문을 입력해주세요");
			} else {
				question.create($questionTxt.val());
				$questionTxt.val("");
			}
		})
	})
</script>
<div class="col-lg-9">
	<div class="row resume mt-4">
		<div id="completed_q">
			<div class="form-inline">
				<span>Q1</span>
				<span>어머니 성함은?</span>
				<button>x</button>
			</div>
		</div>
		<div id="preparing_q">
			<div class="form-inline">
				<span style="float: left; width: 5%; padding: 10px">Q</span>
				<input class="form-control" type="text" style="width: 95%; padding: 10px; margin-top: 10px;" placeholder="질문을 입력해 주세요..">
			</div>
			<div style="width: 20%; margin: auto">
				<button id="question_plus" class="form-control" style="background: #e8ecef; border: none; cursor: pointer;">
					<i class="fa fa-plus-circle">
						<span>추가</span>
					</i>
				</button>
			</div>
			<div>
				<button class="form-control" style="">저장</button>
			</div>
		</div>
	</div>
</div>