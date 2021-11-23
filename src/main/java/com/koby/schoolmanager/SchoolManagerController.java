package com.koby.schoolmanager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SchoolManagerController implements Initializable {

    //Student
    @FXML
    public TableView<Students> studentTable;
    @FXML
    public TableColumn<Students, Integer> studentIDCol;
    @FXML
    public TableColumn<Students, String> studentNameCol;
    @FXML
    public TableColumn<Students, String> studentEmailCol;
    @FXML
    public TableColumn<Students, String> studentGradeCol;
    @FXML
    public TableColumn<Students, Double> studentGPACol;
    @FXML
    public TextField studentSearch;
    ObservableList<Students> studentList = FXCollections.observableArrayList();

    //Employee
    @FXML
    public TableView<Employee> employeeTable;
    @FXML
    public TableColumn<Employee, Integer> employeeIDCol;
    @FXML
    public TableColumn<Employee, String> employeeNameCol;
    @FXML
    public TableColumn<Employee, String> employeeEmailCol;
    @FXML
    public TableColumn<Employee, String> employeeJobCol;
    @FXML
    public TextField employeeSearch;
    ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Prevents Reordering
        studentIDCol.setReorderable(false);
        studentNameCol.setReorderable(false);
        studentEmailCol.setReorderable(false);
        studentGradeCol.setReorderable(false);
        studentGPACol.setReorderable(false);
        employeeIDCol.setReorderable(false);
        employeeNameCol.setReorderable(false);
        employeeEmailCol.setReorderable(false);
        employeeJobCol.setReorderable(false);

        //Prevents Resizing
        studentIDCol.setResizable(false);
        studentNameCol.setResizable(false);
        studentEmailCol.setResizable(false);
        studentGradeCol.setResizable(false);
        studentGPACol.setResizable(false);
        employeeIDCol.setResizable(false);
        employeeNameCol.setResizable(false);
        employeeEmailCol.setResizable(false);
        employeeJobCol.setResizable(false);

        //Student Table
        studentIDCol.setCellValueFactory(new PropertyValueFactory<Students, Integer>("id"));
        studentNameCol.setCellValueFactory(new PropertyValueFactory<Students, String>("name"));
        studentEmailCol.setCellValueFactory(new PropertyValueFactory<Students, String>("email"));
        studentGradeCol.setCellValueFactory(new PropertyValueFactory<Students, String>("grade"));
        studentGPACol.setCellValueFactory(new PropertyValueFactory<Students, Double>("gpa"));

        studentTable.setItems(studentList);

        //Employee Table
        employeeIDCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        employeeNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        employeeEmailCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("email"));
        employeeJobCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("job"));

        employeeTable.setItems(employeeList);


        //Student Table Filter
        FilteredList<Students> studentData = new FilteredList<>(studentList, b -> true);
        studentSearch.textProperty().addListener((observable, oldValue, newValue) ->{
            studentData.setPredicate(Students -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Students.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if(Students.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if(String.valueOf(Students.getId()).contains(lowerCaseFilter)){
                    return true;
                }
                else if(String.valueOf(Students.getGpa()).contains(lowerCaseFilter)){
                    return true;
                } else if (Students.getGrade().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else {return false;}
            });
        });

        SortedList<Students> sortedStudentList = new SortedList<>(studentData);
        sortedStudentList.comparatorProperty().bind(studentTable.comparatorProperty());
        studentTable.setItems(sortedStudentList);

        //Employee Table Filter
        FilteredList<Employee> employeeData = new FilteredList<>(employeeList, b -> true);
        employeeSearch.textProperty().addListener((observable, oldValue, newValue) ->{
            employeeData.setPredicate(Employee -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (Employee.getName().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if(Employee.getEmail().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else if(String.valueOf(Employee.getId()).contains(lowerCaseFilter)){
                    return true;
                }
                else if(Employee.getJob().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }
                else {return false;}
            });
        });

        SortedList<Employee> sortedEmployeeList = new SortedList<>(employeeData);
        sortedEmployeeList.comparatorProperty().bind(employeeTable.comparatorProperty());
        employeeTable.setItems(sortedEmployeeList);
    }

    public void addStudent() throws IOException {
        Students s = AddStudentController.display();
        studentList.add(s);
    }

    public void removeStudent(){
        studentTable.getItems().removeAll(
                studentTable.getSelectionModel().getSelectedItems()
        );
    }

    public void addEmployee() throws IOException {
        Employee e = AddEmployeeController.display();
        employeeList.add(e);
    }

    public void removeEmployee() {
        employeeTable.getItems().removeAll(
                employeeTable.getSelectionModel().getSelectedItems()
        );
    }
}