package com.example.emailclient.controller;

import com.example.emailclient.EmailManager;
import com.example.emailclient.model.EmailAccount;
import com.example.emailclient.services.EmailLoginResult;
import com.example.emailclient.services.LoginService;
import com.example.emailclient.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * @author Daniele Asteggiante
 */
public class LoginController extends BaseController {
    @FXML
    private AnchorPane apBg;

    @FXML
    private Button btLogin;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lbError;


    public LoginController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void loginAction(MouseEvent event) {
        if(fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(tfEmail.getText(), tfPassword.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            EmailLoginResult emailLoginResult = loginService.login();
            switch (emailLoginResult) {
                case SUCCESS:
                    System.out.println("login ok");
                    viewFactory.showMainWindow();
                    return;
                case FAILED_BY_CREDENTIALS:
                    lbError.setText("Invalid credentials");
                    return;
                case FAILED_BY_NETWORK:
                    lbError.setText("Network error");
                    return;
                case FAILED_BY_UNEXPECTED_ERROR:
                    lbError.setText("Unexpected error");
                    return;
                default:
                    return;
            }
        }

    }

    private boolean fieldsAreValid() {
        if(tfEmail.getText().isEmpty()) {
            lbError.setText("Please fill the email field");
            return false;
        }
        if(tfPassword.getText().isEmpty()) {
            lbError.setText("Please fill the password field");
            return false;
        }
        return true;
    }
}
