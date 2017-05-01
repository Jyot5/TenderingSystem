<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> SubCategory - Add SubCategory </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>SubCategory<span class="divider">/</span></li>
						<li class='active'>Add SubCategory</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Add SubCategory</span>
							</div>
							<div class="box-body box-body-nopadding">
								<c:forEach items="${sessionScope.edit}" var="list1">
								<form action="<%=request.getContextPath()%>/SubCategoryController?id=${list1.subCategory_ID}" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									<div class="control-group">
										<label for="textfield" class="control-label">Select Category</label>
										<div class="controls">
											<select name="Cat_ID" id="Cat_ID" data-rule-required="true">
												<c:forEach items="${sessionScope.edit1}" var="list">
													<c:if test="${list1.categoryVO.category_ID==list.category_ID}">
													<option selected="selected" value="${list.category_ID}" >${list.category_Name}</option>
													</c:if>
													//<c:if test="${list1.categoryVO.category_ID!=list.category_ID}">
													//<option value="${list.category_ID}" >${list.category_Name}</option>
													//</c:if>
												</c:forEach>
												<c:remove var="list" scope="session"/>

											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">SubCategory Name</label>
										<div class="controls">
											<input type="text" name="SubCatName" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2" value="${list1.subCategory_Name}">
										</div>
									</div>
									<div class="control-group">
										<label for="emailfield" class="control-label">Description</label>
										<div class="controls">
											<textarea name="SubCatDesc" id="textarea" class="input-block-level" data-rule-required="true" data-rule-minlength="10">${list1.subCategory_Description}</textarea>
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="update">
								</form>
								</c:forEach>
								<c:remove var="list1" scope="session"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>

</html>