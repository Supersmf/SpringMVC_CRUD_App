<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employees List</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #61cbcc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #61cbcc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #61cbcc;
            color: #333;
            background-color: #f0f0f0;
        }


    </style>
</head>
<body>
<h1 >Employee List</h1>


    <table class="tg">
        <tr>

            <th width="120"><a href="<c:url value='/sort/name'/>">Name</a></th>
            <th width="120"><a href="<c:url value='/sort/surname'/>">Surname</a></th>
            <th width="120"><a href="<c:url value='/sort/position'/>">Position</a></th>
            <th width="120"><a href="<c:url value='/sort/department'/>">Department</a></th>
            <th width="80">Action</th>

        </tr>
        <c:forEach items="${listEmployees}" var="employee">
            <tr>

                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.position}</td>
                <td>${employee.department}</td>
                <td><a href="<c:url value='/edit/${employee.id}'/>">Edit</a> |
                    <a href="<c:url value='/remove/${employee.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>



<h1>Add a Employee</h1>



<c:url var="addAction" value="/employees/add"/>

<form:form action="${addAction}" commandName="employee">
    <table>
                    <form:hidden path="id"/>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="surname">
                    <spring:message text="Surname"/>
                </form:label>
            </td>
            <td>
                <form:input path="surname"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="position">
                    <spring:message text="Position"/>
                </form:label>
            </td>
            <td>
                <form:input path="position"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="department">
                    <spring:message text="Department"/>
                </form:label>
            </td>
            <td>
                <form:input path="department"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Employee"/>"/>
                </c:if>
                <c:if test="${empty employee.name}">
                    <input type="submit"
                           value="<spring:message text="Add Employee"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
