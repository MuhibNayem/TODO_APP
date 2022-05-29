package com.example.todoapp.View;

import com.example.todoapp.Backend.Data.ToDoList;
import com.example.todoapp.Backend.Service.TODO_service;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.Collection;

@Route("edit-TODO")
@CssImport("./Styles/Views/shared_view.css")
public class editTODO_view extends Div {

    Grid<ToDoList> grid = new Grid<>(ToDoList.class);
    static String name;

    TODO_service service;
    public editTODO_view(TODO_service service) {
        addClassName("editTodo");
        this.service=service;

        var item_name = new TextField("Title");
        item_name.setId("description-field");
        item_name.setPlaceholder("description here");
        item_name.setAutofocus(true);
        item_name.setClearButtonVisible(true);

        var description = new TextField("Description");
        description.setId("description-field");
        description.setPlaceholder("description here");
        description.setAutofocus(true);
        description.setClearButtonVisible(true);

        ComboBox<String> status = new ComboBox<>();
        status.setLabel("Status");
        status.setItems("Pending","processing","Completed");
        status.setValue("Pending");

        Button update = new Button("update");
        update.setId("updateBtn");
        grid.setId("edit-grid");
        add(
                new H2("Update TO-DO"),
                item_name,
                status,
                description,
                update,
                new H1(""),
                grid
        );
        configureGrid();
        updateGrid();


        update.addClickListener(clickEvent -> {
            String itemName = item_name.getValue() ;
            Notification.show(itemName);
            String descrp = description.getValue();
            String status_st = status.getValue();
            user_home_tableView.setUsername(name);
            Integer i = TODO_service.updateByUser(itemName,descrp,status_st,name);
            Notification.show(i.toString());
            Notification.show(itemName);
            UI.getCurrent().navigate(user_home_tableView.class);
        });

    }
    private void updateGrid() {
        grid.setItems(service.findAllTODOByUSERName(name));
    }

    private void configureGrid() {
        grid.addClassName("supervisor-grid");
        grid.setColumns("title", "description", "status", "createdate");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));
    }
    public static void setUsername(String username) {
        name = username;
    }
}
