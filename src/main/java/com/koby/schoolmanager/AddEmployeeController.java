package com.koby.schoolmanager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddEmployeeController {
    public static Employee e;
    public static Stage window = new Stage();
    @FXML
    public TextField employeeNameTF;
    @FXML
    public TextField employeeJobTF;


    public static Employee display() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddEmployeeController.fxml"));
        window = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Student");
        window.showAndWait();
        return e;
    }

    public void createEmployee() {
        assert(employeeNameTF.getText() != null && employeeJobTF.getText() != null);
        String name = employeeNameTF.getText();
        String job = employeeJobTF.getText();

        e = new Employee(name, job);
        window.close();
    }

    public void closeWindow() {
        window.close();
    }
}
