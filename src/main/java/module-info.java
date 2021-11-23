module com.koby.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.koby.schoolmanager to javafx.fxml;
    exports com.koby.schoolmanager;
}