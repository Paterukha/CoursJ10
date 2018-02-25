package ua.goit.java8.module82.task3;


import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Created by Taras on 16.09.2017.
 */
public class Main extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GraphicInterface graphicInterface = new GraphicInterface(primaryStage);
    }
}
