<%@page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>分类列表</title>
        <link rel="stylesheet" href="../../css/index.css">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
    </head>

    <body>
       <header>
            <div class="container">
                <c:forEach items="${categories}" var="category" varStatus="status">
                    <nav>
                        <a href="/management?category=${category.id}">${category.name}</a>
                    </nav>
                </c:forEach>
                    <nav>
                        <a href="/management?target=book">图书</a>
                    </nav>
               
            </div>
        </header>
        <section class="banner">
            <div class="container">
                <div>
                    <h1>图书</h1>
                    <p>图书分类列表</p>
                </div>
            </div>
        </section>
        <section class="main">
            <div class="container">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>名称</th>
                        <th>创建时间</th>
                        <th>最后修改时间</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${categories}" var="category">
                            <tr>
                                <td>${category.name}</td>
                                <td>${category.createTime}</td>
                                <td>${category.updateTime}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </section>
        <section class="page">
            <div class="container">
                <div id="fatie">
                    <a href="/page/add_category"><button>新建</button></a>
                </div>
            </div>
        </section>
        <footer>
            copy@慕课网
        </footer>
    </body>
</html>