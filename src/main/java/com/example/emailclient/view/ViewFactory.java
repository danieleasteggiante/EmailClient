package com.example.emailclient.view;

import com.example.emailclient.EmailManager;
import com.example.emailclient.controller.BaseController;
import com.example.emailclient.controller.LoginController;
import com.example.emailclient.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Daniele Asteggiante
 */
public class ViewFactory {
    EmailManager emailManager;
    Stage stage;
    public ViewFactory(EmailManager emailManager, Stage stage) {
        this.emailManager = emailManager;
        this.stage = stage;
    }

    public void showLoginWindow() throws IOException {
        BaseController controller = new LoginController(emailManager, this, "login.fxml");
        createComponent(stage, controller);
    }
    public void showMainWindow() {
        BaseController controller = new MainController(emailManager, this, "main.fxml");
    }

    public void createComponent(Stage stage, BaseController controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(controller.getFxmlName()));
        fxmlLoader.setController(controller);
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
