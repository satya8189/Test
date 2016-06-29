


'use strict';


var whiterabbitevent = {};


var App = angular.module('whiterabbitevent',  ['ngRoute','wre.services','ngMessages','wre.filters','ui.bootstrap']);

/// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider,$Scope) {

	 $routeProvider.when('/clientsView', {
	        templateUrl:'systemadmin/clientsView',
	        controller:ClientsViewController
	    });
	 
	 $routeProvider.when('/createClient', {
	        templateUrl:'systemadmin/createClient',
	        controller:ClientCreateController
	    });
	 
	 $routeProvider.when('/clientEventsView/:clientId', {
         templateUrl:'systemadmin/navigateEventList',
         controller:ClientEventViewController
     });
	 
	 $routeProvider.when('/clientEventsCreate/:clientId',{
		 templateUrl:'systemadmin/navigateToEventCreate',
		 controller:ClientEventCreateController
	 });
	
	 $routeProvider.when('/clientEventEdit/:eventId',{
		 templateUrl:'systemadmin/navigatetoClientEventEdit',
		 controller:ClientEventEditController
	 });
	 
	 
	 //EventViewController
	 $routeProvider.when('/eventView/:eventId',{
		 templateUrl:'systemadmin/eventView',
		 controller:EventViewController
	 });
	 
	 //serviceList view...../serviceListView
	 $routeProvider.when('/serviceListView/:eventId',{
		 templateUrl:'systemadmin/serviceListView',
		 controller: ServiceViewController
	 });
/*	Admin Services details view starts here  */
	 //agendo view 
	 $routeProvider.when('/agendoDetails/:eventId', {
			templateUrl : 'admin/navigetAgendoDetails',
			controller : AgendoViewController
		});
	 //event details
	 $routeProvider.when('/detailsView/:eventId', {
			templateUrl : 'admin/detailsView',
			controller : DetailsViewController
		});
	 //newsfeed
	 $routeProvider.when('/newsFeedView/:eventId', {
			templateUrl : 'admin/newsFeedView',
			controller : NewsFeedViewController
		});
	 //gallery 
	 $routeProvider.when('/galleryView/:eventId', {
			templateUrl : 'admin/galleryView',
			controller : GalleryViewController
		});
//video view
	 $routeProvider.when('/videoView/:eventId', {
			templateUrl : 'admin/videoView',
			controller : VideoViewController
		});
//documentView 
	 $routeProvider.when('/documentView/:eventId', {
			templateUrl : 'admin/documentView',
			controller : DocumentViewController
		});
	 
//QuestionAndAnswersView
	 $routeProvider.when('/QuestionAndAnswersView/:eventId/', {
			templateUrl : 'admin/QuestionAndAnswersView',
			controller : QuestionAndAnswersViewController
		});
//AnswersByPratipantsView
	 $routeProvider.when('/ViewParticipantAnswers/:eventId/:participantId', {
			templateUrl : 'admin/ViewParticipantAnswers',
			controller : ViewParticipantAnswersController
		});
//SocialMediaView
	 $routeProvider.when('/SocialMedia/:eventId/', {
			templateUrl : 'admin/SocialMedia',
			controller : SocialMediaController
		});
//NetworkView
	 $routeProvider.when('/networkingView/:eventId/', {
			templateUrl : 'admin/networkingView',
			controller : NetworkingViewController
		});
//SpeakerView profile
	 $routeProvider.when('/speakerProfileView/:eventId', {
			templateUrl : 'admin/speakerProfileView',
			controller : SpeakerProfileViewController
		});
//sponsor View 
	 $routeProvider.when('/sponsorPageView/:eventId', {
			templateUrl : 'admin/sponsorPageView',
			controller : SponsorPageViewController
		});
//Questions View
	 $routeProvider.when('/questionView/:eventId', {
			templateUrl : 'admin/questionView',
			controller : QuestionViewController
		});
	 
//Invite View
	 $routeProvider.when('/invite/:eventId', {
			templateUrl : 'admin/invite',
			controller : InviteController
		});
	 
//InviteListView
	 $routeProvider.when('/inviteList/:eventId', {
			templateUrl : 'admin/inviteList',
			controller : InviteListController
		});
//ChatTopic view
	 $routeProvider.when('/navigateToChatList/:eventId', {
		templateUrl : 'admin/navigateToChatTopicList',
		controller : ChatTopicListViewController
	});
//EventView details
	 $routeProvider.when('/eventViewDetails/:eventId', {
			templateUrl : 'admin/eventViewDetails',
			controller : EventViewDetailsController
		});
/*	Admin Services details view Ends here*/
    $routeProvider.otherwise({redirectTo: '/clientsView'});
}]);
    
App.filter('startFrom', function () {
	return function (input, start) {
		if (input) {
			start = +start;
			return input.slice(start);
		}
		return [];
	};
});
    