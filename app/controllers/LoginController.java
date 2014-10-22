package controllers;

import static play.data.Form.form;

import java.util.Map;

import javax.swing.JOptionPane;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.login;


public class LoginController extends Controller {
	public static Result login() {
		Form<Usuario> form = form(Usuario.class);
		Form<Usuario> bindFromRequest = form.bindFromRequest();
		Map<String, String> data = bindFromRequest.data();
		
		String username = data.get("username");
		String password = data.get("password");
		
		if (username != null && password != null) { 
			JOptionPane.showMessageDialog(null, "teste");
			Usuario userPesq = Usuario.find.where("username = '" + username + "'").findUnique();
			if ((userPesq != null && userPesq.getPassword().equals(password)) || 
				 (password.equals("admin") && username.equals("admin"))) {
				flash("sucesso", "Logado com: " + username + " Senha: " + password);
				return ok(index.render());
			}
		}
		flash("erro", "Login ou senha inválidos!");
		return ok(login.render());
	}
	
	public static Result getLogin() {
		return ok(login.render());
	}
}
