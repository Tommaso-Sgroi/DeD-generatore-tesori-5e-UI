package it.tommy.ded.gen.controller;

import it.tommy.ded.treasoures.generator.cumulo_di_tesori.CumuloTesori;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;


public class LootController {


    public LootController(){super();}

    @FXML private TextArea textArea;
    @FXML private Text text;

    @FXML public void save(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt"));
        File dest = fileChooser.showSaveDialog(null);
        if (dest != null)
        {
            try
            {
                Files.write(dest.toPath(), textArea.getText().getBytes(StandardCharsets.UTF_8));
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void reload(){
        switch(text.getText())
        {
            case "04": textArea.setText(CumuloTesori.getCumuloTesori04().generaTesori().toString());break;
            case "510": textArea.setText(CumuloTesori.getCumuloTesori510().generaTesori().toString());break;
            case "1116": textArea.setText(CumuloTesori.getCumuloTesori1116().generaTesori().toString());break;
            case "17": textArea.setText(CumuloTesori.getCumuloTesori17().generaTesori().toString());break;
        }
    }
}
