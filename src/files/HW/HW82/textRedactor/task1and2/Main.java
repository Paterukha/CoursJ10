package files.HW.HW82.textRedactor.task1and2;

import javafx.application.Application;
import javafx.stage.Stage;



public class Main extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphicInterface graphicInterface = new GraphicInterface(primaryStage);
    }
}