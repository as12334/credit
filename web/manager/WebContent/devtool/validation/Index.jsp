<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>

<body>
    <ol>
        <c:forEach items="${formList}" var="form" varStatus="s">
            <li><a href="${root}/validation/export.html?index=${s.index}" target="_blank">${form}</a></li>
        </c:forEach>
    </ol>
</body>
</html>
