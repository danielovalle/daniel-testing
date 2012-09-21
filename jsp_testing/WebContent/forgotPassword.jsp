<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<%
	String stepClass1 = "selected";
	String stepClass2 = "unselected";
	String stepClass3 = "unselected";
	String dividerClass1 = "";
	String dividerClass2 = "";
	String errorStr = "";

	Integer step = (request.getParameter("step") instanceof String) ? Integer.parseInt(request.getParameter("step")) : 1;
	request.setAttribute("step", step);

	if (step > 1) {
		stepClass1 = "completed";
		stepClass2 = "selected";
		stepClass3 = "unselected";
		dividerClass1 = "selected";
	}

	if (step > 2) {
		dividerClass1 = "completed";
		dividerClass2 = "selected";
		stepClass1 = "completed";
		stepClass2 = "completed";
		stepClass3 = "selected";
	}
%>

<c:if test="${requestScope.step == 1}">
ok
</c:if>

<c:if test="${requestScope.step == 2}">
ok - 2
</c:if>

<div id="mainContent">
	<div class="clearfix step-title stepTitle">
		<div class="step step-1 <%=stepClass1%>">
			<span class="number"></span><span class="txt">Enter User Name</span>
		</div>
		<div class="divider <%=dividerClass1%>"></div>
		<div class="step step-2 <%=stepClass2%>">
			<span class="number"></span><span class="txt">Secret Question</span>
		</div>
		<div class="divider <%=dividerClass2%>"></div>
		<div class="step step-3 <%=stepClass3%>">
			<span class="number"></span><span class="txt">Create Password</span>
		</div>
	</div>


	<div class="clearfix gradient bg-wrapper">
		<div class="bg-diag pad-all">
			<div class="error-msg hidden">
				<p><%=errorStr%></p>
			</div>

			<c:if test="${param.step == 1}">

				<form id="forgotPassword" method="post"
					action="/service/user/forgotPassword?step=1" class="validate ajax">

					<fieldset class="step-1">
						<p>Enter your User Name for your SYNC account (usually your
							email address).</p>
						<hr>
						<label for="username" class="lbl-input">User Name*</label> <input
							type="email" required class="input" name="username" id="username">

						<input type="submit" class="btn submitForm" value="Next">
					</fieldset>
				</form>

			</c:if>
			<c:if test="${param.step == 2}">

				<form id="forgotPassword" method="post"
					action="/service/user/forgotPassword?step=2" class="validate ajax">
					<fieldset class="step step-2 ">
						<p>Please answer your secret question to verify your identity.</p>
						<hr>

						<p>
							Question:
							<%=session.getAttribute("userSecQuestion")%></p>
						<label for="answer" class="lbl-input">Answer*</label> <input
							type="text" required class="input" name="answer" id="answer">
						<input type="submit" class="btn submitForm" value="Next">

						<div class="center pad-bottom">
							<a href="/forgotsecret">I forgot my secret answer, email me a tempory password.</a>
						</div>
					</fieldset>
				</form>

			</c:if>
			<c:if test="${param.step == 3}">

				<form id="forgotPassword" method="post"
					action="/service/user/forgotPassword?step=3" class="validate ajax">

					<fieldset class="step step-3 ">
						<p>Enter a password and confirm.</p>
						<hr>
						<label for="password" class="lbl-input">Password*</label> <input
							type="password" required class="input" name="password"
							placeholder="" id="password"> <label for="verifyPass"
							class="lbl-input">Verify Password*</label> <input type="password"
							required class="{required:true,equalTo:'#password'} input"
							name="verifyPass" placeholder="" id="verifyPass"> <input
							type="submit" class="btn submitForm" value="Next">

					</fieldset>
				</form>

			</c:if>
		</div>
	</div>
</div>
</body>
</html>