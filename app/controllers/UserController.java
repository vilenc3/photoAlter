package controllers;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.filters.csrf.CSRF;
import views.html.*;

import views.html.register;

import javax.inject.Inject;


//import views.html.index;

public class UserController extends Controller{
    @Inject
    FormFactory formFactory;

    public Result create(){
        Form<User> registerForm = formFactory.form(User.class);
        return ok(register.render(registerForm));
    }

    public Result save(){
        Form<User> registerForm = formFactory.form(User.class).bindFromRequest();
        User user = registerForm.get();
        user.add(user);
        return redirect(routes.HomeController.home());
    }

    public Result login(){
        Form<User> loginForm = formFactory.form(User.class);
        return ok(login.render(loginForm));
    }

    public Result log_me_in(){
        Form<User> loginForm = formFactory.form(User.class).bindFromRequest();
        User user = loginForm.get();
        /* */
        if (User.users.isEmpty()){return redirect(routes.HomeController.home());}
        else {
            for (User user1 : User.users) {
                if (user1.email.equals(user.email)) {
                    if (user1.password.equals(user.password)) {
                        return redirect(routes.BooksController.index());
                    }
                }
            }
        }
        /* * /
        if (user.email.equals("user@pa.pl")){
            return redirect(routes.BooksController.index());
        }
        /* */
        return redirect(routes.HomeController.home());
    }

}


