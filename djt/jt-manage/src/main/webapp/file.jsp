<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	
	<body>
		<!-- 开启多媒体提交 -->
		<form action="http://localhost:8091/file" enctype="multipart/form-data" method="post">
		图片:<!-- 文件类型上传 filePic传给客户端-->
		<input type="file" name="filePic"/>
		<br>
		<input type="submit" value="提交"/>
		</form>
	</body>
</html>