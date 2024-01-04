package com.example.emailclient.controller;

import com.example.emailclient.EmailManager;
import com.example.emailclient.view.ViewFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import javafx.scene.web.WebView;

/**
 * @author Daniele Asteggiante
 */
public class MainController extends BaseController {

    @FXML
    private MenuItem mbOpzioni;

    @FXML
    private TableView<?> tvEmail;

    @FXML
    private WebView wvEmailBody;

    public MainController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    void opzioniAction(ActionEvent event) {

    }
}
