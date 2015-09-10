<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <title>스프링프레임워크</title>
  </head>
  <body>
  <h1>${message}</h1>
	<form id="form" method="post" action="./write_ok">
	<input type="hidden" name="id" id="id" value="${object.id}" />
	<div>
	<span>아이디</span>
	<input type="text" id="uid" name="uid" value="${object.uid}" />
	</div>
	<div>
	<span>비밀번호</span>
	<input type="text" id="password" name="password" value="${object.password}" />
	</div>
    <div>
    <span>성별</span>
    <input type="text" id="sex" name="sex" value="${object.sex}" />
    </div>
    <div>
    <span>닉네임</span>
    <input type="text" id="name" name="name" value="${object.name}" />
    </div>
    <div>
    <span>이메일</span>
    <input type="text" id="email" name="email" value="${object.email}" />
    </div>


	<div>
	<input type="submit" value="save" />
	<a href="./">목록</a>
	</div>
	</form>
  </body>
</html>