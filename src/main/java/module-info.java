module com.ecommerce.javafx2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.ecommerce.javafx2 to javafx.fxml;
    exports com.ecommerce.javafx2;
}