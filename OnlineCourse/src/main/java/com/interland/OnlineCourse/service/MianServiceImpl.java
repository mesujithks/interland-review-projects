package com.interland.OnlineCourse.service;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interland.OnlineCourse.dao.BatchDao;
import com.interland.OnlineCourse.dao.UserDAO;
import com.interland.OnlineCourse.dto.UserLogin;
import com.interland.OnlineCourse.dto.UserRegister;
import com.interland.OnlineCourse.model.User;
import com.interland.OnlineCourse.service.MianService;
import com.interland.OnlineCourse.util.Encrypt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
 

@Service
public class MianServiceImpl implements MianService {

	@Autowired
	UserDAO dao;

	@Autowired
	BatchDao batchDao;

	@Autowired
	JavaMailSender mailSenderObj;

	private static final Logger LOGGER = LogManager.getLogger(MianServiceImpl.class.getName());

	public HashMap<String, String> registerService(UserRegister userRegister) {
		User user = new User();
		HashMap<String, String> response = new HashMap<String, String>();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // Strength set as 12

		try {
			user.setName(userRegister.getName());
			user.setEmail(userRegister.getEmail());
			user.setPass(Encrypt.getSecurePassword(userRegister.getPassword()));
			user.setType(userRegister.getType());
			user.setMobile(userRegister.getMobile());
			user.setGender(userRegister.getGender());
			user.setImage("/resources/upload/images/avatar.png");
			user.setDob(new SimpleDateFormat("yyyy-MM-dd").parse(userRegister.getDob()));

			System.out.println(encoder.encode(userRegister.getPassword()));
			if (dao.addOrUpdate(user)) {
				response.put("flag", "true");
				response.put("message", "Success");
			} else {
				response.put("flag", "false");
				response.put("message", "Error");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return response;
	}

	public User loginService(UserLogin userLogin) {
		User user = null;
		try {
			userLogin.setPassword(Encrypt.getSecurePassword(userLogin.getPassword()));
			System.out.println(userLogin);
			user = dao.getLogin(userLogin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	//@Scheduled(cron = "*/10000 * * * * *")
	public void mailShcedule() {
		LOGGER.debug("Debug Message Logged !!!");
		try {
			List<User> newUsers = batchDao.getNewUsers();
			if (newUsers != null) {
				for (User user : newUsers) {
					final String email = user.getEmail();
					final String name = user.getName();
					mailSenderObj.send(new MimeMessagePreparator() {
						public void prepare(MimeMessage mimeMessage) throws Exception {

							MimeMessageHelper mimeMsgHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
							mimeMsgHelperObj.setTo(email);
							mimeMsgHelperObj.setFrom("projectemail0007@gmail.com");
							mimeMsgHelperObj.setText("Hi " + name + ",\nWelcome to Online Course Portal.");
							mimeMsgHelperObj.setSubject("Welcome");
						}
					});
					user.setSend_mail(1);
					if (batchDao.setUserSendMail(user))
						LOGGER.info("Mail Send Success");
				}
			} else
				System.out.println("No new users found!");
		} catch (Exception e) {
	        LOGGER.error("Inside MyTasklet.execute(): ", e);
		}
	}

}
