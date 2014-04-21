<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Entries</title>
    </head>
    <body>
        <h1>BiBTex web-terminal</h1>
        
        <div>
            <c:forEach var="message" items="${messages}">
                <p>${message}</p>
            </c:forEach>
                
            <form action="${pageContext.request.contextPath}/app/read" method="POST">
                <input type="submit" value=">" />
                <input type="text" name="message" id="message" />
            </form>
        </div>
    </body>
</html>
