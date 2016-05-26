'use strict';

var whiterabbitevent = {};

var App = angular.module('whiterabbitevent', [ 'ngRoute', 'wre.services' ]);

// / Declare app level module which depends on filters, and services
App.config([ '$routeProvider', function($routeProvider, $Scope) {

	/* eventView */
	$routeProvider.when('/eventView/:userId', {
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
		controller : DocumetnCreateController
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
	
	//QuationAndAnswersViewController
	$routeProvider.when('/quationAndAnswersView/:eventId/', {
		templateUrl : 'admin/quationAndAnswersView',
		controller : QuationAndAnswersViewController
	});
	
	QuationAndAnswersViewController.js
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

	$routeProvider.otherwise({
		redirectTo : '/eventView'
	});
} ]);
