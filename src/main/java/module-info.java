module com.project.ie303group03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;

    opens com.project.ie303group03 to javafx.fxml;
    exports com.project.ie303group03;
    exports com.project.ie303group03.controllers;
    exports com.project.ie303group03.models;
    opens com.project.ie303group03.controllers to javafx.fxml;
}