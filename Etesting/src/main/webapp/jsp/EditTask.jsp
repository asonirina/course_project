<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script type="text/javascript" src="/js/validator.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="/js/validate.min.js" type="text/javascript"></script>
    <script src="/js/init.js" type="text/javascript"></script>
    <script src="/js/dynamic_list_helper.js" type="text/javascript"></script>

</head>
<body>

<c:if test="${not empty errors}">
    <div id="output" class="errorblock">
        <c:forEach var="errors" items="${errors}">
            <c:out value="${errors}"/><br>
        </c:forEach>
    </div>
</c:if>
<div class="wrapper">
    <form:form method="post" id="taskForm" class="blocks" action="/e-Testing/SaveTask.html" commandName="task"
               modelAttribute="task">

        <c:if test="${not empty task.id}">
            <input type="hidden" id="id" name="id"
                   value="${task.id}"/>
        </c:if>

        <p>
            <form:label path="programName">Название</form:label>
            <form:input path="programName" value="${task.programName}"
                        class="text" name="programName"/>
        </p>

        <p>
            <form:label path="form">Класс</form:label>
            <form:input path="form" value="${task.form}"
                        class="text" name="form"/>
        </p>


        <p>
            <form:label path="description">Описание</form:label>
            <form:textarea path="description" value="${task.description}"
                           class="text" name="description"/>
        </p>

        <p>
        <table>
            <thead>
            <tr>
                <th>In</th>
                <th>Out</th>
                <th></th>
            </tr>
            </thead>
            <tbody id='task'>
            <c:forEach var="test" items="${task.tests}" varStatus="status">
                <tr class="single-test">

                    <form:hidden path="tests[${status.index}].id" value="${test.id}" name="test${test.id}"/>
                    <form:hidden path="tests[${status.index}].testNum" value="${test.testNum}"
                                 name="num${test.testNum}"/>


                    <td><form:textarea path="tests[${status.index}].dataInStr" value="${test.dataInStr}" class="text"
                                    name="dataIn${test.id}"/></td>


                    <td><form:textarea path="tests[${status.index}].dataOutStr" value="${test.dataOutStr}" class="text"
                                    name="dataOut${test.id}"/></td>

                    <td><a href="#" class="button removeSingleTest">Remove</a></td>

                </tr>

            </c:forEach>

            <c:if test="${task.tests.size() == 0}">
                <tr class="single-test defaultRow">
                    <hidden name="tests[].id" value=""/>
                    <hidden name="tests[].testNum" value=""/>
                    <td><textarea type="text" name="tests[].dataInStr" value=""/></td>
                    <td><textarea type="text" name="tests[].dataOutStr" value=""/></td>

                    <td><a href="#" class="removeSingleTest">Remove Test</a></td>
                </tr>
            </c:if>

            </tbody>
        </table>

        </p>

        <p>
            <a class="button" href="#" id="addSingleTest">+++</a>
        </p>


        <br/>

        <div style="text-align: center">
            <input type="submit" class="button" value="Сохранить"/>

            <a href="<c:url value="/e-Testing/TaskList.html"/>"><input type="button"
                                                                       value="Отмена"
                                                                       name="canceled" class="button"/></a>
        </div>


    </form:form>

    <script type="text/javascript">
        function rowAdded(rowElement) {
            $(rowElement).find("textarea").val('');
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

        function beforeSubmit() {
            alert('submitting....');
            return true;
        }

        $(document).ready(function () {
            var config = {
                rowClass:'single-test',
                addRowId:'addSingleTest',
                removeRowClass:'removeSingleTest',
                formId:'taskForm',
                rowContainerId:'task',
                indexedPropertyName:'tests',
                indexedPropertyMemberNames:'id, testNum, dataInStr, dataOutStr',
                rowAddedListener:rowAdded,
                rowRemovedListener:rowRemoved,
                beforeSubmit:beforeSubmit
            };
            new DynamicListHelper(config);
        });
    </script>

</div>
</body>
</html>