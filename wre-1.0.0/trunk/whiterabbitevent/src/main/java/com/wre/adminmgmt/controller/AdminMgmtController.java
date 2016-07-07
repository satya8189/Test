package com.wre.adminmgmt.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.wre.adminmgmt.bean.AgendaBean;
import com.wre.adminmgmt.bean.AppIdentifierBean;
import com.wre.adminmgmt.bean.ChatBean;
import com.wre.adminmgmt.bean.ChatTopicBean;
import com.wre.adminmgmt.bean.ContactDetailsBean;
import com.wre.adminmgmt.bean.EventBean;
import com.wre.adminmgmt.bean.GalaryBean;
import com.wre.adminmgmt.bean.InviteBean;
import com.wre.adminmgmt.bean.NewsFeedBean;
import com.wre.adminmgmt.bean.ParticipantQuriesBean;
import com.wre.adminmgmt.bean.QuestionBean;
import com.wre.adminmgmt.bean.RatingBean;
import com.wre.adminmgmt.bean.SocialMediaBean;
import com.wre.adminmgmt.bean.SpeakerBean;
import com.wre.adminmgmt.bean.SponsorBean;
import com.wre.adminmgmt.bean.SurveyQuestionAnswerBean;
import com.wre.adminmgmt.service.AdminMgmtService;
import com.wre.common.util.WREConstants;
import com.wre.systemadminmgmt.bean.ClientBean;
import com.wre.systemadminmgmt.bean.ParticipantBean;
import com.wre.systemadminmgmt.bean.ParticipantEventBean;

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
	List<EventBean> getEventDetails(@RequestParam("eventId") Long eventId) {
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

	@RequestMapping(value = "admin/agendoDetails", method = RequestMethod.GET)
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
	EventBean detailsView(@RequestParam("eventId") Long eventId,@RequestParam("type") String type) {
		EventBean eventBean= adminMgmtService.detailsView(eventId,type);
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
	
	@RequestMapping(value ="admin/deleteEventImage", method = RequestMethod.POST)
	public @ResponseBody void deleteGalleryImage(@RequestBody GalaryBean galaryBean ) {
		try {
			File dir = new File(WREConstants.DELETE_PATH+galaryBean.getUrl());
			String folderToDelete = dir.toString();
			File deleteFile = new File(folderToDelete);
			if (deleteFile.exists()) {
				deleteFile.delete();
			  }
		} catch (Exception e) {
			log.error(e);
		}
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
	void saveSponsor(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type,
			@RequestParam("sponcorDesc") String sponcorDesc,
			@RequestParam("sponcorName") String sponcorName) {

		log.info(" in side sponsorSave method");
		adminMgmtService.createSponsor(file, eventId, type, sponcorDesc,
				sponcorName);
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

	// updateSponsor
	@RequestMapping(value = "admin/updateSponsor", method = RequestMethod.POST)
	public @ResponseBody
	void updateSponsor(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("sponcorId") Long sponcorId,
			@RequestParam("type") String type,
			@RequestParam("sponcorName") String sponcorName,
			@RequestParam("sponcorDesc") String sponcorDesc) {

		log.info("in side speakerSave method");

		adminMgmtService.updateSponsor(file, eventId, type, sponcorName,
				sponcorDesc, sponcorId);
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
		log.info("in getSpeakersList---" + eventId);
		List<SpeakerBean> sl = adminMgmtService.getSpeakersList(eventId);
		// log.info("---eventId----" + eventId);
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
	void saveSpeaker(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type,
			@RequestParam("speakerName") String speakerName,
			@RequestParam("location") String location,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("rating") String rating) {
		log.info("in side speakerSave method");

		adminMgmtService.createSpeaker(file, eventId, type, speakerName,
				location, title, description, rating);
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

	// udpateSpeaker
	@RequestMapping(value = "admin/updateSpeaker", method = RequestMethod.POST)
	public @ResponseBody
	void udpateSpeaker(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("speakerId") Long speakerId,
			@RequestParam("type") String type,
			@RequestParam("speakerName") String speakerName,
			@RequestParam("location") String location,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("rating") String rating) {
		log.info("in side speakerSave method");

		adminMgmtService.udpateSpeaker(file, eventId, type, speakerName,
				location, title, description, rating, speakerId);
	}

	/* Speaker Ends Here* */

	/* venue Layout Starts here */
	// admin/venueLayout
	@RequestMapping(value = "admin/venueLayout")
	public String goToVenueLayoutView() {
		log.info("in side venueLayoutView method");
		return "admin/venueLayoutView";
	}

	@RequestMapping(value = "getuser", method = RequestMethod.POST)
	public @ResponseBody
	List<ChatBean> getuser(@RequestBody ChatBean chatBean) {
		log.info("in side updatespeaker method");
		log.info("checking......" + chatBean.getMobno());
		return adminMgmtService.getUser(chatBean.getMobno());
	}

	@RequestMapping(value = "send", method = RequestMethod.POST)
	public @ResponseBody
	String send(@RequestBody ChatBean chatBean) {

		String result = "success";
		HttpResponse httpResponse = null;
		HttpClient httpclient = null;
		HttpEntity httpEntity = null;
		String url = "https://android.googleapis.com/gcm/send";
		JSONArray array = new JSONArray();
		// array.add("APA91bEe6q1iMfeEviUi5h6mz4JDGt8_U2FUkip_m6umlgEwfmBAjYGygYVTaqfN60ibhGkIaXh8x3L1Oj3hb0eLbTpuj-oQJmgByw53nPrBjRoqsdIeNQU3-YUrkH9zDXYwmGT7bkSE");
		List<ChatBean> chatBeanList = adminMgmtService.getUser(chatBean
				.getFrom());
		for (ChatBean chatBeanObj : chatBeanList) {
			array.add(chatBeanObj.getReg_id());
		}

		JSONObject obj = new JSONObject();
		JSONObject data = new JSONObject();
		data.put("msg", chatBean.getMsg());
		data.put("fromu", chatBean.getFrom());
		data.put("name", chatBean.getFromn());
		data.put("date", chatBean.getDate());
		data.put("topic", chatBean.getTopic());
		data.put("eventId", chatBean.getEventId());
		obj.put("registration_ids", array);
		obj.put("data", data);
		obj.put("time_to_live", 4444);
		System.out.println("final string ---" + obj.toString());
		try {
			HttpPost post = new HttpPost(url);
			post.setEntity(new StringEntity(obj.toString()));
			httpclient = new DefaultHttpClient();
			post.setHeader("Accept", "application/json");
			post.setHeader("Content-type", "application/json");
			post.setHeader("Authorization",
					"key=AIzaSyB0jpk-YqaD6UsG5IppdjGLEM0ozNCNHSk");
			httpResponse = httpclient.execute(post);
			httpEntity = httpResponse.getEntity();
			String jsonResult = inputStreamToString(
					httpResponse.getEntity().getContent()).toString();
			System.out.println("Result " + jsonResult);
			result = "Success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"response\":\"" + result + "\"}";
	}

	private StringBuilder inputStreamToString(InputStream is) {
		String rLine = "";
		StringBuilder answer = new StringBuilder();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader rd = new BufferedReader(isr);
		try {
			while ((rLine = rd.readLine()) != null) {
				answer.append(rLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return answer;
	}

	// admin/uploadEventImage

	@RequestMapping(value = "admin/uploadEventImage", method = RequestMethod.POST)
	public @ResponseBody
	void uploadEventImage(
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type) {
		log.info("in side uploadVenu method");
		log.info("id--" + eventId);
		log.info("file name---" + file.getOriginalFilename());
		adminMgmtService.uploadEventImage(file, eventId, type);
	}

	@RequestMapping(value = "admin/getEventImages", method = RequestMethod.GET)
	public @ResponseBody 
	List<GalaryBean> getEventImages(@RequestParam("eventId") Long eventId,
			@RequestParam("type") String type) {
		//to get the event name by passing eventId
		
		List<GalaryBean> eventImages = new ArrayList<GalaryBean>();
		String path = WREConstants.RESOURCE_PATH + eventId + "/" + type;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles!=null){
		for (File file : listOfFiles) {
			GalaryBean galaryBean = new GalaryBean();
			galaryBean.setName(file.getName());
			galaryBean.setEventId(eventId);
			galaryBean.setType(type);
			galaryBean.setUrl("/Resources/wre/" + eventId + "/" + type + "/"
					+ file.getName());
			eventImages.add(galaryBean);
			}
			log.info(eventImages.size());
		}
		return eventImages;
	}

	@RequestMapping(value = "admin/eventServicesList", method = RequestMethod.GET)
	public @ResponseBody
	List<EventBean> eventServicesList(@RequestParam("eventId") Long eventId) {
		List<EventBean> eventList = adminMgmtService
				.geteventServicesList(eventId);
		return eventList;

	}

	@RequestMapping(value = "/participantRegUpdate", method = RequestMethod.POST)
	public @ResponseBody
	String participantRegUpdate(@RequestBody ParticipantBean participantBean) {
		log.info("in side updatespeaker method");
		log.info("checking......" + participantBean.getPhoneNumber());
		String result = adminMgmtService.participantRegUpdate(participantBean);
		return "{\"response\":\"" + result + "\"}";
	}

	// =================Rating API
	// to save the rating given
	@RequestMapping(value = "admin/saveUserRating", method = RequestMethod.POST)
	public @ResponseBody
	String saveUserRating(@RequestBody RatingBean ratingBean) {
		System.out.println("in saveUserRating.." + ratingBean.getType());
		log.info("rating sent to service..");
		return adminMgmtService.saveUserRating(ratingBean);
	}

	// to list all the ratings
	@RequestMapping(value = "admin/getUserRatings", method = RequestMethod.POST)
	public @ResponseBody
	List<RatingBean> getUserRatings(@RequestBody RatingBean ratingBean)
	// public @ResponseBody List<RatingBean>
	// getUserRatings(@RequestParam("eventId")Long eventId)
	{
		log.info("in getUserRatingsList by EventId--");
		// List<RatingBean>
		// userRatingsList=adminMgmtService.getUserRatings(eventId);
		List<RatingBean> userRatingsList = adminMgmtService
				.getUserRatings(ratingBean);
		return userRatingsList;
	}

	// =========contact details.....
	@RequestMapping("admin/contactDetailsView")
	public String goToContactDetailsView() {
		log.info("in goToContactDetailsView");
		return "admin/contactDetailsView";
	}

	// To view Contact Details
	@RequestMapping(value = "admin/ViewContactDetails", method = RequestMethod.GET)
	public @ResponseBody
	List<ContactDetailsBean> adminViewContactDetails(Long eventId) {
		List<ContactDetailsBean> contactDetailsList = adminMgmtService
				.adminViewContactDetails(eventId);
		return contactDetailsList;
	}

	// to Edit the contact details
	@RequestMapping("admin/editContactDetails")
	public String goToEditContactDetails() {
		log.info("in goToEditContactDetails");
		return "admin/editContactDetails";
	}

	// get contact dettails to edit admin/getContactDetailsForEdit
	@RequestMapping(value = "admin/getContactDetailsForEdit", method = RequestMethod.GET)
	// public @ResponseBody List<ContactDetailsBean>
	// getContactDetailsForEditByContactId(@RequestParam Long contactId)
	public @ResponseBody
	ContactDetailsBean getContactDetailsForEditByContactId(
			@RequestParam Long contactId) {
		log.info("in getContactDetails for edit" + contactId);
		return adminMgmtService.getContactDetailsForEdit(contactId);

	}

	// Hav to return string
	// update contact details by edit admin/updateContactDetails
	@RequestMapping(value = "admin/updateContactDetails", method = RequestMethod.POST)
	public @ResponseBody
	void updateContactDetails(@RequestBody ContactDetailsBean contactDetailsBean) {
		log.info("in updateContactDetails");
		adminMgmtService.updateContactDetails(contactDetailsBean);

	}

	// =========return string as data stored contactAPI
	@RequestMapping(value = "admin/updateHelpDetails", method = RequestMethod.POST)
	public @ResponseBody
	String saveContactsDetails(
			@RequestBody ContactDetailsBean contactDetailsBean) {
		log.info("in updateContactDetails");
		return adminMgmtService.updateContactDetails(contactDetailsBean);
	}

	/* to save new contact details....admin/saveContactDetails */
	@RequestMapping(value = "admin/saveContactDetails", method = RequestMethod.POST)
	public @ResponseBody
	void saveContactDetails(@RequestBody ContactDetailsBean contactDetailsBean) {
		log.info("in saveContactDetails  " + contactDetailsBean.toString());
		adminMgmtService.saveContactDetails(contactDetailsBean);
	}

	/* ChatTopic data */
	// chat_topic List NavigationListPage
	@RequestMapping(value = "admin/navigateToChatTopicList")
	public String navigateToChatTopicList() {
		log.info("we are in navigationToChatTopicList");
		return "admin/chatTopicView";
	}

	// chatTopicList method
	@RequestMapping(value = "admin/chatTopicList", method = RequestMethod.GET)
	public @ResponseBody
	List<ChatTopicBean> getChatTopicList(@RequestParam("eventId") Long eventId) {
		log.info("we are in chatTopicList " + eventId);
		List<ChatTopicBean> chatTopicList = adminMgmtService
				.getChatTopicList(eventId);
		log.info("size of List is" + chatTopicList.size());
		return chatTopicList;

	}

	// chat_topicNavigationPage
	@RequestMapping(value = "admin/navigateToCreateChatTopic")
	public String navigateToChatTopicCreate() {
		return "admin/chatTopicCreate";
	}

	// Chat_Topic save method
	@RequestMapping(value = "admin/saveChatTopic", method = RequestMethod.POST)
	public @ResponseBody void saveChatTopic(@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,@RequestParam("chatTopicName")String chatTopicName,@RequestParam("type")String type) {
		log.info("we are in chatTopic save method"+file.getOriginalFilename());
		adminMgmtService.saveChatTopic(eventId,file,chatTopicName,type);
	}

	// navigate to chatDetailsPage
	@RequestMapping(value = "admin/navigateChatDetails")
	public String navigateToChatDetails() {
		log.info("we are in navigate ChatViewDetils");
		return "admin/chatTopicDetails";
	}

	// Chat_topic Details method
	@RequestMapping(value = "admin/chatTopicDetails", method = RequestMethod.GET)
	public @ResponseBody
	ChatTopicBean getChatTopicDetails(
			@RequestParam("chatTopicId") Long chatTopicId) {
		log.info("we are in chatTopicDetalis" + chatTopicId);
		return adminMgmtService.getChatTopicDetails(chatTopicId);
	}

	// chat_topic Update method
	@RequestMapping(value = "admin/chatTopicUpdate", method = RequestMethod.POST)
	public @ResponseBody
	void chatTopicUpdate(@RequestBody ChatTopicBean chatTopicBean) {
		log.info("we are in chatTopicUpdate");
		adminMgmtService.chatTopicUpdate(chatTopicBean);
	}
	
	//update chatTopic details
	@RequestMapping(value = "admin/updateChatTopic", method = RequestMethod.POST)
	public @ResponseBody void updateChatTopic(@RequestParam("chatTopicId")Long chatTopicId, @RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam("eventId") Long eventId,@RequestParam("chatTopicName")String chatTopicName,@RequestParam("type")String type) {
		log.info("we are in chatTopic save method"+file.getOriginalFilename());
		adminMgmtService.updateChatTopic(chatTopicId,eventId,file,chatTopicName,type);
	}

	// chat_topic Delete method
	@RequestMapping(value = "admin/deleteChatTopic", method = RequestMethod.GET)
	public @ResponseBody
	void chatTopicDelete(@RequestParam("chatTopicId") Long chatTopicId) {
		log.info("we are in chatTopicDelete ");
		adminMgmtService.chatTopicDelete(chatTopicId);
	}

	// admin/ParticipantEventBeanList
	@RequestMapping(value = "admin/ParticipantEventBeanList", method = RequestMethod.GET)
	public @ResponseBody List<ParticipantEventBean> getParticipantEventBeanList(@RequestParam("eventId") Long eventId,@RequestParam("status") String status) {
			List<ParticipantEventBean> participantEventList = adminMgmtService
				.getParticipantEventBeanList(eventId, status);
		return participantEventList;
	}

	// participantEventBean
	@RequestMapping(value = "admin/eventParticipantSave", method = RequestMethod.POST)
	public @ResponseBody
	void eventParticipants(@RequestBody ParticipantEventBean participantEventBean) {
		log.info("in side save method");
		adminMgmtService.eventParticipantSave(participantEventBean);
	}
	
	
	

	// APIupdateParticipant.....to updateparticipant by passing bean with name..
	// ParticipantBean..with attributes..participantId and data(exclude
	// otp,registerId)..entity-participants
	@RequestMapping(value = "admin/updateParticipantDetails", method = RequestMethod.POST)
	public @ResponseBody
	String updateParticipantDetails(@RequestBody ParticipantBean participantBean) {
		log.info("in update Participant details.."+participantBean.getEmailId()+"---"+participantBean.getStatus());
		adminMgmtService.updateParticipant(participantBean);
		return "success";
	}

	// admin/QuestionAndAnswersView
	@RequestMapping(value = "admin/QuestionAndAnswersView")
	public String QuestionAndAnswersView() {
		log.info("navigate QuestionAndAnswersView page");
		return "admin/QuestionAndAnswersView";
	}

	// Get participants list..........admin/getParticipantsList
	@RequestMapping(value = "admin/getParticipantsList", method = RequestMethod.GET)
	public @ResponseBody
	List<ParticipantBean> getParticipantsList(
			@RequestParam("eventId") Long eventId) {
		log.info("in admin/getParticipantsList" + eventId);
		return adminMgmtService.getParticipantsList(eventId);
	}

	// go to admin/ViewParticipantAnswers page
	@RequestMapping(value = "admin/ViewParticipantAnswers")
	public String goToViewParticipantAnswers() {
		return "admin/ViewParticipantAnswers";
	}

	// to get the paricipant anwers...admin/getViewParticipantAnswers
	@RequestMapping(value = "admin/getViewParticipantAnswers", method = RequestMethod.GET)
	public @ResponseBody
	List<SurveyQuestionAnswerBean> getParticipantsAnswers(
			@RequestParam("eventId") Long eventId,
			@RequestParam("participantId") Long participantId) {
		// select sq.Question,sq.Answer,sqa.Participant_Answer from
		// survey_question sq,survey_question_answer sqa where
		// sqa.Participant_id=61 and sqa.Event_ID=14 and
		// sqa.Question_ID=sq.Question_ID;
		log.info("in admin/getViewParticipantAnswers--eventiD--" + eventId
				+ "--participantId..." + participantId);
		// create surveyQuestionAnswerBean wrto SurveyQuestionAnswer entity

		return adminMgmtService.getParticipantsAnswers(eventId, participantId);
		// return null;
	}

	// ===saveQuestion&Answer API by QId,EventId,ParticipantId,Answer

	@RequestMapping(value = "admin/saveQuestionAnswer", method = RequestMethod.POST)
	public @ResponseBody
	String saveQuestionAnswer(@RequestBody QuestionBean questionBean) {
		return adminMgmtService.saveSurveyQuestionAnswer(questionBean);

	}

	// ===============Q&A

	// ===========SOCIALMEDIA====

	// go to admin/SocialMedia page
	@RequestMapping(value = "admin/SocialMedia")
	public String goToSocialMedia() {
		return "admin/SocialMedia";
	}

	// goto admin/createSocialMedia
	@RequestMapping(value = "admin/createSocialMedia")
	public String goToSocialMediaCreate() {
		return "admin/CreateSocialMedia";
	}

	// to save socialMedia..
	@RequestMapping(value = "admin/saveSocialMedia", method = RequestMethod.POST)
	public @ResponseBody
	void saveSocialMedia(@RequestBody SocialMediaBean socialMediaBean) {
		log.info("in admin/saveSocialMedia.." + socialMediaBean.toString());
		adminMgmtService.saveSocialMedia(socialMediaBean);
	}

	// to get social media list
	// this can be used as API to list the SocialMedia
	@RequestMapping(value = "admin/getSocialMediaList", method = RequestMethod.GET)
	public @ResponseBody
	List<SocialMediaBean> getSocialMedialList(
			@RequestParam("eventId") Long eventId) {
		log.info("in getSocialMediaList.." + eventId);
		return adminMgmtService.getSocialMediaList(eventId);
		// return null;
	}

	// to edit the social media list...admin/editSocialMedia
	@RequestMapping(value = "admin/editSocialMedia")
	public String goToEditSocialMedia() {
		log.info("in admin/editSocialMedia--");
		return "admin/EditSocialMedia";
	}

	// to get admin/getSocialMediaForEdit
	@RequestMapping(value = "admin/getSocialMediaForEdit", method = RequestMethod.GET)
	public @ResponseBody
	SocialMediaBean getSocialMediaForEdit(
			@RequestParam("socialId") Long socialId) {
		log.info("admin/getSocialMediaForEdit===" + socialId);
		return adminMgmtService.getSocialMediaForEdit(socialId);
	}

	// admin/updateSocialMedia
	@RequestMapping(value = "admin/updateSocialMedia", method = RequestMethod.POST)
	public @ResponseBody
	void updateSocialMedia(@RequestBody SocialMediaBean socialMediaBean) {
		log.info("in admin/updateSocialMedia.." + socialMediaBean.getName());
		adminMgmtService.updateSocialMedia(socialMediaBean);
	}

	// To....admin/deleteSocialMedia
	@RequestMapping(value = "admin/deleteSocialMedia", method = RequestMethod.POST)
	public @ResponseBody
	void deleteSocialMedia(@RequestParam("socialId") Long socialId) {
		log.info("delete socialMedia..." + socialId);
		adminMgmtService.deleteSocialMedia(socialId);
	}

	
	// generate the QR CODE for paticipant
		@RequestMapping(value="admin/generateQRCode", method = RequestMethod.POST)
		public @ResponseBody void generateQRCode(@RequestBody InviteBean inviteBean) {

			log.info("in generateQR Code..");
			String myCodeText = inviteBean.getEventName() + ","
					+ inviteBean.getPhone() + "," + inviteBean.getFirstName() + ""
					+ inviteBean.getLastName();
			String filePath = WREConstants.RESOURCE_PATH + inviteBean.getEventId()
					+ WREConstants.FILE_SEPARATER + inviteBean.getParticipantId()
					+ WREConstants.FILE_SEPARATER + "QR.png";

			int size = 250;
			String fileType = "png";
			File myFile = new File(filePath);
			try {

				Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(
						EncodeHintType.class);
				hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

				// Now with zxing version 3.2.1 you could change border size (white
				// border size to just 1)
				hintMap.put(EncodeHintType.MARGIN, 1);  /*default = 4*/ 
				hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

				QRCodeWriter qrCodeWriter = new QRCodeWriter();
				BitMatrix byteMatrix = qrCodeWriter.encode(myCodeText,
						BarcodeFormat.QR_CODE, size, size, hintMap);
				int CrunchifyWidth = byteMatrix.getWidth();
				BufferedImage image = new BufferedImage(CrunchifyWidth,
						CrunchifyWidth, BufferedImage.TYPE_INT_RGB);
				image.createGraphics();

				Graphics2D graphics = (Graphics2D) image.getGraphics();
				graphics.setColor(Color.WHITE);
				graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
				graphics.setColor(Color.BLACK);

				for (int i = 0; i < CrunchifyWidth; i++) {
					for (int j = 0; j < CrunchifyWidth; j++) {
						if (byteMatrix.get(i, j)) {
							graphics.fillRect(i, j, 1, 1);
						}
					}
				}
				ImageIO.write(image, fileType, myFile);
			} catch (WriterException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("\n\nYou have successfully created QR Code.");
		}
		
	// ==========================================================

	// admin/networkingView

	@RequestMapping(value = "admin/networkingView")
	public String networkingView() {
		return "admin/networkingView";
	}

	// admin/networkingEdit
	@RequestMapping(value = "admin/networkingEdit")
	public String networkingEdit() {
		return "admin/networkingEdit";
	}

	// ParticipantBean edit
	@RequestMapping(value = "admin/participantEdit", method = RequestMethod.GET)
	public @ResponseBody
	ParticipantBean participantEdit(
			@RequestParam("participantId") Long participantId,
			@RequestParam("eventId") Long eventId) {
		ParticipantBean participantBean = adminMgmtService.participantEdit(
				participantId, eventId);
		return participantBean;

	}

	// updateParticipant
	@RequestMapping(value = "participant/update", method = RequestMethod.POST)
	public @ResponseBody
	void updateParticipants(@RequestBody ParticipantBean participantBean) {
		System.out.println("participantBean update"
				+ participantBean.getStatus());
		// adminMgmtService.updateParticipant(participantBean);
		adminMgmtService.updateParticipantDetails(participantBean);
	}

	// participantEventBean API
	@RequestMapping(value = "admin/eventParticipantStatusSave", method = RequestMethod.POST)
	public @ResponseBody
	String eventParticipantStatusSave(@RequestBody ParticipantEventBean participantEventBean) {
		log.info("in side save method");
		adminMgmtService.eventParticipantStatusSave(participantEventBean);
		String res = "suucess";
		return "{\"result\":\"" + res + "\"}";
	}

	@RequestMapping(value = "admin/getEventParticipantStatus", method = RequestMethod.GET)
	public @ResponseBody
	String getEventParticipantStatus(@RequestParam Long eventId,
			@RequestParam Long participantId) {

		log.info("sdfasdfasfss");
		return adminMgmtService.getEventParticipantStatus(eventId,
				participantId);

	}

	// participantQueriesSaveMethod
	@RequestMapping(value = "admin/participantQueriesSave", method = RequestMethod.POST)
	public @ResponseBody
	String participantQueriesSave(
			@RequestBody ParticipantQuriesBean participantQuriesBean) {
		log.info("we are in participantQueriesSave method");
		String result = adminMgmtService
				.participantQueriesSave(participantQuriesBean);
		return result;

	}
	
	@RequestMapping(value = "admin/imageUpload", method = RequestMethod.POST)
	 public @ResponseBody String imageUpload(@RequestBody GalaryBean galaryBean){
	  String filePath;
	  String result=null;
	
	  try {
	            // Decode String using Base64 Class
	            byte[] imageByteArray = Base64.decodeBase64(galaryBean.getEncodeString());
	            FileOutputStream imageOutFile;
	            // Write Image into File system - Make sure you update the path
	            filePath=WREConstants.RESOURCE_PATH+galaryBean.getEventId()+WREConstants.FILE_SEPARATER+galaryBean.getType();
	            File uploadfile=new File(filePath);
	            String name = galaryBean.getFileName();
	    			if (!uploadfile.exists()) {
	    				uploadfile.mkdirs();
	    			}
	    			// Create the file on server
	    			File serverFile = new File(uploadfile.getAbsolutePath() + File.separator
	    					+ name);
	            imageOutFile = new FileOutputStream(serverFile);

	            	    imageOutFile.write(imageByteArray);
	            imageOutFile.close();
	            adminMgmtService.saveGalary(galaryBean);
	            
	            result="success";
	            System.out.println("Image Successfully Stored");
	        } catch (FileNotFoundException fnfe) {
	            System.out.println("Image Path not found" + fnfe);
	        } catch (IOException ioe) {
	            System.out.println("Exception while converting the Image " + ioe);
	        }
	  
	 
	  return "{\"result\":\"" + result + "\"}";
	 }
	
	@RequestMapping(value="admin/eventImageUpload")
	public String eventImageUpload(){
		log.info("we are in Admin imageUpload");
		return "admin/eventImageUpload";
		
	}
	
     @RequestMapping(value = "admin/profileUpload", method = RequestMethod.POST)
	 public @ResponseBody String profileUpload(@RequestBody GalaryBean galaryBean){
	  String filePath;
	  String result=null;
	
	  try {
	            // Decode String using Base64 Class
	            byte[] imageByteArray = Base64.decodeBase64(galaryBean.getEncodeString());
	            FileOutputStream imageOutFile;
	            // Write Image into File system - Make sure you update the path
	            filePath=WREConstants.RESOURCE_PATH+galaryBean.getType()+WREConstants.FILE_SEPARATER+galaryBean.getParticipantId();
	            File uploadfile=new File(filePath);
	            String name = galaryBean.getFileName();
	    			if (!uploadfile.exists()) {
	    				uploadfile.mkdirs();
	    			}
	    			// Create the file on server
	    			File serverFile = new File(uploadfile.getAbsolutePath()+File.separator
	    					+ name);
	            imageOutFile = new FileOutputStream(serverFile);

	            	    imageOutFile.write(imageByteArray);
	            imageOutFile.close();
	            adminMgmtService.profileUpload(galaryBean.getParticipantId(),galaryBean.getFileName());
	            
	            result="success";
	            System.out.println("Image Successfully Stored");
	        } catch (FileNotFoundException fnfe) {
	            System.out.println("Image Path not found" + fnfe);
	        } catch (IOException ioe) {
	            System.out.println("Exception while converting the Image " + ioe);
	        }
	  
	 
	  return "{\"result\":\"" + result + "\"}";
	 }

	//OTP Generation Method 
	@RequestMapping(value="admin/generateOTP" ,method=RequestMethod.POST)
	public @ResponseBody String generateOTP(@RequestBody ParticipantBean participantBean){
		log.info("we are in generate OTP controller");
		String s = adminMgmtService.generateOTP(participantBean);
		return "{\"OTP\":\"" + s + "\"}";
		
	}
	
	//OTP Check Method 
		@RequestMapping(value="admin/checkOTP" ,method=RequestMethod.POST)
		public @ResponseBody String checkOTP(@RequestBody ParticipantBean participantBean){
			log.info("we are in generate OTP controller");
			String s = adminMgmtService.checkOTP(participantBean);
			return "{\"OTP\":\"" + s + "\"}";
			
		}
	
	
		//sending OTP method
		@RequestMapping(value="admin/sendOTP",method=RequestMethod.POST)
		public @ResponseBody String sendingOTP(@RequestBody ParticipantBean participantBean){
			log.info("we are in sending OTP Controller");
			 String s = adminMgmtService.sendingOTP(participantBean);
			return s;
		}
		
		/*//Get client details to display on the top of events List
		@RequestMapping(value="admin/getClientDetails",method=RequestMethod.GET)
		public @ResponseBody ClientBean getClientDetails(@RequestParam("eventId")Long eventId){
			return adminMgmtService.getClientDetails(eventId);
		}*/
		
   
    
 // admin/galleryList
 	@RequestMapping(value = "admin/galaryImageList")
 	public @ResponseBody
 	List<GalaryBean> galaryImageList(@RequestParam("eventId") Long eventId,@RequestParam("paticipantId") Long paticipantId,
 			@RequestParam("type") String type) {
 		log.info("in side galaryList method----" + eventId);
 		List<GalaryBean> galaryList = adminMgmtService
 				.galaryImageList(eventId, type,paticipantId);

 		return galaryList;
 	}
 	
 	@RequestMapping(value = "admin/galleryImageStatusSave", method = RequestMethod.POST)
	public @ResponseBody void galleryImageStatusSave(@RequestBody GalaryBean galaryBean) {
	adminMgmtService.galleryImageStatusSave(galaryBean);
	}


}
		
		

		
		




