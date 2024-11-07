module com.sergio.week8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sergio.week8 to javafx.fxml;
    exports com.sergio.week8;
}