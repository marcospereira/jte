<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%@ attribute name="greeting" required="true" type="java.lang.String" %>
<%@ attribute name="name" required="true" type="java.lang.String" %>

<h2>${greeting}
<c:if test="${not empty name}">
    , ${name}
</c:if>
!</h2>