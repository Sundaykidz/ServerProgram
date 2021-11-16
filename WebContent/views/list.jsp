<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<style>
		.wrap {
			width: 800px;
			margin: 0 auto;
		}
		.title {
			text-align: center;
			color: black;
		}
		.btn_area {
			width: 800px;
			height: 100px;
			text-align: center;
			line-height: 100px;
		}
		#insert_btn {
			width: 200px;
			height: 50px;
			background-color: pink;
			border: 0;
			outline: 0;
			font-size: 20px;
			text-align: center;
		}
		#insert_btn:hover {
			cursor: pointer;
			background-color: pink;
		}
		table {
			width: 100%;
			border-collapse: collapse;
		}
		td {
			border-top: 1px solid gray;
			border-bottom: 1px solid gray;
			text-align: center;
			padding: 3px 5px;
		}
	</style>
	<script>
		$(document).ready(function(){
			
			$('.update_btn').on('click', function(){
				let id = $(this).prev().val();
				location.href = '/BATCH/memberDetail.do?id=' + id;
			});
			
			$('.delete_btn').on('click', function(){
				if (confirm('삭제할까요?')) {
					location.href = '/BATCH/deleteMember.do?no=' + $(this).data('no');
				}
			});
			
		})
	</script>
</head>
<body>

	<div class="wrap">
		<div class="btn_area">
			<button id="insert_btn" onclick="location.href='/ServerProgram/views/login.jsp'">로그인하러 가기</button>
		</div>
		<h1 class="title">회원 목록</h1>

		<table>
			<thead>
				<tr>
					<td>회원번호</td>
					<td>아이디</td>
					<td>이름</td>
					<td>등급</td>
					<td>포인트</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${totalCount eq 0}">
					<tr>
						<td colspan="5">등록된 회원이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${totalCount gt 0}">
					<c:forEach items="${list}" var="member">
						<tr>
							<td>${member.no}</td>
							<td>${memeber.id}</td>
							<td>${member.name}</td>
							<td>${member.grade}</td>
							<td>${member.point}</td>
							<td>
								<input type="hidden" value="${member.no}">
								<input type="button" value="로그인" class="update_btn">
								
								<input type="button" value="회원가입" data-no="${member.no}" class="delete_btn">
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>