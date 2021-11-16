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
			width: 150px;
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
			background-color: pink
	</style>
	<script type="text/javascript">
	
		$(document).ready(function(){
			$('#f').on('submit', function(event){
				if ( $('#id').val() == '' ) {
					alert('아이디를 입력해주세요');
					$('#no').focus();
					event.preventDefault();
					return false;
				} else if ( $('#name').val() == '' ) {
					alert('이름을 입력해주세요.');
					$('#name').focus();
					event.preventDefault();
					return false;
				}
				return true;
			});
		});
		
	</script>
</head>
<body>

	<div class="wrap">
		<h1 class="title">회원 가입 폼</h1>
		<form id="f" action="/ServerProgram/views/join_complete.jsp" method="post">
			<table>
				<thead>
					<tr>
						<td>아이디</td>
						<td>이름</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="id" id="id" autofocus></td>
						<td><input type="text" name="name" id="name"></td>
						
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="submit" id="insert_btn" value="회원가입">
							<input type="button" value="돌아가기" onclick= "/ServerProgram/views/login.jsp">						
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>