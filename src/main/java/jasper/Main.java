package jasper;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
    private final Jasper jasper = new Jasper("data", "duke.txt");

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            stage.setMinHeight(220);
            stage.setMinWidth(417);
            // stage.setMaxWidth(417); // Add if elements not automatically resizable horizontally
            MainWindow controller = fxmlLoader.getController();
            controller.setJasper(jasper);  // inject the Jasper instance
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
