package controllers;




import models.Evento;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class EventoController extends Controller{
	 private static final Form<Evento> eventoForm = Form.form(Evento.class);
	 
	public static Result novoEvento(){
		return ok(views.html.evento_form.render(eventoForm));
	}
	
	public static Result editar(){
		return TODO;
	}
	
	public static Result salvar(){
		Form<Evento> form = eventoForm.bindFromRequest();
		Evento evento = form.get();
		evento.save();
		flash("sucesso","Evento gravado com sucesso");
		return ok(index.render());
	}

}
