<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BibTeX web-terminal</title>
    <style type="text/css" rel="stylesheet">
      body {
        background:black;
        color:#DDD;
        font-family:Consolas, Monospace;
        font-size:0.9em;
      }
      input {
        background:black;
        border:0;
        color:#DDD;
      }
    </style>
    <script type="text/javascript">
      function setFocus()
      {
        document.getElementById("message").focus();
      }
     </script>
  </head>
  <body onload="setFocus()">

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