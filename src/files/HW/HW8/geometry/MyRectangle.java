package files.HW.HW8.geometry;

import files.HW.HW8.TaskGeometry1;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MyRectangle extends Rectangle implements Runnable{
    private Pane root;
    private double xStart;
    private double yStart;
    private boolean typeX;
    private boolean typeY;

    public MyRectangle(Pane root, double x, double y, double width, double height, Color color, boolean typeX, boolean typeY){
        super(x, y, width, height);
        this.root = root;
        this.xStart = x;
        this.yStart = y;
        this.typeX = typeX;
        this.typeY = typeY;
        this.setFill(color);
        Platform.runLater(() -> {
            root.getChildren().addAll(this);
        });
    }

    @Override
    public void run() {
        int count = 0;


        while(count < 400) {
            final double x = this.getTranslateX();
            final double y = this.getTranslateY();

            Platform.runLater(() -> {

                if (typeX){
                    this.setTranslateX(x+1);
                } else {
                    this.setTranslateX(x-1);
                }

                if (typeY){
                    this.setTranslateY(y+1);
                } else {
                    this.setTranslateY(y-1);
                }
            });

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            checkType();
        }
    }


    private void checkType(){
        if (xStart+this.getTranslateX()+this.getWidth() + 20 >= TaskGeometry1.WIDTH || xStart+this.getTranslateX() <= 0){
            typeX = !typeX;
        }

        if (yStart+this.getTranslateY()+this.getHeight() + 40 >= TaskGeometry1.HEIGHT || yStart+this.getTranslateY() <= 0){
            typeY = !typeY;
        }
    }

}
