<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<html>
<head>
<title>param</title>
</head>
<body>
<h2>EL�������� param��paramValues</h2>
  <fmt:requestEncoding value="GB2312" />
  <%request.setCharacterEncoding("gb2312"); %>
  ������${param.username}</br>
  ���룺${param.password}</br>
  �Ա�${param.sex}</br>
  ���䣺${param.age}</br>
  ��Ȥ��${paramValues.habit[0]}  ${paramValues.habit[1]}
</body>
</html>
