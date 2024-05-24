package com.project.ie303group03.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnImportFile;
    @FXML
    private Button btnLoadData;
    @FXML
    private Button btnCheck;
    @FXML
    private TableView tableMonHoc;
    @FXML
    private TextField tfDiemRenLuyen;

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
        }

        // TODO: Handle add data and navigate to result screen
    }

    public void handleBtnLoadDataClick(ActionEvent e) {
        // TODO: Handle init testing case data
    }

    public void handleBtnCheckClick(ActionEvent e) throws IOException {
        Node node = (Node) e.getSource();
        Stage stage = (Stage) node.getScene().getWindow();

//        System.out.println(getClass().getResource("/com/project/ie303group03/fxml/result-view.fxml"));
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("/com/project/ie303group03/fxml/result-view.fxml"));
//        loader.setLocation();
        Parent resultView = loader.load();
        Scene scene = new Scene(resultView);

        // TODO: handle set data to new scene

        stage.setScene(scene);
    }
}