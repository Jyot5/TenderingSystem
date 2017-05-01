<!doctype html>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<head>
<script type="text/javascript" 	src="<%=request.getContextPath()%>/Admin/js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	
     
    	$(".Cat_ID").change(function(event) {  
    		 
    		 alert("hii");
    		 
        var $cat=$("select.Cat_ID").val();
        var $mode="dropDown";
           
        $.get('<%=request.getContextPath()%>/TenderController',{catID:$cat,mode:$mode},function(responseJson) {   
        	   
        	   var $select = $(".SubCat_ID");
        	  alert(responseJson);
             
        	   $select.find('option').remove();                          
             
               $.each(responseJson, function(key, value) {      
            	   
            	   $('<option>').val(key).text(value).appendTo($select);      
                    });
            
           
        });
        });
    	
    	});
</script>

</head>
<html>
<body>
<jsp:include  page="menu.jsp" />
	<div id="main">
		<div id="content">
			<div class="page-header">
				<div class="pull-left">
					<h4><i class="icon-file-alt"></i> Tender - Add Tender </h4>
				</div>
				<div class="pull-right">
					<ul class="bread">
						<li><a href="dashboard.jsp">Home</a><span class="divider">/</span></li>
						<li>Tender<span class="divider">/</span></li>
						<li class='active'>Add Tender</li>
					</ul>
				</div>
			</div>
			
			<div class="container-fluid" id="content-area">
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-head">
								<i class="icon-list-ul"></i>
								<span>Add Tender</span>
							</div>
							<div class="box-body box-body-nopadding">
								
								<form action="<%=request.getContextPath()%>/TenderController" method="POST" class='form-horizontal form-bordered form-validate' id="bb">
									<div class="control-group">
										<label for="textfield" class="control-label">Select Category</label>
										<div class="controls">
											<select name="CatID" id="Cat_ID" data-rule-required="true" class="Cat_ID">
												<c:forEach items="${sessionScope.Cat_list}" var="list">
												<option value="${list.category_ID}">${list.category_Name}</option>
												</c:forEach>

											</select>

										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Select SubCategory</label>
										<div class="controls">
											<select name="SubCat_ID" id="SubCat_ID" data-rule-required="true" class="SubCat_ID">
												<option value="0">Select Subcategory</option>

											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="textfield" class="control-label">Tender Name</label>
										<div class="controls">
											<input type="text" name="tender_Name" id="textfield" class="input-xlarge" data-rule-required="true" data-rule-minlength="2">
										</div>
									</div>
									<div class="control-group">
										<label for="emailfield" class="control-label">Tender Description</label>
										<div class="controls">
											<textarea name="tender_Description" id="textarea" class="input-block-level" data-rule-required="true" data-rule-minlength="10"></textarea>
										</div>
									</div>
									
									<div class="form-actions">
										<input type="submit" class="button button-basic-blue" value="Submit">
										<button type="button" class="button button-basic">Cancel</button>
									</div>
									<input type="hidden" name="flag" value="insert">
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</body>

</html>