
'use strict';

/* Services */

var AppServices = angular.module('wre.services', []).value('ngToastr',toastr);


AppServices.value('version', '0.1');

App.service('objectService', function() {
	  var savedData = null;
	  
	  function set(data) {
	    savedData = data;
	  }
	  function get() {
		  if(savedData!=null){
			    return savedData;
			    }else{
			     return null;R
			    }
	  }

	  return {
	   set: set,
	   get: get
	  };

	 });

App.service('stringService', function() {
	  var savedValue ="";
	  
	  function setValue(data) {
	    savedValue = data;
	  }
	  
	  function getValue() {
	   
	   if(savedValue!=null){
		    return savedValue;
		    }else{
		     return null;
		    }
	  }

	  return {
		  setValue: setValue,
		  getValue: getValue
	  };

	 });

App.service('ngNotifier',function(ngToastr){
    return{
        notify: function(msg){
            ngToastr.success(msg);
        },
        notifyError: function(msg){
            ngToastr.error(msg);
        },
        notifyInfo: function(msg){
            ngToastr.info(msg);
        }
    };
});