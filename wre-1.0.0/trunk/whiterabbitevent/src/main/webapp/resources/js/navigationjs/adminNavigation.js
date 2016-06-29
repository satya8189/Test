'use strict';

var whiterabbitevent = {};

var App = angular.module('whiterabbitevent', [ 'ngRoute', 'wre.services','ui.bootstrap','ngMessages']);

// / Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider, $Scope) {

	/* eventView */
	$routeProvider.when('/eventView', {
		templateUrl : 'admin/eventView',
		controller : EventViewController
	});

	/* creatEvent */
	$routeProvider.when('/eventCreate', {
		templateUrl : 'admin/eventCreate',
		controller : EventCreateController
	});

	/* eventsave */
	$routeProvider.when('/eventsave', {
		templateUrl : 'admin/eventsave',
		controller : EventCreateController
	});

	/* eventEdit */
	$routeProvider.when('/eventEdit/:eventId', {
		templateUrl : 'admin/eventEdit',
		controller : EventEditController
	});

	/* eventViewDetails */
	$routeProvider.when('/eventViewDetails/:eventId', {
		templateUrl : 'admin/eventViewDetails',
		controller : EventViewDetailsController
	});

	/* agendoViewDetails */
	$routeProvider.when('/agendoDetails/:eventId', {
		templateUrl : 'admin/navigetAgendoDetails',
		controller : AgendoViewController
	});

	/* agendoCreate */
	$routeProvider.when('/agendoCreate/:eventId', {
		templateUrl : 'admin/agendoCreate',
		controller : AgendoCreateController
	});

	/* agendoEdit */

	$routeProvider.when('/agendoEdit/:agenId', {
		templateUrl : 'admin/agendoEdit',
		controller : AgendoEditController
	});

	/* newsFeedView */
	$routeProvider.when('/newsFeedView/:eventId', {
		templateUrl : 'admin/newsFeedView',
		controller : NewsFeedViewController
	});

	/* newsEdit */
	$routeProvider.when('/newsFeedEdit/:newsFeedId', {
		templateUrl : 'admin/newsFeedEdit',
		controller : NewsFeedEditController
	});

	/* newsFeedCreate */
	$routeProvider.when('/newsFeedCreate/:eventId', {
		templateUrl : 'admin/newsFeedCreate',
		controller : NewsFeedCreateController
	});

	/* galleryView */
	$routeProvider.when('/galleryView/:eventId', {
		templateUrl : 'admin/galleryView',
		controller : GalleryViewController
	});

	/* galleryCreate */
	$routeProvider.when('/galleryCreate/:eventId', {
		templateUrl : 'admin/galleryCreate',
		controller : GalleryCreateController
	});

	/* detailsView */
	$routeProvider.when('/detailsView/:eventId', {
		templateUrl : 'admin/detailsView',
		controller : DetailsViewController
	});

	/* editDetailsView */
	$routeProvider.when('/editDetailsView/:eventId', {
		templateUrl : 'admin/editDetailsView',
		controller : EditDetailsViewController
	});

	// InviteController

	$routeProvider.when('/invite/:eventId', {
		templateUrl : 'admin/invite',
		controller : InviteController
	});

	// InviteListController

	$routeProvider.when('/inviteList/:eventId', {
		templateUrl : 'admin/inviteList',
		controller : InviteListController
	});

	// VideoViewController

	$routeProvider.when('/videoView/:eventId', {
		templateUrl : 'admin/videoView',
		controller : VideoViewController
	});

	// DocumentViewController

	$routeProvider.when('/documentView/:eventId', {
		templateUrl : 'admin/documentView',
		controller : DocumentViewController
	});
	// DocumetnCreateController

	$routeProvider.when('/documentCreate/:eventId', {
		templateUrl : 'admin/documentCreate',
		controller : DocumentCreateController
	});

	// VideoUploadController
	$routeProvider.when('/videoUpload/:eventId', {
		templateUrl : 'admin/videoUpload',
		controller : VideoUploadController
	});
	//questionView
	$routeProvider.when('/questionView/:eventId', {
		templateUrl : 'admin/questionView',
		controller : QuestionViewController
	});
	
	//questionCreate.
	$routeProvider.when('/questionCreate/:eventId', {
		templateUrl : 'admin/questionCreate',
		controller : QuestionCreateController
	});
	
	//questionEdit
	$routeProvider.when('/questionEdit/:eventId/:questionId', {
		templateUrl : 'admin/questionEdit',
		controller : QuestionEditController
	});
	
	
	
	/* By Taraq */
	// sponsorPageView
	$routeProvider.when('/sponsorPageView/:eventId', {
		templateUrl : 'admin/sponsorPageView',
		controller : SponsorPageViewController
	});

	// create new Sponsor
	// $routeProvider.when('/sponsorCreate/:eventId', {
	$routeProvider.when('/sponsorCreate/:eventId', {
		templateUrl : 'admin/sponsorCreate',
		controller : SponsorCreateController
	});

	// Edit Sponsor data
	$routeProvider.when('/editSponsor/:sponcorId', {
		templateUrl : 'admin/editSponsor',
		controller : SponsorEditController
	});

	/* sponsor ends here */

	/* Speaker starts here */
	
	// speakerProfileView/
	$routeProvider.when('/speakerProfileView/:eventId', {
		templateUrl : 'admin/speakerProfileView',
		controller : SpeakerProfileViewController
	});

	// to create speaker
	$routeProvider.when('/speakerCreate/:eventId', {
		templateUrl : 'admin/speakerCreate',
		controller : SpeakerCreateController
	});

	// editSpeaker
	$routeProvider.when('/editSpeaker/:speakerId', {
		templateUrl : 'admin/editSpeaker',
		controller : SpeakerEditController
	});

	/* Speaker ended here... */

	// #/venueLayout/
	$routeProvider.when('/venueLayout/:eventId', {
		templateUrl : 'admin/venueLayoutView',
		controller : VenueLayoutController
	});

	
	//#/contactDetailsView/
	$routeProvider.when('/contactDetailsView/:eventId', {
		templateUrl : 'admin/contactDetailsView',
		controller : ContactDetailsViewController
	});
	
	//#/editContatctDetails/
	$routeProvider.when('/editContatctDetails/:contactId', {
		templateUrl : 'admin/editContactDetails',
		controller : EditContactDetailsController
	});
	
	/*chat view starts here	*/
	//chat view list
		$routeProvider.when('/navigateToChatList/:eventId', {
			templateUrl : 'admin/navigateToChatTopicList',
			controller : ChatTopicListViewController
		});
		
	//chat Create 
		$routeProvider.when('/chatTopicCreate/:eventId', {
			templateUrl : 'admin/navigateToCreateChatTopic',
			controller : ChatTopicCreateController
		});

		//chat viewdetails
		$routeProvider.when('/chatTopicView/:chatTopicId', {
			templateUrl : 'admin/navigateChatDetails',
			controller : ChatTopicViewDetailsController
		});
		
		/*chat view ends here	*/
	
		/*Q&A Starts here*/
		//QuestionAndAnswersViewController
	$routeProvider.when('/QuestionAndAnswersView/:eventId/', {
		templateUrl : 'admin/QuestionAndAnswersView',
		controller : QuestionAndAnswersViewController
	});
	
	$routeProvider.when('/ViewParticipantAnswers/:eventId/:participantId', {
		templateUrl : 'admin/ViewParticipantAnswers',
		controller : ViewParticipantAnswersController
	});
	
	/*Q&A*/
	
	/*SocialMedia Starts Here*/
	//to create socialMedia..../createSocialMedia/
	$routeProvider.when('/createSocialMedia/:eventId',{
		templateUrl: 'admin/createSocialMedia',
		controller: CreateSocialMediaController
	});
	
	//SocialMedia
	$routeProvider.when('/SocialMedia/:eventId/', {
		templateUrl : 'admin/SocialMedia',
		controller : SocialMediaController
	});
	//edit socailMedia---editSocialMedia
	$routeProvider.when('/editSocialMedia/:socialId/', {
		templateUrl : 'admin/editSocialMedia',
		controller : EditSocialMediaController
	});
	
	
	/*NetworkingViewController*/
	$routeProvider.when('/networkingView/:eventId/', {
		templateUrl : 'admin/networkingView',
		controller : NetworkingViewController
	});
	
	//NetworkingEditController
	$routeProvider.when('/networkingEdit/:participantId/:eventId', {
		templateUrl : 'admin/networkingEdit',
		controller : NetworkingEditController
	});
	
	 $routeProvider.when('/eventImageUpload/:eventId',{
		 templateUrl:'admin/eventImageUpload',
		 controller:EventImageUploadController
	 });
	
	$routeProvider.otherwise({
			
			redirectTo : '/eventView'
	});
} ]);


App.filter('startFrom', function () {
	return function (input, start) {
		if (input) {
			start = +start;
			return input.slice(start);
		}
		return [];
	};
});


App.directive('format', function ($filter) {
    'use strict';
    return {
        require: '?ngModel',
        link: function (scope, elem, attrs, ctrl) {
            if (!ctrl) {
                return;
            }
            ctrl.$formatters.unshift(function () {
                return $filter('number')(ctrl.$modelValue);
            });

            //====================
           /* //to add comma to the mobile numbers
            ctrl.$parsers.push(function (viewValue) {

            	//var transformedInput = viewValue.toLowerCase().replace(/ /g, '');
                  //replace(/[^\dA-Z]/g, '').replace(/(.{10})/g, '$1,')
            	var transformedInput = viewValue.replace(/[^\dA-Z]/g, '').replace(/(.{10})/g, '$1,').trim();
            	//alert(transformedInput.substr(1));
            	
            		if(transformedInput.charAt(0)==",")
            			{
            			 transformedInput=transformedInput.substr(1);
            			}
            	
                  if (transformedInput!=viewValue) {
                    ctrl.$setViewValue(transformedInput);
                    ctrl.$render();
                  }         

                  return transformedInput;         
                });
*/           
//============================
           
        }
    };
}).controller('InputCtrl', function($scope) {
});

//to validate the file for image/document/video upload
App.directive('validFile',function(){
  return {
    require:'ngModel',
    link:function(scope,el,attrs,ngModel){
      //change event is fired when file is selected
      el.bind('change',function(){
        scope.$apply(
        function(){
          ngModel.$setViewValue(el.val());
          ngModel.$render();
        });
      });
    }
  };
});




