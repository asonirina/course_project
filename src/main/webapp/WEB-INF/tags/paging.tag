<%@ tag import="org.springframework.util.StringUtils" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ attribute name="paging1" required="true"
              type="by.bsu.project.paging.Paging" %>
<%@ attribute name="pagedLink" required="true" type="java.lang.String" %>

<link rel="stylesheet" type="text/css" href="/css/pagination.css">

<c:if test="${paging1.pageCount > 1}">

    <span class="pagingButton">
            <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(0))%>">First page</a>
		</span>

    <c:if test="${!paging1.firstPage}">
		<span class="pagingButton">
            <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(paging1.getPage() - 1))%>">Prev</a>
		</span>
    </c:if>

    <%--First page paging1--%>
    <c:if test="${paging1.page == paging1.firstLinkedPage}">
        <c:if test="${paging1.pageSize == 1}">
            <c:forEach begin="${paging1.page}"
                       end="${paging1.page + 1}" var="i">
                <c:choose>
                    <c:when test="${paging1.page == i}">
                        <span class="pagingItemCurrent">${i+1}</span>
                    </c:when>
                    <c:otherwise>
				<span class="pagingItem">
                    <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
				</span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
        <c:if test="${paging1.pageSize > 1}">
            <c:forEach begin="${paging1.page}"
                       end="${paging1.page + 2}" var="i">
                <c:choose>
                    <c:when test="${paging1.page == i}">
                        <span class="pagingItemCurrent">${i+1}</span>
                    </c:when>
                    <c:otherwise>
				<span class="pagingItem">
                    <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
				</span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
    </c:if>

    <%--Other pages paging1 (not first and not last)--%>
    <c:if test="${paging1.page < paging1.lastLinkedPage and paging1.page > paging1.firstLinkedPage}">
        <c:forEach begin="${paging1.page - 1}"
                   end="${paging1.page + 1}" var="i">
            <c:choose>
                <c:when test="${paging1.page == i}">
                    <span class="pagingItemCurrent">${i+1}</span>
                </c:when>
                <c:otherwise>
				<span class="pagingItem">
                    <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
				</span>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </c:if>

    <%--Last page pging--%>
    <c:if test="${paging1.page == paging1.lastLinkedPage}">
        <c:if test="${paging1.pageSize == 1}">
            <c:forEach begin="${paging1.page - 1}"
                       end="${paging1.page }" var="i">
                <c:choose>
                    <c:when test="${paging1.page == i}">
                        <span class="pagingItemCurrent">${i+1}</span>
                    </c:when>
                    <c:otherwise>
				<span class="pagingItem">
                    <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
				</span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
        <c:if test="${paging1.pageSize > 1}">
            <c:forEach begin="${paging1.page - 2}"
                       end="${paging1.page }" var="i">
                <c:choose>
                    <c:when test="${paging1.page == i}">
                        <span class="pagingItemCurrent">${i+1}</span>
                    </c:when>
                    <c:otherwise>
				<span class="pagingItem">
                    <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(jspContext.getAttribute("i")))%>">${i+1}</a>
				</span>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:if>
    </c:if>


    <c:if test="${!paging1.lastPage}">
		<span class="pagingButton">
            <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(paging1.getPage() + 1))%>">Next</a>
		</span>
    </c:if>

     <span class="pagingButton">
            <a href="<%=StringUtils.replace(pagedLink, "~", String.valueOf(paging1.getPageCount()-1))%>">Last page</a>
		</span>

</c:if>