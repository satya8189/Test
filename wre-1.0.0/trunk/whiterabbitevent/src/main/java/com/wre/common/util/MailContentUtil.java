package com.wre.common.util;



public class MailContentUtil {
	
	public static String adminCreateMail(String email,String password){
		
		return "<html>"
				+"<head>"
				+"<title> Admin Mail</title>"
				+"</head>"
				+"<body style='font-family: sans-serif;font-size: 15px;margin: auto;padding: 0px;'>"
				+"<div style='border: 1px solid #ccc;padding-bottom: 10px;'>"
				+"<div style='padding: 15px;background-color: #52bad5;color: #fff;text-align: center;font-size: 20px;'>"
				+"Login Details"
				+"</div>"
				+"<div style='padding: 15px;'>"
				+"<span>Hi "+email+",</span>"
				+"<p>Your assigned as <q> Admin </q> in One of the Client In WhiteRabbitEvent."
				+"below are the login credentials."
				+"<ul style='list-style: none;line-height: 1.8;'>"
				+"<li style='color: rgb(26, 0, 255);'>User Name : "+email+"</li>"    
				+"<li style='color: rgb(26, 0, 255);'>Password : "+password+"</li>"    
				+"</ul>"	
				+"</p>"
				+"<p>Click <a style='color: rgb(26, 0, 255);' href='"+WREConstants.LOGIN_URL+"'>here</a> to goto login page.</p>"
				+"</div>"
				+"</div>" 
				+"</body>"
				+"</html>";
	}

}
