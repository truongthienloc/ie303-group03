package com.project.ie303group03.controllers;

import com.project.ie303group03.models.KQHTDataModel;
import com.project.ie303group03.models.KetQuaHocTap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Button btnImportFile;
    @FXML
    private Button btnLoadData;
    @FXML
    private Button btnCheck;
    @FXML
    private TableView<KQHTDataModel> tableMonHoc;
    @FXML
    private TableColumn<KQHTDataModel, String> colMaMonHoc;
    @FXML
    private TableColumn<KQHTDataModel, String> colTenMonHoc;
    @FXML
    private TableColumn<KQHTDataModel, Integer> colSoTinChi;
    @FXML
    private TableColumn<KQHTDataModel, Float> colDiem;
    @FXML
    private TextField tfDiemRenLuyen;

    private SinhVienController sinhVienController = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colMaMonHoc.setCellValueFactory(new PropertyValueFactory<KQHTDataModel, String>("maMonHoc"));
        colTenMonHoc.setCellValueFactory(new PropertyValueFactory<KQHTDataModel, String>("tenMonHoc"));
        colSoTinChi.setCellValueFactory(new PropertyValueFactory<KQHTDataModel, Integer>("soTinChi"));
        colDiem.setCellValueFactory(new PropertyValueFactory<KQHTDataModel, Float>("diem"));

        colMaMonHoc.setStyle("-fx-alignment: CENTER;");
        colSoTinChi.setStyle("-fx-alignment: CENTER;");
        colDiem.setStyle("-fx-alignment: CENTER;");
    }

    public void setSinhVienController(SinhVienController sinhVienController) {
        this.sinhVienController = sinhVienController;
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
        this.sinhVienController.initData();
        ArrayList<KetQuaHocTap> kqhts = this.sinhVienController.getSinhVien().getBangDiem();

        ObservableList<KQHTDataModel> sinhVienList = FXCollections.observableArrayList();
        for (KetQuaHocTap kqht : kqhts) {
            sinhVienList.add(KQHTDataModel.fromKetQuaHocTap(kqht));
        }

        tableMonHoc.setItems(sinhVienList);
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
        ResultController resultController = loader.getController();
        resultController.setSinhVienController(this.sinhVienController);

        stage.setScene(scene);
    }
}