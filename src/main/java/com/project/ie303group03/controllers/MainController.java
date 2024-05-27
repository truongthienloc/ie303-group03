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
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
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
    @FXML
    private TableView<ChungChiDataModel> tableChungChi;
    @FXML
    private TableColumn<ChungChiDataModel, String> colMaChungChi;
    @FXML
    private  TableColumn<ChungChiDataModel, Object> colKetQua;

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

        colMaChungChi.setCellValueFactory(new PropertyValueFactory<ChungChiDataModel, String>("maChungChi"));
        colKetQua.setCellValueFactory(new PropertyValueFactory<ChungChiDataModel, Object>("ketQua"));

        colMaChungChi.setStyle("-fx-alignment: CENTER;");
        colKetQua.setStyle("-fx-alignment: CENTER;");
    }

    public void setSinhVienController(SinhVienController sinhVienController) {
        this.sinhVienController = sinhVienController;
    }

    private void renderTableMonHoc() {
        ArrayList<KetQuaHocTap> kqhts = this.sinhVienController.getSinhVien().getBangDiem();
        ArrayList<ChungChiNgoaiNgu> ccnns = this.sinhVienController.getSinhVien().getDsChungChiNgoaiNgu();

        ObservableList<KQHTDataModel> sinhVienList = FXCollections.observableArrayList();
        for (KetQuaHocTap kqht : kqhts) {
            sinhVienList.add(KQHTDataModel.fromKetQuaHocTap(kqht));
        }

        tableMonHoc.setItems(sinhVienList);

        ObservableList<ChungChiDataModel> chungChiList = FXCollections.observableArrayList();
        for (ChungChiNgoaiNgu ccnn : ccnns) {
            chungChiList.add(ChungChiDataModel.fromChungChiNgoaiNgu(ccnn));
        }

        tableChungChi.setItems(chungChiList);

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
            Sheet sheetChungChi = wb.getSheetAt(2);

            String mssv = sheetThongTin.getRow(0).getCell(0).getStringCellValue();
            String hoTen = sheetThongTin.getRow(1).getCell(0).getStringCellValue();
            int diemRenLuyen = (int)sheetThongTin.getRow(2).getCell(0).getNumericCellValue();


            DanhSachMonHoc dsmh = new DanhSachMonHoc();
            ChungChiNgoaiNguFactory ccnnFactory = new ChungChiNgoaiNguFactory();
            ArrayList<KetQuaHocTap> kqhts = new ArrayList<>();
            ArrayList<ChungChiNgoaiNgu> ccnns = new ArrayList<>();


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

            startRow = sheetChungChi.getFirstRowNum();
            endRow = sheetChungChi.getLastRowNum();
            for (int i = startRow; i <= endRow; i++) {
                Row curRow = sheetChungChi.getRow(i);
                String maChungChi = curRow.getCell(0).getStringCellValue();
                int namCap = (int) curRow.getCell(1).getNumericCellValue();

                CellType cellType = curRow.getCell(2).getCellType();
                Object ketQua = null;
                if (cellType.equals(CellType.STRING)) {
                    ketQua = curRow.getCell(2).getStringCellValue();
                }
                else {
                    ketQua = (float) curRow.getCell(2).getNumericCellValue();
                }

                Cell cellNamHetHan = curRow.getCell(3);
                int soNamHetHan = 0;
                if (cellNamHetHan != null) {
                    soNamHetHan = (int) cellNamHetHan.getNumericCellValue();
                }

                ChungChiNgoaiNgu ccnn = ccnnFactory.createChungChiNgoaiNgu(maChungChi, namCap, ketQua, soNamHetHan);
                if (ccnn != null) {
                    ccnns.add(ccnn);
                }
            }

            SinhVien sinhVien = new SinhVien(mssv, hoTen, ccnns, kqhts, diemRenLuyen);
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