<%@ page language="java" pageEncoding="GB18030"%>
<html>
<head>
<title>Logon</title>
</head>
<body>
	<form name="form1" action="./Validator" method="POST">
		<table>
			<tr>
				<td>�û�����</td>
				<td><input type="text" name="username" id="username" />
				</td>
			</tr>
			<tr>
				<td>��&nbsp;&nbsp;�룺</td>
				<td><input type="password" name="password" id="password" />
				</td>
			</tr>
			<tr>
				<td colospan="2" align="center"><input type="submit"
					name="logon" value="��¼" />&nbsp;&nbsp; <input type="reset"
					name="reset" value="����" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
