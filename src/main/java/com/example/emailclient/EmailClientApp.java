package com.example.emailclient;

import com.example.emailclient.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EmailClientApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ViewFactory viewFactory = new ViewFactory(new EmailManager(), new Stage());
        viewFactory.showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}