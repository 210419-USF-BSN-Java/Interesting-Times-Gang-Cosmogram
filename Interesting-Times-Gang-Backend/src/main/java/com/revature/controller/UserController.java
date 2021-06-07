package com.revature.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.User;
import com.revature.service.UserService;

/**
 * 
 * @author teresafitzgerald
 *
 */
@RestController
@RequestMapping(value = "/user")
@CrossOrigin(origins = "*")
public class UserController {

	private UserService uServ;

	@Autowired
	public UserController(UserService serv) {
		this.uServ = serv;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<User> registerUser(@RequestBody LinkedHashMap<String, String> uMap) {
		String roleIdStr = uMap.get("roleId");
		long roleId;
		if ((roleIdStr == null) || roleIdStr.trim().equals("")) {
			return new ResponseEntity<User>(new User(), HttpStatus.OK);
		} else {
			roleId = Long.parseLong(roleIdStr);
		}
		User user = uServ.registerUser(uMap.get("username"), uMap.get("password"), uMap.get("firstName"),
				uMap.get("lastName"), Long.parseLong(uMap.get("roleId")));
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<User> loginUser(@RequestBody LinkedHashMap<String, String> uMap, HttpServletRequest request) {
		User user = uServ.loginUsername(uMap.get("username"), uMap.get("password"));
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@PostMapping(value = "/logout")
	public ResponseEntity<String> logoutUser(@RequestBody LinkedHashMap<String, String> uMap) {
		boolean result = uServ.logoutUsername(uMap.get("username"));
		return new ResponseEntity<String>(result + "", HttpStatus.OK);
	}

	@GetMapping(value = "/loggedOn")
	public ResponseEntity<List<User>> loggedOn() {
		List<User> uList = uServ.getLoggedOnUsers();
		return new ResponseEntity<List<User>>(uList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/view-info")
	public ResponseEntity<User> searchUser(HttpServletRequest request) {

//	public ResponseEntity<User> searchUser(@RequestBody LinkedHashMap<String, String> uMap) {
		// User sessionUser = uServ.findUserSession(uMap.get("loggedInUsername"),
		// uMap.get("sessionToken"));
//		if (sessionUser == null) {
//			return null;
//		}
//		User searchedUser = uServ.searchUsers(uMap.get("searchUsername"));
//		return new ResponseEntity<User>(user, HttpStatus.OK);
//		System.out.println("View info - header: " + request.getHeader("Authorization"));
		String username = request.getHeader("Authorization");
		User user = uServ.searchUsers(username);
		return new ResponseEntity<User>(user, HttpStatus.OK);

	}
	
	@PostMapping(value = "/update-info")
	public ResponseEntity<String> updateUser(@RequestBody LinkedHashMap<String, String> uMap) {
		String roleIdStr = uMap.get("roleId");
		long roleId;
		if ((roleIdStr == null) || roleIdStr.trim().equals("")) {
			String message = "Role Id is required.";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			roleId = Long.parseLong(roleIdStr);
		}

		String message = uServ.updateUser(uMap.get("username"), uMap.get("password"), uMap.get("firstName"),
				uMap.get("lastName"), roleId);

		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}
