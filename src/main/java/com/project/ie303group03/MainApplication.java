package com.project.ie303group03;

import com.project.ie303group03.controllers.MainController;
import com.project.ie303group03.controllers.SinhVienController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.getStylesheets().add(getClass().getResource("css/global.css").toExternalForm());
        stage.setTitle("Xét Tốt Nghiệp");
        stage.setScene(scene);

        // Create SinhVienController
        SinhVienController sinhVienController = new SinhVienController();
        MainController mainController = fxmlLoader.getController();
        mainController.setSinhVienController(sinhVienController);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}