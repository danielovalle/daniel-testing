package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	/*
	 * public static Result index() { //return
	 * ok(index.render("Your new application is ready.- Daniel Ovalle")); return
	 * ok("Hello world"); }
	 */

	public static Result index() {
		// return ok(index.render("Your new application is ready."));
		return redirect(routes.Application.tasks());
	}

	public static Result tasks() {
		return TODO;
	}

	public static Result newTask() {
		return TODO;
	}

	public static Result deleteTask(Long id) {
		return TODO;
	}

}