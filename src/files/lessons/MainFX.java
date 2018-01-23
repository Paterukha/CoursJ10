package files.lessons;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MainFX extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static void main(String[] args) {
        launch(args);

    }

    void windowSetUp(Stage primaryStage) {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        primaryStage.setMaxWidth(WIDTH);
        primaryStage.setMaxHeight(HEIGHT);

        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);

    }

    void uiSetup(Pane root){
        Text text = new Text("Hello World!!!");
        root.setTranslateX(20);
        root.setTranslateY(20);
        text.setText(text.getText()+"\nHello!");

        TextField textField = new TextField("100");
        textField.setTranslateX(250);
        textField.setTranslateY(5);


        Button button = new Button("Добавить число");
        button.setTranslateX(100);
        button.setTranslateY(5);
        button.setOnMouseClicked((event) -> {
            String number= textField.getText();
            String oldText= text.getText();
            text.setText(oldText+"\n"+ number);

        });

        root.getChildren().addAll(text,button,textField);

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        windowSetUp(primaryStage);

        Pane root = new Pane();
        uiSetup(root);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}


