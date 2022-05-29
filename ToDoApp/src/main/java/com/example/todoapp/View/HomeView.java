package com.example.todoapp.View;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
@PageTitle("home")
@CssImport("./Styles/Views/homeView.css")
public class HomeView extends Div {
    public HomeView() {
        setId("home-view");

        RouterLink link_supervisor = new RouterLink("Supervisor Registration", Supervisor_Registration_View.class);
        RouterLink link_user = new RouterLink("User Registration", User_Registration_View.class);
        RouterLink link_login = new RouterLink("Login", Login_View.class);
        link_user.setId("link-user");
        link_supervisor.setId("link-supervisor");
        link_login.setId("link-login");
        H2 welcome_text = new H2("Welcome to Muggle Technology");
        welcome_text.setId("welcome-text");
        add(
                welcome_text,
                link_supervisor,
                link_user,
                link_login
        );
    }
}
