package chapt1;

import javafx.application.Application;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Main extends Application {


    private static final int V = 800;
    private static final int V_1 = 600;

    @Override
    public void  start(Stage primaryStage) throws Exception{

        Sphere sphere=new Sphere ( 50 );
        Group group=new Group (  );
        group.getChildren ().add (sphere);
        Camera camera=new PerspectiveCamera (  );
        Scene scene=new Scene (group, V, V_1);
        scene.setFill (Color.SILVER);
        scene.setCamera (camera);
        sphere.translateXProperty ().set (V/2);
        sphere.translateYProperty ().set (V_1/2);
        primaryStage.addEventHandler (KeyEvent.KEY_PRESSED,event->{
            switch (event.getCode ()){
                case W :
                    sphere.translateZProperty ().set (sphere.getTranslateZ ()+100);
                    break;
                case S:
                    sphere.translateZProperty ().set (sphere.getTranslateZ ()-100);
                    break;
            }
        });


        primaryStage.setTitle ("Sphere");
        primaryStage.setScene (scene);
        primaryStage.show ();

    }

    public static void main(String[] args) {
        launch (args);
    }
}
