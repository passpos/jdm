<%-- 
    Document   : upload
    Created on : 2021年7月1日, 上午4:43:35
    Author     : passpos <paiap@outlook.com>
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>上传</title>
        <link rel="stylesheet" href="http://localhost:9999/styles/global.css"/>
        <link rel="stylesheet" href="http://localhost:9999/styles/passage.css"/>
    </head>
    <body>
        <div class="passage" >
            <h1>你好啊，${name}</h1>
            <form action="/upload01" method="POST" enctype="multipart/form-data">
            <input type="file" name="file"/>
            <input type="submit" name="submit" value="上传文本"/>
            </form>
            <form action="/upload02" method="post" enctype="multipart/form-data">
                <input type="file" name="file"/>
                <input type="submit" value="上传图片"/>
            </form>
            <form action="/upload03" method="post" enctype="multipart/form-data">
                <input type="file" name="files"/>
                <input type="file" name="files"/>
                <input type="file" name="files"/>
                <input type="submit" value="上传图片"/>
            </form>
        </div>
    </body>
</html>
