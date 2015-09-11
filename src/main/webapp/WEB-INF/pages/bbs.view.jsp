<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>스프링프레임워크</title>
  </head>
  <body>
    
    <script>
    function del(){
      if (confirm("삭제하시겠습니까?")) document.form.submit();
    }
    </script>
    
    <form id="form" name="form" method="post" action="./delete">
      <input type="hidden" id="id" name="id" value="${object.id}" />
    </form>
    <div>
    <p>아이디 : ${object.uid}</p>
    <p>비밀번호 : ${object.password}</p>
    <p>성별 : ${object.sex}</p>
    <p>닉네임 : ${object.name}</p>
    <p>이메일 : ${object.email}</p>
    </div>
    
    <div>
      <button type="button" onclick="del()">삭제</button>
      <a href="./write?id=${object.id}">수정</a>
      <a href="./">목록</a>
    </div>
  </body>
</html>