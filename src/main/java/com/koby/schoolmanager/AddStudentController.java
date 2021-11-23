package com.koby.schoolmanager;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class AddStudentController {
    public static Students s;
    @FXML
    public Button addStudentDoneBtn;
    @FXML
    public TextField addStudentName;
    @FXML
    public  TextField addStudentGrade;
    @FXML
    public TextField addStudentGPA;
    public static Stage window = new Stage();

    public static Students display() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AddStudentController.fxml"));
        window = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Student");
        window.showAndWait();
        return s;
    }

    public void createStudent(){
        assert(addStudentName.getText() != null && addStudentGrade.getText() != null && (Double.parseDouble(addStudentGPA.getText()) >= 0 || Double.parseDouble(addStudentGPA.getText()) <= 4.0));
        String name = addStudentName.getText();
        String grade = addStudentGrade.getText();
        double gpa = Double.parseDouble(addStudentGPA.getText());
        s = new Students(name, grade, gpa);
        window.close();

    }

    public void closeWindow() {
        window.close();
    }
}
