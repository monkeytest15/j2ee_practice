<%@ page contentType="text/html; charset=gb2312" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib uri="/WEB-INF/tlds/MyfontTagLib.tld" prefix="mytag"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>myfont�Զ����ǩʵ��</title>
</head>

<body>
	<h2>myfont��ǩ</h2>
	<mytag:myfont color="Blue">
	ǧɽ��ɾ���
	</mytag:myfont>
	<mytag:myfont color="red" border="3" bgColor="white">
	��������
	</mytag:myfont>
	<mytag:myfont color="green" fontSize="5" bgColor="#c0c0c0">
	���������̣�
	</mytag:myfont>
	<mytag:myfont color="#c0c0c0" border="7" bgColor="#123456" fontSize="6">
	��������ѩ��
	</mytag:myfont>
</body>
</html>
