<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>ȸ����ȣ</th>
		<td>${login.customerNo}</td>
	</tr>
	<tr>
		<th>���̵�</th>
		<td>${login.customerId}</td>
	</tr>
	<tr>
		<th>�̸�</th>
		<td>${login.customerName}</td>
	</tr>
	<tr>
		<th>�г���</th>
		<td>${login.customerNickname}</td>
	</tr>
	<tr>
		<th>�̸���</th>
		<td>${login.customerEmail}</td>
	</tr>
	<tr>
		<th>���ɻ�</th>
		<td>${login.customerInterest}</td>
	</tr>
</table>
</body>
</html>