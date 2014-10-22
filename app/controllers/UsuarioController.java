package controllers;

import static play.data.Form.form;

import java.util.List;

import models.Usuario;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.lista_usuario;
import views.html.usuario_form;

public class UsuarioController extends Controller {
	
	private static boolean save() {
		Form<Usuario> bindFromRequest = form(Usuario.class).bindFromRequest();
		
		if (bindFromRequest.hasErrors()) {	
			flash("erro", "Foram identificados problemas no cadastro");
			return false;
		} else {
			Usuario usuario = bindFromRequest.get();
			usuario.save();
			flash("sucesso", "Logado com: " + form().bindFromRequest().get("username") 
					+ " Senha: " + form().bindFromRequest().get("password"));
			return true;
		}
	}
	
	private static void edit(Integer id) {
		Usuario u = Usuario.find.byId(id);
		Form<Usuario> bindFromRequest = form(Usuario.class).bindFromRequest();
		
		Usuario f = bindFromRequest.get();
		u.setUsername(f.getUsername());
		u.setPassword(f.getPassword());
		u.update();
	}
	
	private static List<Usuario> getListUsuario() {
		List<Usuario> usuarios = Usuario.find.all();
		return usuarios;
	}
	
	public static Result doSave() {
		if (save()) {
			return ok(index.render());
		} else {
			return ok(usuario_form.render(null));
		}
	}

	public static Result newUser() {
		return ok(usuario_form.render(null));
	}
		
	public static Result listUsers() {
		return ok(lista_usuario.render(getListUsuario()));
	}

	public static Result showUser(Integer id) {
		Usuario u = Usuario.find.byId(id);
		return ok(usuario_form.render(u));
	}
	
	public static Result doEditUser(Integer id) {
		edit(id);
		return ok(lista_usuario.render(getListUsuario()));
	}
	
}
