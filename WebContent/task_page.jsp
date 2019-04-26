<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String info = request.getParameter("x_info");
if(info != null && info.length() > 0){
out.print(info);
}else{
out.print("Parametr x_info nie został przekazany!");
}
%>
<br/><hr/>
<%="Hello World!"%><br/>
Data: <%=new SimpleDateFormat("dd-MM-yyyy").format(new Date())%><br/>
ID Studenta: <%=request.getParameter("x_student_id")%><br/>

<%= request.getAttribute("x_redirect")%>

</body>
</html>