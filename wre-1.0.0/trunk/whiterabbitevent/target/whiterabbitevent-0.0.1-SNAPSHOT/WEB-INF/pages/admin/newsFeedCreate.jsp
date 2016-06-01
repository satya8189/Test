
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<toaster-container></toaster-container>
<jsp:include page="error-messages.jsp"></jsp:include> 
<c:set var="userId" value="${USER.userId}" scope="session" />

<form name="createEvent" ng-submit="createEvent.$valid && saveNews(news)" novalidate>

<div class="col-md-12">
	<a ng-click="navigateToNewsFeedView(news.eventId)">
		 <i class="glyphicon glyphicon-chevron-left"></i>
	</a>
	
<div class="panel">
 <div class="panel-heading text-center font-size-20 padding-15">Create News</div>
  <div class="panel-body text-center">
  
    <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">News Feed Name <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="eventName" placeholder="NewsFeed Name"  ng-model="news.newsTitle" 
      name="eventName"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.eventName.$error" ng-messages-include="errors">
		  </span>
      </div>
      </div>
	 </div>
	 
	 
	  <div class="row">
	<div class="col-md-12">
	  <div class="form-group col-md-6" >
          <label class="flot-left">NewsDesc <span style="color:red;">*</span></label>
      <input type="text" class="input-text form-control" id="newsDesc" placeholder="NewsDesc"  ng-model="news.newsDesc" 
      name="NewsDesc"   required>
      <span ng-if="createEvent.$submitted" ng-messages="createEvent.NewsDesc.$error" ng-messages-include="errors">
		  </span>
      </div>
      </div>
	 </div>

</div>
    <div>&nbsp;</div>
<input type="submit" value="Save" class="btn button save margin-2" ng-click="submitted=true"/>
</div>
</div>

</form>
