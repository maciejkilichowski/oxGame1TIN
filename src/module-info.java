module oxGame1TIN {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires com.zaxxer.hikari;
	requires org.slf4j;
	requires javafx.base;
	requires javafx.graphics;
	
	opens lab.oxgame to javafx.graphics, javafx.fxml;
	opens lab.oxgame.model to javafx.base;
}
