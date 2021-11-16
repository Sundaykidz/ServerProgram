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
			width: 500px;
			margin: 0 auto;
		}
		.title {
			text-align: center;
			color: black;
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
		tbody input {
			width: 80px;
		}
		tfoot input {
			width: 100px;
			height: 30px;
			background-color: lightgray;
			border: 0;
			outline: 0;
			text-align: center;
		}
		tfoot input:first-of-type {
			background-color: skyblue;
		}
		tfoot input:hover {
			cursor: pointer;
			background-color: pink;
		}
	</style>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$('#f').on('submit', function(event){
				if ( $('#name').val() == '${member.name}' ) {
					alert('변경된 내용이 없습니다.');
					event.preventDefault();
					return false;
				}
				return true;
			});
			
		});
		$('#delete_btn').on('click', function(){
			if (confirm('탈퇴하시겠습니까?')) {
				location.href = '/BATCH/deleteMember.do?no=' + $(this).data('no');
			}
		});

	</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원 관리 시스템</h1>
		<hr>
		<form id="f" action="/ServerProgram/views/login.jsp" method="post">
			<table>
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
						<td>등급</td>
						<td>포인트</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="hidden" name="no" value="${member.no}">
							${member.no}
						</td>
						<td><input type="text" name="name" id="name" value="${member.name}"></td>
				
		
						<td><input type="text" name="point" id="point" value="${member.point}"></td>
						<td>${student.ave}</td>
						<td>${student.grade}</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<input type="submit" id="update_btn" value="수정하기">
							<input type="reset" id="delete_btn" value="탈퇴하기">					
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>