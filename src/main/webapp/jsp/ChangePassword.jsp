<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
</head>
<body>
<form method="post">
    <table>
        <tr>
    <td><label>Старый пароль</label></td>
            <td> <input name="oldPassword" type="password"> </td>
        </tr>
    <tr>
        <td> <label>Новый пароль</label></td>
        <td><input name="password1" type="password">   </td>
    <tr/>
        <tr>
            <td> <label>Повторите новый пароль</label> </td>
            <td><input name="password2" type="password"> </td>
    <tr/>
    </table>
    <input type="submit" class="button" value="Изменить"/>
</form>


</body>