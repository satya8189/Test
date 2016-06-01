package com.wre.adminmgmt.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.AppIdentifierBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.InviteBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.bean.QuestionBean;
import com.wre.adminmgmt.bean.SpeakerBean;
import com.wre.adminmgmt.bean.SponsorBean;
import com.wre.adminmgmt.service.AdminMgmtService;

@Controller
public class AdminMgmtController {

	@Autowired
	@Qualifier(value = "AdminMgmtService")
	private AdminMgmtService adminMgmtService;
	private static final Log log = LogFactory.getLog(AdminMgmtController.class);

	// event view page
	@RequestMapping(value = "admin/eventView")
	public String eventView() {
		log.info("navigate to eventView page");
		return "admin/eventView";
	}

	// create event
	@RequestMapping(value = "admin/eventCreate")
	public String eventCreate() {
		log.info("in side eventCreate method");
		return "admin/eventCreate";
	}

	// update page
	@RequestMapping("admin/eventEdit")
	public String eventEdit() {
		log.info("Inside eventEdit method()");
		return "admin/eventUpdate";
	}

	// eventViewDetailsPage
	@RequestMapping("admin/eventViewDetails")
	public String eventViewDetails() {
		log.info("Inside eventViewDetails method()");
		return "admin/eventViewDetails";
	}

	// agendoViewDetailsPage
	@RequestMapping("admin/navigetAgendoDetails")
	public String agendoViewDetails() {
		log.info("Inside agendoViewDetails method()");
		return "admin/agendoViewDetails";
	}

	// agendoCreatePage
	@RequestMapping(value = "admin/agendoCreate")
	public String agendoCreate() {
		log.info("in side agendoCreate method");
		return "admin/agendoCreate";
	}

	// agendoEdit
	@RequestMapping(value = "admin/agendoEdit")
	public String agendoEdit() {
		log.info("in side agendoEdit method");
		return "admin/agendoEdit";
	}

	// admin/newsFeedView
	@RequestMapping(value = "admin/newsFeedView")
	public String newsFeedView() {
		log.info("in side newsFeedView method");
		return "admin/newsFeedView";
	}

	// admin/newsEdit
	@RequestMapping(value = "admin/newsFeedEdit")
	public String newsFeedEdit() {
		log.info("in side newsFeedEdit method");
		return "admin/newsFeedEdit";
	}

	// admin/newsFeedCreate
	@RequestMapping(value = "admin/newsFeedCreate")
	public String newsFeedCreate() {
		log.info("in side newsFeedCreate method");
		return "admin/newsFeedCreate";
	}

	/* admin/galleryView */

	@RequestMapping(value = "admin/galleryView")
	public String galleryView() {
		log.info("in side galleryView");
		return "admin/galleryView";
	}

	// admin/galleryCreate

	@RequestMapping(value = "admin/galleryCreate")
	public String galleryCreate() {
		log.info("in side galleryCreate");
		return "admin/galleryCreate";
	}

	// detailsView page
	@RequestMapping(value = "admin/detailsView")
	public String detailsView() {
		log.info("navigate to detailsView page");
		return "admin/detailsView";
	}

	// admin/editDetailsView
	@RequestMapping(value = "admin/editDetailsView")
	public String editDetailsView() {
		log.info("navigate to editDetailsView page");
		return "admin/editDetailsView";
	}

	// admin/invite

	@RequestMapping(value = "admin/invite")
	public String invite() {
		log.info("navigate to invite page");
		return "admin/invite";
	}

	// admin/inviteList
	@RequestMapping(value = "admin/inviteList")
	public String inviteList() {
		log.info("navigate inviteList page");
		return "admin/inviteList";
	}

	// admin/videoView
	@RequestMapping(value = "admin/videoView")
	public String videoView() {
		log.info("navigate videoView page");
		return "admin/videoView";
	}

	// admin/documentView

	@RequestMapping(value = "admin/documentView")
	public String documentView() {
		log.info("navigate documentView page");
		return "admin/documentView";
	}

	// admin/documetnCreate
	@RequestMapping(value = "admin/documentCreate")
	public String documentCreate() {
		log.info("navigate documentCreate page");
		return "admin/documentCreate";
	}

	// admin/videoUploadView

	@RequestMapping(value = "admin/videoUpload")
	public String videoUpload() {
		log.info("navigate videoUpload page");
		return "admin/videoUpload";
	}

	// admin/questionView

	@RequestMapping(value = "admin/questionView")
	public String questionView() {
		log.info("navigate questionView page");
		return "admin/questionView";
	}

	// admin/questionCreate

	@RequestMapping(value = "admin/questionCreate")
	public String questionCreate() {
		log.info("navigate questionCreate page");
		return "admin/questionCreate";
	}

	// admin/questionEdit
	@RequestMapping(value = "admin/questionEdit")
	public String questionEdit() {
		log.info("navigate questionEdit page");
		return "admin/questionEdit";
	}

	// admin/venueLayout
	@RequestMapping(value = "admin/venueLayoutView")
	public String venueLayoutView() {
		log.info("navigate venueLayout page");
		return "admin/venueLayoutView";
	}

	// admin/quationAndAnswersView

	@RequestMapping(value = "admin/quationAndAnswersView")
	public String quationAndAnswersView() {
		log.info("navigate quationAndAnswersView page");
		return "admin/quationAndAnswersView";
	}

	// view event list
	@RequestMapping(value = "admin/eventList")
	public @ResponseBody
	List<EventBean> getEventList(@RequestParam("userId") Long userId) {
		log.info("in side Eventlist method----" + userId);
		List<EventBean> eventList = adminMgmtService.getEventList(userId);
		return eventList;

	}

	// save event
	@RequestMapping(value = "admin/saveEvent", method = RequestMethod.POST)
	public @ResponseBody
	void saveEvent(@RequestBody EventBean eventBean) {
		log.info("in side saveEvent method");
		adminMgmtService.saveEvent(eventBean);
	}

	// event details
	@RequestMapping(value = "admin/eventdetailsList", method = RequestMethod.GET)
	public @ResponseBody
	List<EventBean> getEventDetails(@RequestParam("eventId") String eventId) {
		List<EventBean> eventList = adminMgmtService
				.getEventDetailsList(eventId);
		return eventList;

	}

	// update event
	@RequestMapping(value = "event/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateEvent(@RequestBody EventBean eventBean) {
		adminMgmtService.updateEvent(eventBean);
	}

	// create agendo
	@RequestMapping(value = "admin/createAgendo", method = RequestMethod.POST)
	public @ResponseBody
	void createAgendo(@RequestBody AgendaBean agendaBean) {
		log.info("in side save method");
		adminMgmtService.createAgendo(agendaBean);
	}

	@RequestMapping(value = "admin/createGallery", method = RequestMethod.POST)
	public @ResponseBody
	void createGallery(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("name") String name, @RequestParam("type") String type) {
		log.info("in side savegallery method");
		log.info("id--" + eventId);
		log.info("file name---" + file.getOriginalFilename());
		adminMgmtService.createGallery(file, eventId, type, name);
	}

	// admin/agendoDetails

	@RequestMapping(value = "admin/agendoDetails",method = RequestMethod.GET)
	public @ResponseBody
	List<AgendaBean> getAgendoDetails(@RequestParam("eventId") Long eventId) {
		log.info("in side AgendoDetails method----" + eventId);
		List<AgendaBean> agendoList = adminMgmtService
				.getAgendoDetails(eventId);
		return agendoList;

	}

	// agendo edit
	@RequestMapping(value = "admin/agendoEditDetails", method = RequestMethod.GET)
	public @ResponseBody
	AgendaBean agendoEditDetails(@RequestParam("agenId") Long agenId) {
		AgendaBean agendaBean = adminMgmtService.agendoEditDetails(agenId);
		return agendaBean;

	}

	// agendoupdate
	@RequestMapping(value = "agendo/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateAgendo(@RequestBody AgendaBean agendaBean) {
		System.out.println("agendaBean update" + agendaBean.getAgenTitle());
		adminMgmtService.updateAgendo(agendaBean);
	}

	// saveNews
	@RequestMapping(value = "admin/saveNews", method = RequestMethod.POST)
	public @ResponseBody
	void saveNews(@RequestBody NewsFeedBean newsFeedBean) {
		log.info("in side saveNews method");
		adminMgmtService.saveNews(newsFeedBean);

	}

	// News List
	@RequestMapping(value = "admin/newsList")
	public @ResponseBody
	List<NewsFeedBean> getNewsList(@RequestParam("eventId") Long eventId) {
		log.info("in side newsList method----" + eventId);
		List<NewsFeedBean> newsList = adminMgmtService.getNewsList(eventId);
		return newsList;

	}

	// news edit
	@RequestMapping(value = "admin/newsEditDetails", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	NewsFeedBean newsEditDetails(@RequestParam("newsFeedId") Long newsFeedId) {
		NewsFeedBean newsFeedBean = adminMgmtService
				.newsEditDetails(newsFeedId);
		return newsFeedBean;

	}

	// news/update

	@RequestMapping(value = "news/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateNews(@RequestBody NewsFeedBean newsFeedBean) {
		System.out.println("newsFeedBean update" + newsFeedBean.getNewsDesc());
		adminMgmtService.updateNews(newsFeedBean);
	}

	// admin/galleryList
	@RequestMapping(value = "admin/galaryList")
	public @ResponseBody
	List<GalaryBean> galaryList(@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type) {
		log.info("in side galaryList method----" + eventId);
		List<GalaryBean> galaryList = adminMgmtService
				.galaryList(eventId, type);

		return galaryList;
	}

	// admin/detailsView

	@RequestMapping(value = "admin/Viewdetails", method = RequestMethod.GET)
	public @ResponseBody
	EventBean detailsView(@RequestParam("eventId") Long eventId) {
		EventBean eventBean = adminMgmtService.detailsView(eventId);
		return eventBean;

	}

	// details/update

	@RequestMapping(value = "details/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateDetails(@RequestBody EventBean eventBean) {
		adminMgmtService.updateDetails(eventBean);
	}

	// admin/createGallery

	// admin/invite

	@RequestMapping(value = "admin/invite", method = RequestMethod.POST)
	public @ResponseBody
	void invite(@RequestBody InviteBean inviteBean) {
		log.info("in side invite method");
		adminMgmtService.invite(inviteBean);

	}

	// admin/inviteDetails
	@RequestMapping(value = "admin/inviteDetails")
	public @ResponseBody
	List<InviteBean> inviteDetails(@RequestParam("eventId") Long eventId) {
		log.info("in side inviteDetails method----" + eventId);
		List<InviteBean> inviteList = adminMgmtService.inviteDetails(eventId);

		return inviteList;

	}

	// for deleteGallery
	@RequestMapping(value = "admin/deleteGallery", method = RequestMethod.GET)
	public @ResponseBody
	void deleteGallery(@RequestParam("glaryItemId") Long glaryItemId) {
		log.info("Entered into delete  galary  method----------" + glaryItemId);
		adminMgmtService.deleteGallery(glaryItemId);

	}

	// admin/deleteGallery

	// admin/questionList
	@RequestMapping(value = "admin/questionList")
	public @ResponseBody
	List<QuestionBean> questionList(@RequestParam("eventId") Long eventId) {
		log.info("in side questionList method----" + eventId);
		List<QuestionBean> questionList = adminMgmtService
				.questionList(eventId);
		return questionList;

	}

	// admin/questionCreate

	@RequestMapping(value = "admin/questionCreate", method = RequestMethod.POST)
	public @ResponseBody
	void questionCreate(@RequestBody QuestionBean questionBean) {
		log.info("in side questionCreate method");
		adminMgmtService.questionCreate(questionBean);

	}

	// admin/appList
	@RequestMapping(value = "admin/appList")
	public @ResponseBody
	List<AppIdentifierBean> appList(@RequestParam("appId") Long appId) {
		log.info("in side appList method----" + appId);
		List<AppIdentifierBean> appList = adminMgmtService.appList(appId);
		return appList;

	}

	// admin/questionEdit

	@RequestMapping(value = "admin/questionEditDetails", method = RequestMethod.GET)
	public @ResponseBody
	QuestionBean questionEdit(@RequestParam("questionId") Long questionId) {
		QuestionBean questionBean = adminMgmtService.questionEdit(questionId);
		log.info("in side questionEdit method----"
				+ questionBean.getAppIdentifierName());
		return questionBean;

	}

	//
	@RequestMapping(value = "question/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateQuestion(@RequestBody QuestionBean questionBean) {
		adminMgmtService.updateQuestionDetails(questionBean);
	}

	// admin/createVenuLayout

	@RequestMapping(value = "admin/uploadVenuLayout", method = RequestMethod.POST)
	public @ResponseBody
	void uploadVenuLayout(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type) {
		log.info("in side uploadVenu method");
		log.info("id--" + eventId);
		log.info("file name---" + file.getOriginalFilename());
		adminMgmtService.uploadVenuLayout(file, eventId, type);
	}

	/* ============Sponsor Page Module============== */
	/* By Taraq */
	// admin/sponsorPageView
	@RequestMapping(value = "admin/sponsorPageView")
	public String sponsorPageView() {
		log.info("navigate to sponsorPage");
		return "admin/sponsorPageView";
	}

	/* get the list of sponsorors */

	// admin/getSponsorDetails
	@RequestMapping(value = "admin/sponsorsList")
	public @ResponseBody
	List<SponsorBean> getSponsorsList(@RequestParam("eventId") Long eventId) {
		log.info("in side getSponsorList method----" + eventId);

		List<SponsorBean> sponsorsList = adminMgmtService
				.getSponsorsList(eventId);
		// return eventList;
		log.info("sponsors List........." + sponsorsList);
		return sponsorsList;

	}

	// crete new sponsor
	/* admin/sponsorCreate */
	@RequestMapping(value = "admin/sponsorCreate")
	public String sponsorCreate() {
		log.info("navigate to sponsorCreate");
		return "admin/sponsorCreate";
	}

	/* saveSponsor */// admin/sponsorSave
	@RequestMapping(value = "admin/sponsorSave", method = RequestMethod.POST)
	public @ResponseBody
	void saveSponsor(@RequestBody SponsorBean sponsorBean) {
		log.info("in side sponsorSave method");
		log.info("checking......" + sponsorBean.getSponcorName() + "=="
				+ sponsorBean.getEventId() + "--"
				+ sponsorBean.getSponcorDesc());

		adminMgmtService.createSponsor(sponsorBean);
	}

	// admin/editSponsor
	// go to edit sponsor
	@RequestMapping(value = "admin/editSponsor")
	public String editSponsor() {
		log.info("navigating to editSponsor page");
		return "admin/sponsorEdit";
	}

	/* get sponsor data for update */
	@RequestMapping(value = "admin/getSponsorDataonSponsorId", method = RequestMethod.GET)
	public @ResponseBody
	SponsorBean getSponsorDataForEdit(@RequestParam("sponcorId") Long sponcorId) {
		log.info("sponsor Id for Edit" + sponcorId);
		SponsorBean sb = adminMgmtService.getSponsorForEdit(sponcorId);

		log.info("sponcor for edit......" + sb);
		return sb;
	}

	@RequestMapping(value = "admin/updateSponsor", method = RequestMethod.POST)
	public @ResponseBody
	void updateSponsor(@RequestBody SponsorBean sb) {
		log.info("in side updateSponsor method" + sb.getSponcorName() + "--"
				+ sb.getEventId());

		adminMgmtService.updateSponsor(sb);
	}

	/* ============End of Sponsor======== */

	/* ==========starting speaker =========== */
	// admin/speakerProfileView
	@RequestMapping("admin/speakerProfileView")
	public String goToSpeakersList() {

		return "admin/speakerProfileView";
	}

	@RequestMapping("admin/speakersList")
	public @ResponseBody
	List<SpeakerBean> getSpeakersList(Long eventId) {
		log.info("in getSpeakersList---"+eventId);
		List<SpeakerBean> sl = adminMgmtService.getSpeakersList(eventId);
		//log.info("---eventId----" + eventId);
		log.info("--speakerslist ---" + sl);
		// return null;
		return sl;
	}

	// create speaker
	// admin/speakerCreate
	@RequestMapping(value = "admin/speakerCreate")
	public String goToCreateSpeaker() {
		log.info("in goToCreateSpeaker..");

		return "admin/speakerCreate";
	}

	@RequestMapping(value = "admin/speakerSave", method = RequestMethod.POST)
	public @ResponseBody
	void saveSpeaker(@RequestBody SpeakerBean spk) {
		log.info("in side speakerSave method");
		log.info("checking......" + spk.getDescription());
		adminMgmtService.createSpeaker(spk);
	}

	// admin/speakerEdit
	@RequestMapping(value = "admin/editSpeaker")
	public String editSpeaker() {
		log.info("in side speakerEdit method");
		return "admin/speakerEdit";
	}

	// admin/getSpeakerBySpeakerId
	@RequestMapping(value = "admin/getSpeakerBySpeakerId")
	public @ResponseBody
	SpeakerBean getSpeakerBySpeakerId(@RequestParam("speakerId") Long speakerId) {
		log.info("in side getspeaker method" + speakerId);
		return adminMgmtService.getSpeakerBySpeakerId(speakerId);

	}

	// udpate speaker......admin/updateSpeaker
	@RequestMapping(value = "admin/updateSpeaker", method = RequestMethod.POST)
	public @ResponseBody
	void updateSpeaker(@RequestBody SpeakerBean spk) {
		log.info("in side updatespeaker method");
		log.info("checking......" + spk.getDescription());
		adminMgmtService.udpateSpeaker(spk);
	}

	/* Speaker Ends Here* */

	/* venue Layout Starts here */
	// admin/venueLayout
	@RequestMapping(value = "admin/venueLayout")
	public String goToVenueLayoutView() {
		log.info("in side venueLayoutView method");
		return "admin/venueLayoutView";
	}

}
