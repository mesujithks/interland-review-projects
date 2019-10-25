package com.interland.OnlineCourse.websevice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.interland.OnlineCourse.dao.BatchDao;
import com.interland.OnlineCourse.model.User;

@RestController
@RequestMapping("API")
public class RESTWebService {

	@Autowired
	BatchDao dao;

	@RequestMapping(value = "users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<UserModel> getUserList() {
		List<User> users = dao.getUsers();
		Set<User> userSet = new HashSet<User>();
		for (User user : users)
			userSet.add(user);
		ArrayList<UserModel> res = new ArrayList<UserModel>();
		for (User user : userSet) {
			UserModel u = new UserModel();
			u.setId(user.getId());
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setMobile(user.getMobile());

			res.add(u);
		}
		return res;
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> getUser(@PathVariable("id") int id) {
		User user = dao.getStudent(id);
		ResponseEntity<UserModel> res;
		UserModel u = new UserModel();
		if(user!=null) {
			u.setId(user.getId());
			u.setName(user.getName());
			u.setEmail(user.getEmail());
			u.setMobile(user.getMobile());
			res = new ResponseEntity<UserModel>(u,HttpStatus.OK);
		}else res = new ResponseEntity<UserModel>(u,HttpStatus.NOT_FOUND);
		return res;
	}

	@RequestMapping(value = "users", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> addUser(@RequestBody UserModel user) {
		ResponseEntity<Void> res;
		User test = dao.getStudent(23);
		User curUser = new User();
		curUser.setName(user.getName());
		curUser.setEmail(user.getEmail());
		curUser.setMobile(user.getMobile());
		curUser.setDob(test.getDob());
		curUser.setGender(test.getGender());
		curUser.setPass(test.getPass());
		curUser.setType(test.getType());
		if(dao.addOrUpdate(curUser))
			res = new ResponseEntity<Void>(HttpStatus.CREATED);
		else res = new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		return res;
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateUser(@PathVariable("id") int id, @RequestBody UserModel user) {
		
		User curUser = dao.getStudent(id);
		ResponseEntity<Void> res;
		if(curUser!=null) {
			curUser.setName(user.getName());
			curUser.setEmail(user.getEmail());
			curUser.setMobile(user.getMobile());
			if(dao.addOrUpdate(curUser))
				res = new ResponseEntity<Void>(HttpStatus.OK);
			else res = new ResponseEntity<Void>(HttpStatus.UNPROCESSABLE_ENTITY);
		}else res = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return res;
	}

	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateUser(@PathVariable("id") int id) {
		ResponseEntity<Void> res;
		if(dao.delete(id))
			res = new ResponseEntity<Void>(HttpStatus.OK);
		else res = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		return res;
	}

}
