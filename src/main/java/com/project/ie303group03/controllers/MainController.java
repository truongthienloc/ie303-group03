package com.project.ie303group03.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnImportFile;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleBtnImportFileClick(ActionEvent e) {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

        FileChooser fc = new FileChooser();
        fc.setTitle("Chọn file excel bảng điểm của bạn");
        FileChooser.ExtensionFilter excelFilter = new FileChooser.ExtensionFilter("Excel", "*.csv", "*.xls", "*.xlsx");
        fc.getExtensionFilters().add(excelFilter);
        File file = fc.showOpenDialog(stage);

        if (file == null) {
            return;
        }

        // TODO: Handle add data and navigate to result screen
    }
}