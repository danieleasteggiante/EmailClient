module com.example.emailclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.web;

    requires java.mail;
    requires activation;

    opens com.example.emailclient to javafx.fxml;
    exports com.example.emailclient;
    exports com.example.emailclient.controller;
    opens com.example.emailclient.controller to javafx.fxml;
    exports com.example.emailclient.view;
    opens com.example.emailclient.view to javafx.fxml;
}