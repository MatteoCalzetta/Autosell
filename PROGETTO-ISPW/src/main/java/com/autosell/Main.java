package com.autosell;

import java.io.IOException;
import java.net.URL;

import com.autosell.model.Seller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SuppressWarnings("ConstantConditions")
public class Main extends Application {

    private static FXMLLoader loader = new FXMLLoader();

    public static Stage stg;

    private Seller loggedUser = new Seller();
    public Seller getLoggedUser() {
        return loggedUser;
    }
    public void setLoggedUser(Seller loggedUser) {
        this.loggedUser = loggedUser;
    }

    public static Main INSTANCE;

    public synchronized static Main getInstance() {
        if (null==INSTANCE) {
            INSTANCE = new Main();
        }
        return INSTANCE;
    }

    @FXML
    public void start(Stage primaryStage) throws IOException {

        URL fxmlURL = getClass().getResource("/com/autosell/controller/Homepage.fxml");
        Parent root = FXMLLoader.load(fxmlURL);
        stg = primaryStage;
        stg.setResizable(false);
        stg.setTitle("Autosell");
        stg.setScene(new Scene(root,1280, 720));
        stg.show();

    }

    public void changeScene(String fxml) throws IOException {
            URL finalFxml = getClass().getResource("/com/autosell/controller/" + fxml);
            Parent root = FXMLLoader.load(finalFxml);
            stg.setScene(new Scene(root, 1280, 720));
    }

    public static void main(String[] args) { launch(); }
}



