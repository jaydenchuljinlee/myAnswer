<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="js/introduction.js"></script>
<script>
	$(function() {
		introduction.init();
	})
</script>
<div class="col-lg-9">
	<form id="qestFrm">
		<h4 class="text-center mt-5 mb-3" style="font-size: 20px;">Q . 기본 질문</h4>

		<div class="form-group">
			<input class="form-control mb-2" placeholder="질문">
			<textarea class="form-control" placeholder="답변" name="answer" rows="10"></textarea>
		</div>

		<div class="row">
			<div class="col-8"></div>
			<div class="col-4">
				<button class="form-control plusBtn">질문추가하기</button>
			</div>
		</div>

	</form>

	<hr>
	<div class="row">
		<div class="col-4 mx-auto">
			<button class="form-control saveBtn">저장하기</button>
		</div>
	</div>
</div>

<script>
	$(function() {
		$("#qestFrm").on("click", ".plusBtn", function() {
			var $this = $(this);
			
			$.ajax({
				url : 'plusQ.do',
				type : 'get',
				dataType : "html",
				contentType : "application/html; charset=UTF-8;",
				success : function(data) {	
					$this.closest(".row").remove();
					$("#qestFrm").append(data);
				}
			}); // ajax 종료
			return false;
		});
		
		$("#qestFrm").parent().on("click", ".saveBtn", function() {
			var 	$this = $(this)
				,	validation = true;
			
			$("#qestFrm").find(".qestFrmVal").each(function(i) {
				if ($("#qestFrm").find(".qestFrmVal").eq(i).val() === "") {
					validation = false;
					$("#qestFrm").find(".qestFrmVal").eq(i).focus();
					return validation;
				}	
			});
			if (validation) {
				$("#qestFrm").attr("method", "post").attr("action", "saveIntroduce.do").submit();
			}
		});
	})
</script>