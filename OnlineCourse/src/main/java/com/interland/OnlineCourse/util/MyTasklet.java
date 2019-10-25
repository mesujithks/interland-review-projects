package com.interland.OnlineCourse.util;

import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.interland.OnlineCourse.dao.BatchDao;
import com.interland.OnlineCourse.model.User;

public class MyTasklet implements Tasklet {

	@Autowired
	BatchDao batchDao;

	@Autowired
	JavaMailSender mailSenderObj;

	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		
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
					        mimeMsgHelperObj.setText("Hi "+name+",\nWelcome to Online Course Portal.");
					        mimeMsgHelperObj.setSubject("Welcome");					    
					  }
					});
					user.setSend_mail(1);
					if(batchDao.setUserSendMail(user))
						System.out.println("Mail Send Success");
				}
			} else System.out.println("No new users found!");
		} catch (Exception e) {
			System.out.println("Inside MyTasklet.execute(): "+e);
		}
		return RepeatStatus.FINISHED;
	}
}
