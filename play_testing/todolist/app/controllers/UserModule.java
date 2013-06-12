package controllers;

import java.util.Arrays;

import models.User;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class UserModule extends Controller {
	
	private static Form<User> userForm = form(User.class);

	public static Result show() {

		User u = new User();
		u.setFirstName("daniel");
		u.setLastName("ovalle");
		u.setEmail("daniel@ovalleingenieros.com");
		u.setItems(Arrays.asList("a", "b", "c"));

		return ok(views.html.test1.render(u));
	}

	public static Result page1() {

		return ok(views.html.page1.render(userForm));
	}

}
