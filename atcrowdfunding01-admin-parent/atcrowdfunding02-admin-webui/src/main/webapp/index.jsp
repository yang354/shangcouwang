<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>




<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <!-- http://localhost:8080/atcrowdfunding02-admin-webui/test/ssm.html -->
    <base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort }${pageContext.request.contextPath }/"/>
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="layer/layer.js"></script>

<%--    <%--%>
<%--        pageContext.setAttribute("APP_PATH",request.getContextPath());--%>
<%--    %>--%>
<%--    <!--引入jQuery-->--%>
<%--    <script type="text/javascript" src="${APP_PATH}/jquery/jquery-3.4.1.js"></script>--%>

</head>
<script type="text/javascript">
    $(function(){
        $("#btn1").click(function(){
            $.ajax({
                "url": "send/array/one.json",			// 请求目标资源的地址
                "type": "post",						// 请求方式
                "data": {							// 要发送的请求参数
                    "pn": 1
                },
                "dataType": "json",					// 如何对待服务器端返回的数据
                "success": function(response) {		// 服务器端成功处理请求后调用的回调函数，response是响应体数据
                    console.log(response.data)
                }
            });
        });


        $("#btn2").click(function(){
            var admin =  {							// 要发送的请求参数
                "id":4,
                "userName":"张三"
            }
            var requestBody = JSON.stringify(admin)
            $.ajax({
                "url": "send/array/two.json",			// 请求目标资源的地址
                "type": "post",						// 请求方式
                "data":requestBody,
                "contentType":"application/json;charset=UTF-8",
                "dataType": "text",					// 如何对待服务器端返回的数据
                "success": function(response) {		// 服务器端成功处理请求后调用的回调函数，response是响应体数据
                    alert(response);
                }
            });
        });

        $("#btn3").click(function(){
            //准备好要发送到服务器端的数组
            var array = [5,8,12]
            //将json数组转换成json字符串
            var requestBody = JSON.stringify(array)
            // "['5','8','12']"

            $.ajax({
                "url": "send/array/three.json",			// 请求目标资源的地址
                "type": "post",						// 请求方式
                "data":requestBody,                    //请求体
                "contentType":"application/json;charset=UTF-8",
                "dataType": "json",					// 如何对待服务器端返回的数据
                "success": function(response) {		// 服务器端成功处理请求后调用的回调函数，response是响应体数据
                    console.log(response.message)
                }
            });
        });

        $("#btn5").click(function(){
            layer.msg("layer的弹框")
        })

        $("#btn6").click(function(){


            $.ajax({
                "url": "admin/get/page.json",			// 请求目标资源的地址
                "type": "post",						// 请求方式
                // "data":requestBody,                    //请求体
                "contentType":"application/json;charset=UTF-8",
                "dataType": "json",					// 如何对待服务器端返回的数据
                "success": function(response) {		// 服务器端成功处理请求后调用的回调函数，response是响应体数据
                    console.log(response.data.list[1])
                }
            });
        });


    })
</script>
<body>

<a href="test/ssm.html">测试SSM整合环境</a>

<br/>
<br/>

<button id="btn1">Send [5,8,12] One</button>

<br/>
<br/>

<button id="btn2">Send [5,8,12] Two</button>

<br/>
<br/>

<button id="btn3">Send [5,8,12] Three</button>

<br/>
<br/>

<button id="btn4">Send Compose Object</button>

<br/>
<br/>

<button id="btn5">点我弹框</button>

<button id="btn6">PageInfo</button>

</body>
</html>