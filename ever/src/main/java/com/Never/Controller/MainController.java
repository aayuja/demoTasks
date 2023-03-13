package com.Never.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Never.Entity.Password;
import com.Never.Entity.User;
import com.Never.dao.UserRepo;
import com.Never.service.userService;

@Controller
public class MainController {

	@Autowired
	userService usi;

	@Autowired
	UserRepo urp;

	// Hit Login Form
	@RequestMapping("/openLoginForm")
	public String home() {
		return "LoginForm";

	}

	// Hit Registration Form
	@RequestMapping("/openUserForm")
	public String ground() {
		System.out.println("ground");
		return "RegistrationForm";
	}

	// Store User data
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String userRegis(@ModelAttribute User user) {
		usi.build(user);
		System.out.println("data saved Succfully!!!");
		return "LoginForm";

	}

	// store User Password
	@RequestMapping(value = "/storePass", method = RequestMethod.POST)
	public String passwordCheck(@ModelAttribute Password passw) {
		System.out.println(passw);
		usi.buildPass(passw);

		return "house";
	}

	// Hit Registration Form
	@RequestMapping("/gro")
	public String ground(Model m) {
		List<User> data = usi.getAllData();
		m.addAttribute("data", data);
		return "viewData";
	}

	// login api
	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public String userLogin(@RequestParam("email") String email, @RequestParam("password") String password, Model m) {

		if (urp.existsByEmailAndPassword(email, password)) {
			List<User> data = usi.getAllData();
			m.addAttribute("data", data);
			return "viewData";
		} else {
			return "LoginForm";
		}

	}
}
