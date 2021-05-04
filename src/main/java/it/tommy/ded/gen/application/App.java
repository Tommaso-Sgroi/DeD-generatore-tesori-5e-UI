package it.tommy.ded.gen.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        AnchorPane p = (AnchorPane)FXMLLoader.load(getClass().getResource("/fxml/generator.fxml"));


        ImageView image = new ImageView(new Image("/images/background.png", 680, 477, false, false));
        p.getChildren().add(0,image);

        stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/dragonico.png")));


        scene = new Scene(p);


        stage.setScene(scene);


        stage.show();
        stage.setHeight(stage.getHeight()-1);

    }



    public static void main(String[] args) {
        launch();
    }

}