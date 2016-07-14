
<style>

div .newdashboard{
  position: relative;
  display: inline-block;

  border:1px solid rgba(204, 204, 204, 0.43);
  color: #0098CD;
  font-size: 18px;
  background-image: linear-gradient(#fff, #fff);
  background-repeat: no-repeat;
  transition: background-size .5s, color .5s;
  border-left-color:#0098CD;
  border-left-width:5px;
     margin: 5px;
    width: 200px;
    text-align: center;
    padding: 20px 0px;
    box-shadow: 0 2px 4px 0 rgba(0,0,0,0.16),0 2px 10px 0 rgba(0,0,0,0.12)!important;
}
.center-right-left, .center-top-bottom, .center-corner {
  background-position: 50% 50%;
}
.to-left {
  background-position: 100% 50%;
}
.to-right {
  background-position: 0% 50%;
}
.to-top {
  background-position: 50% 100%;
}
.to-bottom {
  background-position: 50% 0%;
}
.center-right-left, .to-left, .to-right {
  background-size: 0% 100%;
}
.center-top-bottom, .to-top, .to-bottom {
  background-size: 100% 0%;
}
.center-corner {
  background-size: 0% 0%;
}

 div .newdashboard:hover {
  background-size: 100% 100%;
  color: #fff;
  background-image: linear-gradient(#0098CD, #0098CD);
    border-color:#0098CD;
}
@media (min-width: 992px){
.col-md-2 {
    width: 20%;
}}
.panel-body {
    background: #fff;
}
 </style>

</head>
<body>
<div class="container margin-top-5">
	
	
	
	
	
	
	<div ng-repeat="service in serviceList">
	<div class="col-md-2 ">
	<a ng-click="serviceDetails(service)">
	<div class="to-right newdashboard" 	><span class="to-right ">{{service.serviceName}}</span></div></a>
	</div>

	</div>
</div>		
</body>
</html>