package com.example.todoapp.View;

import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.Service.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.List;

@Route("login")
@CssImport("./Styles/Views/shared_view.css")
public class Login_View extends Div {
    String UserName;
    public Login_View(UserService service) {
        setId("login-view");

        var username = new TextField("Username");
        username.setPlaceholder("username here");
        username.setAutofocus(true);
        username.setClearButtonVisible(true);

        var password = new PasswordField("Password");
        password.setPlaceholder("password here");
        password.setAutofocus(true);
        password.setClearButtonVisible(true);


        Button login_Btn = new Button("Login");
        login_Btn.setId("LoginBtn");

        add(
                new H1("Login"),
                username,
                password,
                login_Btn

        );
        login_Btn.addClickListener(clickEvent -> {
            UserName =  username.getValue().toString();
            String pass = password.getValue().toString();
            List<String> userinfo = service.validateUser(UserName,pass);
            List<String> admininfo = service.validateAdmin(UserName,pass);

            if (userinfo.isEmpty() && admininfo.isEmpty()){
                Notification.show("Invalid user!!");
            }
            if(userinfo.isEmpty() && !admininfo.isEmpty()){
                supervisor_home_TableView.setUsername(UserName);
                UI.getCurrent().navigate(supervisor_home_TableView.class);
            }
            if (!userinfo.isEmpty() && admininfo.isEmpty()){
                user_home_tableView.setUsername(UserName);
                UI.getCurrent().navigate(user_home_tableView.class);

            }

        });


    }
}

