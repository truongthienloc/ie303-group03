package com.project.ie303group03.controllers;

import com.project.ie303group03.models.*;
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
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    @FXML
    private TextField tfMSSV;
    @FXML
    private TextField tfHoTen;

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

    private void renderTableMonHoc() {
        ArrayList<KetQuaHocTap> kqhts = this.sinhVienController.getSinhVien().getBangDiem();

        ObservableList<KQHTDataModel> sinhVienList = FXCollections.observableArrayList();
        for (KetQuaHocTap kqht : kqhts) {
            sinhVienList.add(KQHTDataModel.fromKetQuaHocTap(kqht));
        }

        tableMonHoc.setItems(sinhVienList);

        SinhVien sinhVien = this.sinhVienController.getSinhVien();
        tfMSSV.setText(sinhVien.getMaSV());
        tfHoTen.setText(sinhVien.getHoTen());
        tfDiemRenLuyen.setText(String.valueOf(sinhVien.getDiemRenLuyen()));
    }

    public void handleBtnImportFileClick(ActionEvent e) throws Exception {
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

        // TODO: Handle add data and navigate to result
        FileInputStream fis = new FileInputStream(file.getPath());
        try {
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheetThongTin = wb.getSheetAt(0);
            Sheet sheetBangDiem = wb.getSheetAt(1);
//        Sheet sheetChungChi = wb.getSheetAt(2);

            String mssv = sheetThongTin.getRow(0).getCell(0).getStringCellValue();
            String hoTen = sheetThongTin.getRow(1).getCell(0).getStringCellValue();
            int diemRenLuyen = (int)sheetThongTin.getRow(2).getCell(0).getNumericCellValue();


            DanhSachMonHoc dsmh = new DanhSachMonHoc();
            ArrayList<KetQuaHocTap> kqhts = new ArrayList<>();

            int startRow = sheetBangDiem.getFirstRowNum();
            int endRow = sheetBangDiem.getLastRowNum();
            for (int i = startRow; i <= endRow; i++) {
                Row curRow = sheetBangDiem.getRow(i);
                String maMonHoc = curRow.getCell(0).getStringCellValue();
                float soDiem = (float)(curRow.getCell(1).getNumericCellValue());

                MonHoc monHoc = dsmh.getMonHocById(maMonHoc);
                if (monHoc == null) {
                    continue;
                }
                KetQuaHocTap kqht = new KetQuaHocTap(monHoc, soDiem);
                kqhts.add(kqht);
            }

            SinhVien sinhVien = new SinhVien(mssv, hoTen, new ArrayList<>(), kqhts, diemRenLuyen);
            this.sinhVienController.setSinhVien(sinhVien);
            this.renderTableMonHoc();
        } catch (Exception exception) {
            fis.close();
            throw new Exception(exception);
        }

        fis.close();
    }

    public void handleBtnLoadDataClick(ActionEvent e) {
        // TODO: Handle init testing case data
        this.sinhVienController.initData();
        this.renderTableMonHoc();
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