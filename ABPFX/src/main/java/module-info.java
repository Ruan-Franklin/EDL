module com.example.abpfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.abpfx to javafx.fxml;
    exports com.example.abpfx;
}