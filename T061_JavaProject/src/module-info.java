module T061_Mortify {
	
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}