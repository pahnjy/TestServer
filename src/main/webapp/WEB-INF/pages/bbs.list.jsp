<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>스프링프레임워크</title>
  </head>
  <body>
  <h1>${message}</h1>
  <table border="1">
      <colgroup>
    <col width="60"><col><col width="115"><col width="85">
    </colgroup>
    <thead>
      <tr>
          <th scope="col">아이디</th>
          <th scope="col">비밀번호</th>
          <th scope="col">성별</th>
          <th scope="col">닉네임</th>
          <th scope="col">이메일</th>
      </tr>
      </thead>

      <tbody>
      <!-- 목록이 반복될 영역 -->
      <c:forEach var="item" items="${list}" varStatus="status">
      <tr>
          <td><a href="./${item.id}">${item.uid}</a></td>
          <td>${item.password}</td>
          <td>${item.sex}</td>
          <td>${item.name}</td>
          <td>${item.email}</td>
      </tr>
      </c:forEach>

      </tbody>

  </table>
  <div><a href="./write">쓰기</a></div>
  </body>
</html>