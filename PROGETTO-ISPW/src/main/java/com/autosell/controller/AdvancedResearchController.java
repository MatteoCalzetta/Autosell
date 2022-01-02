package com.autosell.controller;

import com.autosell.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class AdvancedResearchController {

    @FXML
    private Button buttonAutosell;

    Main main = Main.getInstance();

    @FXML
    public void setHomepage(ActionEvent event) throws IOException {
        main.changeScene("Homepage.fxml");
    }

}
