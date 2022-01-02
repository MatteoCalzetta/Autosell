package com.autosell.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

import java.io.IOException;

import com.autosell.Main;

public class InsertController {

    static Main main = Main.getInstance();

    @FXML
    private Button autosell;

    @FXML
    private Button buttonConfirmButton;

    @FXML
    private MenuButton menuButtonBody;

    @FXML
    private MenuButton menuButtonBrand;

    @FXML
    private MenuButton menuButtonFuel;

    @FXML
    private MenuButton menuButtonGear;

    @FXML
    private MenuButton menuButtonNSeats;

    @FXML
    private MenuButton menuButtonNdoors;

    @FXML
    private MenuButton menuButtonState;

    @FXML
    private MenuItem menuItemAlfa;

    @FXML
    private MenuItem menuItemAudi;

    @FXML
    private MenuItem menuItemAutomatico;

    @FXML
    private MenuItem menuItemBMW;

    @FXML
    private MenuItem menuItemBenzina;

    @FXML
    private MenuItem menuItemBerlina;

    @FXML
    private MenuItem menuItemCoupé;

    @FXML
    private MenuItem menuItemDiesel;

    @FXML
    private MenuItem menuItemElettrico;

    @FXML
    private MenuItem menuItemHatchback;

    @FXML
    private MenuItem menuItemManuale;

    @FXML
    private MenuItem menuItemMercedes;

    @FXML
    private MenuItem menuItemNuovo;

    @FXML
    private MenuItem menuItemPorte3;

    @FXML
    private MenuItem menuItemPorte5;

    @FXML
    private MenuItem menuItemSUV;

    @FXML
    private MenuItem menuItemTesla;

    @FXML
    private MenuItem menuItemUsato;

    @FXML
    private TextField tfColor;

    @FXML
    private TextField tfKM;

    @FXML
    private TextField tfModel;

    @FXML
    private TextField tfMonth;

    @FXML
    private TextField tfPower;

    @FXML
    private TextField tfYear;

    @FXML
    private MenuItem menuItemSeats2;

    @FXML
    private MenuItem menuItemSeats4;

    @FXML
    private MenuItem menuItemSeats5;

    @FXML
    void setAlfa(ActionEvent event) {
        menuButtonBrand.setText("Alfa Romeo");
    }

    @FXML
    void setAutomatico(ActionEvent event) {
        menuButtonGear.setText("Automatico");
    }

    @FXML
    void setBenzina(ActionEvent event) {
        menuButtonFuel.setText("Benzina");
    }

    @FXML
    void setBerlina(ActionEvent event) {
        menuButtonBody.setText("Berlina");
    }

    @FXML
    void setCoupé(ActionEvent event) {
        menuButtonBody.setText("Coupé");
    }

    @FXML
    void setDiesel(ActionEvent event) {
        menuButtonFuel.setText("Diesel");
    }

    @FXML
    void setElettrico(ActionEvent event) {
        menuButtonFuel.setText("Elettrico");
    }

    @FXML
    void setHatchback(ActionEvent event) {
        menuButtonBody.setText("HatchBack");
    }

    @FXML
    void setManuale(ActionEvent event) {
        menuButtonGear.setText("Manuale");
    }

    @FXML
    void setMercedes(ActionEvent event) {
        menuButtonBrand.setText("Mercedes");
    }

    @FXML
    void setNuovo(ActionEvent event) {
        menuButtonState.setText("Nuovo");
    }

    @FXML
    void setPorte3(ActionEvent event) {
        menuButtonNdoors.setText("3 porte");
    }

    @FXML
    void setPorte5(ActionEvent event) {
        menuButtonNdoors.setText("5 porte");
    }

    @FXML
    void setSUV(ActionEvent event) {
        menuButtonBody.setText("SUV");
    }

    @FXML
    void setTesla(ActionEvent event) {
        menuButtonBrand.setText("Tesla");
    }

    @FXML
    void setUsato(ActionEvent event) {
        menuButtonState.setText("Usato");
    }

    @FXML
    void setAudi(ActionEvent event) {
        menuButtonBrand.setText("Audi");
    }

    @FXML
    void setBMW(ActionEvent event) {
        menuButtonBrand.setText("BMW");
    }

    @FXML
    void setSeats2(ActionEvent event) {
        menuButtonNSeats.setText("2 posti");
    }

    @FXML
    void setSeats4(ActionEvent event) {
        menuButtonNSeats.setText("4 posti");
    }

    @FXML
    void setSeats5(ActionEvent event) {
        menuButtonNSeats.setText("5 posti");
    }

    @FXML
    void setHomepage(ActionEvent event) throws IOException {
        main.changeScene("Homepage.fxml");
    }

}
