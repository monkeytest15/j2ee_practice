<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>Param</title>
</head>
<body>
<form method="post" action="param.jsp">
  <p>������<input type="text" name="username" size="15" /></p>
  <p>���룺<input type="password" name="password" size="15" /></p>
  <p>�Ա�<input type="radio" name="sex" value="Male" checked/>��
       <input type="radio" name="sex" value="Female"  /> Ů</p>
  <p>���䣺<input type="password" name="age" size="15" /></p>
  <p>��Ȥ��<input type="checkbox" name="habit" value="ѧϰ"/>ѧϰ
     <input type="checkbox" name="habit" value="�˶�"/>�˶�
     <input type="checkbox" name="habit" value="����"/>���� 
     <input type="checkbox" name="habit" value="����"/>���� </p>
  <p>   <input type="submit" value="����"/>
          <input type="reset" value="����"/></p>
</form>
</body>
</html>	
