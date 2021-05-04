package it.tommy.ded.gen.controller;

import it.tommy.ded.treasoures.generator.cumulo_di_tesori.CumuloTesori;
import it.tommy.ded.treasoures.generator.loot.Loot;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class GeneratorController implements Initializable {

    @FXML private Button button04;
    @FXML private Button button510;
    @FXML private Button button1116;
    @FXML private Button button17;

    private static final String CSS_COLOR_PREFIX = "-fx-background-color: ";

    private Stage areaTextStage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for(Button butt: List.of(button04, button510, button1116, button17))
        {
             butt.onMouseExitedProperty()
                     .set(e-> butt.setStyle(CSS_COLOR_PREFIX+"#e62e00;"+"-fx-background-radius: 50;"));
             butt.onMouseEnteredProperty()
                     .set(e-> butt.setStyle(CSS_COLOR_PREFIX+"#000000;"+"-fx-background-radius: 50;"));
        }
        button04.setOnMouseClicked(e-> showNewStage(CumuloTesori.getCumuloTesori04().generaTesori(), "04"));
        button510.setOnMouseClicked(e-> showNewStage(CumuloTesori.getCumuloTesori510().generaTesori(), "510"));
        button1116.setOnMouseClicked(e-> showNewStage(CumuloTesori.getCumuloTesori1116().generaTesori(), "1116"));
        button17.setOnMouseClicked(e-> showNewStage(CumuloTesori.getCumuloTesori17().generaTesori(), "17"));

    }


    private void showNewStage(Loot loot, String lootType){
        try
        {
            Parent parent = new FXMLLoader().load(getClass().getResourceAsStream("/fxml/loot.fxml"));
            for(Node node: parent.getChildrenUnmodifiable())
                if(node instanceof TextArea)
                {
                    ((TextArea) node).setText(loot.toString());
                }
                else if(node instanceof Text)
                {
                    ((Text) node).setText(lootType);
                }
            areaTextStage = new Stage();
            Scene scene = new Scene(parent);
            areaTextStage.setScene(scene);
            areaTextStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/dragonico.png")));
            areaTextStage.show();
            areaTextStage.setResizable(false);

        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
        }
    }
}
