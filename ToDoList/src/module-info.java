module ToDoList {
    requires javafx.controls;
    requires java.sql;
    
    opens main to javafx.graphics, javafx.fxml;
    opens controllers to javafx.graphics, javafx.fxml;
    opens models to javafx.graphics, javafx.fxml;
    opens utils to javafx.graphics, javafx.fxml;
    opens views to javafx.graphics, javafx.fxml;
}
