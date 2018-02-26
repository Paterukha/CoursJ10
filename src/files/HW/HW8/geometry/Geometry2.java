package files.HW.HW8.geometry;

import files.HW.HW8.TaskGeometry2;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Geometry2 {
    private Pane root = new Pane();
    private Random random = new Random();
    private List<MyRectangle2> myRectangles2 = new ArrayList<>();
    private int indexLeft = 0;
    private int indexRight = 0;

    public Geometry2(Stage primaryStage){
        drawInterface(primaryStage);
    }

    private void drawInterface(Stage primaryStage){
        Button multyThreads = new Button();
        multyThreads.setTranslateX(10);
        multyThreads.setTranslateY(10);
        multyThreads.setText("Multy Threads");

        Button singleThread = new Button();
        singleThread.setTranslateX(10);
        singleThread.setTranslateY(40);
        singleThread.setText("Single Thread");

        root.getChildren().addAll(multyThreads, singleThread);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        multyThreads.setOnMouseClicked(event -> {
            drawRectangles();
        });

        singleThread.setOnMouseClicked(event -> {
            drawRectangles2();

            Thread thread = new Thread(()->{
                int count = 0;


                while(count < 400) {


                    for (int i = 0; i < indexRight; i++){

                        final double x = myRectangles2.get(i).getTranslateX();
                        final double y = myRectangles2.get(i).getTranslateY();
                        final int j = i;

                        Platform.runLater(() -> {

                            if (myRectangles2.get(j).getTypeX()){
                                myRectangles2.get(j).setTranslateX(x+1);
                            } else {
                                myRectangles2.get(j).setTranslateX(x-1);
                            }

                            if (myRectangles2.get(j).getTypeY()){
                                myRectangles2.get(j).setTranslateY(y+1);
                            } else {
                                myRectangles2.get(j).setTranslateY(y-1);
                            }
                        });

                        checkType(myRectangles2.get(i));

                    }

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    count++;
                }
            });

            thread.start();
        });
    }


    private void checkType(MyRectangle2 myRectangle2){
        if (myRectangle2.getxStart()+myRectangle2.getTranslateX()+myRectangle2.getWidth() + 20 >= TaskGeometry2.WIDTH || myRectangle2.getxStart()+myRectangle2.getTranslateX() <= 0){
            myRectangle2.setTypeX(!myRectangle2.getTypeX());
        }

        if (myRectangle2.getyStart()+myRectangle2.getTranslateY()+myRectangle2.getHeight() + 40 >= TaskGeometry2.HEIGHT || myRectangle2.getyStart()+myRectangle2.getTranslateY() <= 0){
            myRectangle2.setTypeY(!myRectangle2.getTypeY());
        }
    }

    private void drawRectangles(){


        int count = random.nextInt(8) + 3;
        MyRectangle[] myRectangles = new MyRectangle[count];
        for (MyRectangle myRectangle: myRectangles){

            drawRectangle();
        }
    }

    private void drawRectangle(){
        double x = random.nextInt((int) TaskGeometry2.WIDTH/2);
        double y = random.nextInt((int) TaskGeometry2.HEIGHT/2);
        double width = random.nextInt((int) TaskGeometry2.WIDTH/2);
        double height = random.nextInt((int) TaskGeometry2.HEIGHT/2);
        int typeXint = random.nextInt(2)+1;
        int typeYint = random.nextInt(2)+1;
        boolean typeX = (typeXint == 1);
        boolean typeY = (typeYint == 1);


        new Thread(new MyRectangle(root,x,y,width,height,getColor(),typeX,typeY)).start();
    }

    private void drawRectangles2(){


        int count = random.nextInt(8) + 3;
        indexLeft = indexRight;
        indexRight = indexLeft + count;

        for (int i = indexLeft; i < indexRight; i++){

            myRectangles2.add(drawRectangle2());
        }
    }

    private MyRectangle2 drawRectangle2(){
        double x = random.nextInt((int) TaskGeometry2.WIDTH/2);
        double y = random.nextInt((int) TaskGeometry2.HEIGHT/2);
        double width = random.nextInt((int) TaskGeometry2.WIDTH/2);
        double height = random.nextInt((int) TaskGeometry2.HEIGHT/2);
        int typeXint = random.nextInt(2)+1;
        int typeYint = random.nextInt(2)+1;
        boolean typeX = (typeXint == 1);
        boolean typeY = (typeYint == 1);


        return new MyRectangle2(root,x,y,width,height,getColor(),typeX,typeY);
    }

    private Color getColor(){
        Color color = Color.color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.6f);
        return color;
    }
}
