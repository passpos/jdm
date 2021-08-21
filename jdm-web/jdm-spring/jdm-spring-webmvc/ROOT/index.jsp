<%-- 
    Document   : index
    Created on : 2021年3月4日, 上午1:40:50
    Author     : passpos <paiap@outlook.com>
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>SpringMVC</title>
        <link rel="stylesheet" href="http://localhost:9999/styles/global.css"/>
        <link rel="stylesheet" href="http://localhost:9999/styles/passage.css"/>
        <script src="http://localhost:9999/scripts/jquery-3.6.0/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#json04").click(function () {
                    $.ajax({
                        type: 'POST',
                        url: "json04",
                        data: {
                            name: "老王",
                            age: 55
                        },
                        dataType: 'json',
                        success: function (data) {
                            console.log(data);
                        }
                    });
                });
                $("#json07").click(function () {
                    $.ajax({
                        type: 'POST',
                        url: "json07",
                        // 必须是标准格式的字符串
                        data: '{"name":"老王","age":55}',
                        dataType: 'json',
                        // 必须设置为服务器接受的json内容类型
                        contentType: 'application/json;charset=utf-8',
                        success: function (data) {
                            console.log(data);
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="passage" >
            <h1>wab02</h1>
            <p></p>
            <table class="dataintable" >
                <tr>
                    <th>请求方式</th>
                    <th>地址</th>
                    <th>注释</th>
                </tr>
                <tr>
                    <td>ANY</td>
                    <td><a href="/api/first" target="_blank">first</a></td>
                    <td></td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/api/method" target="_blank">method</a></td>
                    <td>方法映射</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/params01?name=老王&age=55" target="_blank">参数映射01</a></td>
                    <td>参数映射</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/params02" target="_blank">参数映射02</a></td>
                    <td>具有默认值的参数</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/params03?nick=老王&age=55" target="_blank">参数映射03</a></td>
                    <td>为参数设置别名</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/params04?id=1&name=老王&age=55" target="_blank">参数映射04</a></td>
                    <td>接收Bean类型路由参数</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect01" target="_blank">重定向01</a></td>
                    <td>重定向到页面（返回ModelAndView）</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect02" target="_blank">重定向02</a></td>
                    <td>重定向到页面（直接返回视图名称字符串）</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect03" target="_blank">重定向03</a></td>
                    <td>重定向到路由（以及对应的控制器方法，返回ModelAndView）</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect04" target="_blank">重定向04</a></td>
                    <td>重定向到路由（以及对应的控制器方法，返回视图名称字符串）</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect05" target="_blank">重定向05</a></td>
                    <td>重定向到页面，并传递参数</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/redirect06" target="_blank">重定向06</a></td>
                    <td>重重定向到页面，并传递中文参数</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/forward01" target="_blank">请求转发01</a></td>
                    <td>请求转发，返回ModelAndView</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/forward02" target="_blank">请求转发02</a></td>
                    <td>请求转发，返回路径字符串</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/forward03" target="_blank">请求转发03</a></td>
                    <td>不使用“forward:”</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/forward04" target="_blank">请求转发04</a></td>
                    <td>设置参数</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/request01" target="_blank">请求域01</a></td>
                    <td>请求域</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/request02" target="_blank">请求域02</a></td>
                    <td>请求域</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/request03" target="_blank">请求域03</a></td>
                    <td>请求域</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/request04" target="_blank">请求域04</a></td>
                    <td>请求域</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/request05" target="_blank">请求域05</a></td>
                    <td>请求域</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/json01" target="_blank">Json01</a></td>
                    <td>不加@ResponseBody注解，同时无视图时的表现。<br />
                        将会返回文件[/WEB-INF/jsp/json01.jsp] 未找到。</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/json02" target="_blank">Json02</a></td>
                    <td>加@ResponseBody注解后，返回对象</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/json03" target="_blank">Json03</a></td>
                    <td>返回List集合</td>
                </tr>
                <tr>
                    <td>POST</td>
                    <td><button id="json04">Json04</button></td>
                    <td>AJAX，返回Bean</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="json05" target="_blank">Json05</a></td>
                    <td>返回字符串</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="json06" target="_blank">Json06</a></td>
                    <td>不使用@RequestBody，要求提交数据但不提交</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="json07?name=老王&age=55" target="_blank">Json07-1</a></td>
                    <td>形参前的 @RequestBody，要求提交json字符串</td>
                </tr>
                <tr>
                    <td>POST</td>
                    <td><button id="json07">Json07-2</button></td>
                    <td>形参前的 @RequestBody，要求提交json字符串</td>
                </tr>
                <tr>
                    <td>GET</td>
                    <td><a href="/login" target="_blank">登录</a></td>
                    <td></td>
                </tr>
                    <td>GET</td>
                    <td><a href="/upload" target="_blank">上传</a></td>
                    <td>要求登录</td>
                </tr>
                </tr>
                    <td>GET</td>
                    <td><a href="/excep01" target="_blank">异常处理01</a></td>
                    <td>异常处理</td>
                </tr>
                </tr>
                    <td>GET</td>
                    <td><a href="/excep02" target="_blank">异常处理02</a></td>
                    <td>异常处理</td>
                </tr>
                </tr>
                    <td>GET</td>
                    <td><a href="/excep03" target="_blank">异常处理03</a></td>
                    <td>异常处理</td>
                </tr>
            </table>
        </div>
    </body>
</html>
