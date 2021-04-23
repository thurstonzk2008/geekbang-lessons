<%--
  Created by IntelliJ IDEA.
  User: zhk
  Date: 2021/4/22
  Time: 7:30 下午
  To change this template use File | Settings | File Templates.
--%>
<head>
    <jsp:directive.include
            file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
    <title>My Home Page</title>
</head>
<body>
<div class="container-lg">
    <h2>Welcome ${name}!</h2>
    <img src="${avatar_url}">
    <p>
        If you see this page,it means that you have login with GitHub successfully. Congratulations to you!
    </p>
</div>
</body>
