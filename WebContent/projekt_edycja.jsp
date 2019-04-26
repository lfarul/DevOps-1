<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ProjektEdycja" method="POST"> 
<input name="btn_zapisz" value="Zapisz" type="submit">
${projekt.projektId}
<form action="ProjektEdycja" method="POST"> 
<input name="btn_usun" value="Usuń" type="submit">
${projekt.projektId}
</form> 
</body>
</html>