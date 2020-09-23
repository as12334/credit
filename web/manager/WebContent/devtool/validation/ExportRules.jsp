<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/include/include.inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${validateRules.formName}</title>
</head>

<body>
    <c:forEach items="${validateRules.properties}" var="property">
        <h3>${property.propertyName}</h3>
        <table border="1">
            <tr>
                <th>验证规则</th>
                <th>错误提示信息</th>
                <th>给开发人员的提示（测试请自觉忽略）</th>
            </tr>
            <c:forEach items="${property.rules}" var="rule">
                <tr>
                    <td>${rule.rule}</td>
                    <c:if test="${rule.errMsg.indexOf('{')>=0}">
                        <td>${messages.common[rule.errMsg]}</td>
                        <td></td>
                    </c:if>
                    <c:if test="${rule.errMsg.indexOf('{')<0 && rule.errMsg.indexOf('.')>0}">
                        <td>${messages[rule.errMsg.substring(0,rule.errMsg.indexOf("."))][rule.errMsg.substring(rule.errMsg.indexOf(".")+1,rule.errMsg.length())]}</td>
                        <td></td>
                    </c:if>
                    <c:if test="${rule.errMsg.indexOf('{')<0 && rule.errMsg.indexOf('.')<0}">
                        <td>${rule.errMsg}</td>
                        <td><font color="red">请开发人员勿直接使用中文，请使用国际化的key</font></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:forEach>
</body>
</html>
