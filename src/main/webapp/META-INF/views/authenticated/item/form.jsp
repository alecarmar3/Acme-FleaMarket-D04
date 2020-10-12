<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="authenticated.item.label.ticker" path="ticker"/>
	<acme:form-moment code="authenticated.item.label.creation-date" path="creationDate"/>
	<acme:form-textbox code="authenticated.item.label.title" path="title"/>
	<acme:form-textbox code="authenticated.item.label.category" path="category"/>
	<acme:form-textarea code="authenticated.item.label.description" path="description"/>
	<acme:form-money code="authenticated.item.label.price" path="price"/>
	<acme:form-url code="authenticated.item.label.photo" path="photo"/>
	<acme:form-textbox code="authenticated.item.label.additional-information" path="additionalInformation"/>
	
  	<acme:form-return code="authenticated.item.button.return"/>
  	
	
</acme:form>
