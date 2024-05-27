package com.project.ie303group03.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResultController {
    private SinhVienController sinhVienController = null;

    public void setSinhVienController(SinhVienController sinhVienController) {
        this.sinhVienController = sinhVienController;
    }

    public void handleBackClick(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/project/ie303group03/fxml/main-view.fxml"));
        Scene scene = new Scene(loader.load());

        MainController mainController = loader.getController();
        mainController.setSinhVienController(this.sinhVienController);

        stage.setScene(scene);
    }
}
