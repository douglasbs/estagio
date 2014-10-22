package controllers;

import play.mvc.Controller;
import play.mvc.Result;
//teste
public class Application extends Controller {

    public static Result index() {
    	flash("sucesso", "");
        return ok(views.html.index.render());
    }
    
    public static Result teste(){
    	return TODO;
    }

}
