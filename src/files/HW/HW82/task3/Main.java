package files.HW.HW82.task3;


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
