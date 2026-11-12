module br.dev.lionn.dukemarket.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    requires java.sql;
    
    opens br.dev.lionn.dukemarket.javafx to javafx.fxml;
    opens br.dev.lionn.dukemarket.javafx.controller to javafx.fxml;
    
    exports br.dev.lionn.dukemarket.javafx;
    exports br.dev.lionn.dukemarket.javafx.model;
    exports br.dev.lionn.dukemarket.javafx.DAO;
    exports br.dev.lionn.dukemarket.javafx.controller;

    
    requires mysql.connector.java;
}