package com.project.ie303group03.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultController {
    @FXML
    private VBox vbResult;
    @FXML
    private Button btnSave;
    private SinhVienController sinhVienController = null;

    public void setSinhVienController(SinhVienController sinhVienController) {
        this.sinhVienController = sinhVienController;
        this.onReady();
    }

    private void onReady() {
        this.sinhVienController.xetTotNghiep();
        ArrayList<String> logs = this.sinhVienController.getLogs();

        for (String log : logs) {
            Text textResult = new Text(log);
            textResult.setFont(new Font(16));
            vbResult.getChildren().add(textResult);
        }

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

    public void handleBtnSaveClick(ActionEvent e) {
        try {
            this.sinhVienController.luuKetQuaXetTotNghiep();

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Lưu kết quả xét tốt nghiệp thành công");
            alert.show();
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }
}
