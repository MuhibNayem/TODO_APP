package com.example.todoapp.View;

import com.example.todoapp.Backend.Data.Supervisor;
import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.Service.Supervisor_Service;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("supervisor-registration")
@CssImport("./Styles/Views/shared_view.css")
public class Supervisor_Registration_View extends Div {
    public Supervisor_Registration_View(Supervisor_Service service) {
        setId("registration-view");

        var name = new TextField("Name");
        name.setPlaceholder("name here");
        name.setHelperText("Provide Full name");
        name.setAutofocus(true);
        name.setClearButtonVisible(true);

        var username = new TextField("Username");
        username.setPlaceholder("username here");
        username.setAutofocus(true);
        username.setClearButtonVisible(true);

        var password = new PasswordField("Password");
        password.setPlaceholder("password here");
        password.setAutofocus(true);
        password.setClearButtonVisible(true);


        Button registration_Btn = new Button("Register");
        registration_Btn.setId("RegisterBtn");

        add(
                new H1("Welcome"),
                new H4("Registration for supervisor"),
                name,
                username,
                password,
                registration_Btn

        );
        registration_Btn.addClickListener(clickEvent -> {
            try {
                String get_name = name.getValue().toString();
                String get_username = username.getValue().toString();
                String get_pssword = password.getValue().toString();
                Supervisor supervisor = new Supervisor(get_name,get_username,get_pssword);
                service.add(supervisor);
                Notification.show("Registration Successful");
                UI.getCurrent().navigate(Login_View.class);
            }catch (Exception e){
                Notification.show("there is problem: "+e);
            }

        });
    }
}
