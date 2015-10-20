<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script src="/js/dynamic_list_helper.js" type="text/javascript"></script>
</head>
<body>

<c:if test="${not empty errors}">
    <div class="alert alert-danger fade in">
        <a class="close" data-dismiss="alert">×</a>
        <c:forEach var="err" items="${errors}">
            <c:out value="${err}"/><br>
        </c:forEach>
    </div>
</c:if>

<div class="wrapper">
    <form:form method="post" id="form" class="blocks" action="/e-Testing/admin/SaveTask.html" commandName="task"
               role="form"
               modelAttribute="task">

        <c:if test="${not empty task.id}">
            <input type="hidden" id="id" name="id"
                   value="${task.id}"/>
        </c:if>

        <div class="form-group">
            <form:label path="programName">Название</form:label>
            <form:input path="programName" value="${task.programName}"
                        class="form-control" name="programName"/>
        </div>

        <div class="form-group">
            <form:label path="form">Класс</form:label>
            <form:input path="form" value="${task.form}"
                        class="form-control" name="form"/>
        </div>

        <div class="form-group">
            <form:label path="description">Описание</form:label>
            <form:textarea path="description" value="${task.description}"
                           class="form-control" name="description"/>
        </div>

        <p>
        <table class="table">
            <thead>
            <tr>
                <th width="220">In</th>
                <th width="220">Out</th>
                <th></th>
            </tr>
            </thead>
            <tbody id='task'>
            <c:forEach var="test" items="${task.tests}" varStatus="status">
                <tr class="single-test">
                    <form:hidden path="tests[${status.index}].id" value="${test.id}" name="test${test.id}"/>
                    <form:hidden path="tests[${status.index}].testNum" value="${test.testNum}"
                                 name="num${test.testNum}"/>
                    <td><form:textarea path="tests[${status.index}].dataInStr" value="${test.dataInStr}"
                                       class="form-control"
                                       name="dataIn${test.id}"/></td>
                    <td><form:textarea path="tests[${status.index}].dataOutStr" value="${test.dataOutStr}"
                                       class="form-control"
                                       name="dataOut${test.id}"/></td>
                    <td><a href="#" class="btn removeSingleTest">Remove</a></td>
                </tr>

            </c:forEach>

            <c:if test="${task.tests.size() == 0}">
                <tr class="single-test defaultRow">
                    <input type="hidden" name="tests[].id" value=""/>
                    <input type="hidden" name="tests[].testNum" value="0"/>

                    <td><textarea rows="1" cols="30" class="form-control" name="tests[].dataInStr"></textarea></td>
                    <td><textarea rows="1" cols="30" class="form-control" name="tests[].dataOutStr"></textarea></td>

                    <td><a href="#" class="btn removeSingleTest">Remove</a></td>
                </tr>
            </c:if>

            </tbody>
        </table>

        <p>
            <a class="btn" href="#" id="addSingleTest">+++</a>
        </p>
        <br/>

        <div style="text-align: right">
            <input type="submit" class="btn btn-default" value="Сохранить"/>
            <a class="btn" href="<c:url value="/e-Testing/admin/TaskList.html"/>">Отмена</a>
        </div>

    </form:form>

    <script type="text/javascript">
        function rowAdded(rowElement) {
            $(rowElement).find("textarea").val('');
            $(rowElement).find(".DynamicListHelper_id").val('');
            var value = parseInt($(rowElement).find(".DynamicListHelper_testNum").val()) + 1;
            $(rowElement).find(".DynamicListHelper_testNum").val(value);

            saveNeeded();
        }
        function rowRemoved(rowElement) {
            saveNeeded();
            alert("Removed Row HTML:\n" + $(rowElement).html());
        }

        function saveNeeded() {
            $('#submit').css('color', 'red');
            $('#submit').css('font-weight', 'bold');
            if ($('#submit').val().indexOf('!') != 0) {
                $('#submit').val('!' + $('#submit').val());
            }
        }

        $(document).ready(function () {
            var config = {
                rowClass:'single-test',
                addRowId:'addSingleTest',
                removeRowClass:'removeSingleTest',
                formId:'form',
                rowContainerId:'task',
                indexedPropertyName:'tests',
                indexedPropertyMemberNames:'id, testNum, dataInStr, dataOutStr',
                rowAddedListener:rowAdded,
                rowRemovedListener:rowRemoved
            };
            new DynamicListHelper(config);
        });
    </script>

</div>
</body>
</html>