package files.HW.HW82.textRedactor.task1and2;

import files.HW.HW82.utils.Fibonacci;
import files.HW.HW82.utils.FileUtils;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class GraphicInterface {

    private Stage primaryStage;
    private Pane root = new Pane();
    private static final int WIDTH = 900;
    private static final int HEIGHT = 825;
    private static final String TEXT_CODING = "CP1251";
    private static final String FILE_PATH = "files\\text.txt";

    public GraphicInterface(Stage primaryStage){
        this.primaryStage = primaryStage;
        draw(primaryStage);
    }

    public void draw(Stage primaryStage) {
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Text Redactor");

        FileUtils fileUtils = new FileUtils();
        Fibonacci fibonacciUtils = new Fibonacci();


        TextField filePath = new TextField();
        filePath.setTranslateX(10);
        filePath.setTranslateY(10);
        filePath.setPrefWidth(300);
        filePath.setText(fileUtils.getApplicationPath() + "\\" + FILE_PATH);
        root.getChildren().add(filePath);


        TextField textNumber = new TextField();
        textNumber.setTranslateX(700);
        textNumber.setTranslateY(10);
        textNumber.setPrefWidth(70);
        root.getChildren().add(textNumber);


        Label errorLabel = new Label();
        errorLabel.setTranslateX(20);
        errorLabel.setTranslateY(40);
        errorLabel.setTextFill(Color.RED);
        root.getChildren().add(errorLabel);


        Label errorNumber = new Label();
        errorNumber.setTranslateX(600);
        errorNumber.setTranslateY(40);
        errorNumber.setTextFill(Color.RED);
        root.getChildren().add(errorNumber);


        TextArea fileText = new TextArea();
        fileText.setTranslateX(10);
        fileText.setTranslateY(70);
        fileText.setPrefWidth(850);
        fileText.setPrefHeight(700);
        root.getChildren().add(fileText);


        Button load = new Button();
        load.setTranslateX(350);
        load.setTranslateY(10);
        load.setText("Load");
        load.setOnMouseClicked(event -> {
            new Thread(() -> {
                Platform.runLater(() -> {
                    errorLabel.setText("");
                    final String filePathName = filePath.getText();
                    if (fileUtils.fileExists(filePathName)){
                        fileText.setText(fileUtils.readTextFromFile(filePathName, TEXT_CODING));
                    } else {
                        errorLabel.setText("File does not exist!");
                        fileText.setText("");
                    }
                });
            }).start();
        });
        root.getChildren().add(load);


        Button save = new Button();
        save.setTranslateX(400);
        save.setTranslateY(10);
        save.setText("Save");
        save.setOnMouseClicked(event -> {
            new Thread(() -> {
                Platform.runLater(() -> {
                    final String filePathName = filePath.getText();
                    if (!fileUtils.fileExists(filePathName)) {
                        try {
                            fileUtils.createFile(filePathName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    fileUtils.saveTextToFile(fileText.getText(),filePathName,TEXT_CODING);
                });
            }).start();
        });
        root.getChildren().add(save);


        Button fibonacci = new Button();
        fibonacci.setTranslateX(780);
        fibonacci.setTranslateY(10);
        fibonacci.setPrefWidth(80);
        fibonacci.setText("Fibonacci");
        fibonacci.setOnMouseClicked(event -> {
            new Thread(() -> {
                Platform.runLater(() -> {
                    errorNumber.setText("");
                });
                    final String numberToFind = textNumber.getText();
                    if (fibonacciUtils.checkString(numberToFind)){
                        final String filePathName = filePath.getText();
                        if (!fileUtils.fileExists(filePathName)) {
                            try {
                                fileUtils.createFile(filePathName);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        fileUtils.saveTextToFile(fibonacciUtils.getFibonacciRow(Long.parseLong(numberToFind)),filePathName,TEXT_CODING);
                    } else {
                        Platform.runLater(()->{
                            errorNumber.setText("Text above (\"" + numberToFind + "\") is not correct number!");
                        });

                    }
            }).start();
        });
        root.getChildren().add(fibonacci);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
