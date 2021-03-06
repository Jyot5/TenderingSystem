<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Category - Edit Category </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Category<span class="divider">/</span></li>
						<li class='active'>Add Category</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Edit Category</span>
							</div>
							<div class="box-body box-body-nopadding">
								<c:forEach items="${sessionScope.edit}" var="list">
								<form action="<%=request.getContextPath()%>/CategoryController?id=${list.category_ID}" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									
									<div class="control-group">
										<label for="textfield" class="control-label">Category Name</label>
										<div class="controls">
										
												
												
											<input type="text" name="CatName" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2" value="${list.category_Name}">
											
										</div>
									</div>
									<div class="control-group">
										<label for="emailfield" class="control-label">Description</label>
										<div class="controls">
											<textarea name="CatDesc" id="textarea" class="input-block-level" data-rule-required="true" data-rule-minlength="10" >${list.category_Description}</textarea>
										
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="update"/>
									
								</form>
								</c:forEach>
								<c:remove var="list" scope="session"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>

</html>