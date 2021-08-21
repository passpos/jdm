<%-- 
    Document   : login
    Created on : 2021年7月1日, 上午4:13:00
    Author     : passpos <paiap@outlook.com>
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>登录</title>
        <link rel="stylesheet" href="http://localhost:9999/styles/global.css"/>
        <link rel="stylesheet" href="http://localhost:9999/styles/passage.css"/>
    </head>
    <body>
        <div class="passage" >
            <h1>Hello World!</h1>
            <form action="/login" method="POST">
                姓名：<input type="text" name="name"/>
                年龄：<input type="text" name="age"/>
                <input type="submit" name="submit" value="登录"/>
            </form>
        </div>
    </body>
</html>
