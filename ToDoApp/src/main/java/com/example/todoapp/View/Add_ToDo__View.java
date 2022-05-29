package com.example.todoapp.View;

import com.example.todoapp.Backend.Data.ToDoList;
import com.example.todoapp.Backend.Data.User;
import com.example.todoapp.Backend.Service.TODO_service;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.List;

@Route("add-TODO")
@CssImport("./Styles/Views/shared_view.css")
public class Add_ToDo__View extends Div {
    static String name;
    public Add_ToDo__View() {
        setId("AddTODO-view");

        var item_name = new TextField("Item name");
        item_name.setPlaceholder("name here");
        item_name.setAutofocus(true);
        item_name.setClearButtonVisible(true);

        LocalDate localDate = LocalDate.now();
        DatePicker datePicker = new DatePicker("Select a date:");
        datePicker.setValue(localDate);
        datePicker.getValue().toString();

        var description = new TextField("Description");
        description.setId("description-field");
        description.setPlaceholder("description here");
        description.setAutofocus(true);
        description.setClearButtonVisible(true);

        ComboBox<String> status = new ComboBox<>();
        status.setLabel("Status");
        status.setItems("Pending","processing","Completed");
        status.setValue("Pending");



        Button add = new Button("ADD");
        add.setId("addBtn");

        add(
                new H2("Add TO-DO"),
                item_name,
                datePicker,
                status,
                description,
                add

        );



        add.addClickListener(clickEvent -> {
            String itemName = item_name.getValue();
            String descrp = description.getValue();
            String status_st = status.getValue();
            String date = datePicker.getValue().toString();
            user_home_tableView.setUsername(name);
            TODO_service.addByUser(itemName,descrp,status_st,date,name);
            UI.getCurrent().navigate(user_home_tableView.class);
        });

    }
    public static void setUsername(String username) {
        name = username;
    }
}
