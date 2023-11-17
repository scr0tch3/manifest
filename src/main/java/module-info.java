module com.example.casino_script {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.casino_script to javafx.fxml;
    exports com.example.casino_script;
}