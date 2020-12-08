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
	<acme:form-textbox code="buyer.acme-item-request.label.ticker" path="ticker"/>
	<acme:form-moment code="buyer.acme-item-request.label.creation-date" path="creationDate"/>
	<acme:form-integer code="buyer.acme-item-request.label.quantity" path="quantity"/>
	<acme:form-textarea code="buyer.acme-item-request.label.notes" path="notes"/>
	<acme:form-textbox code="buyer.acme-item-request.label.acme-item" path="acmeItem.title"/>
	
  	<acme:form-return code="buyer.acme-item-request.button.return"/>
  	
	
</acme:form>
