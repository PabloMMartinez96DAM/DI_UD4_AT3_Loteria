package com.profesor.loteria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private final String FICHERO_SONIDO = "music/wrong.mp3";
    @FXML
    private TextField inputBoleto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handlerGenerarBoleto(ActionEvent actionEvent) {


        //Almaceno el input en un singleton que me lo formatea rellenando con '0' hasta que la longitud del string sea
        // 5 caracteres.
        LotteryContext ctx = LotteryContext.getInstance();
        ctx.setLotteryNumber(this.inputBoleto.getText());

        try {
            FXMLLoader loader = new FXMLLoader(MainController.class.getResource("boletoView.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        } catch (IOException e) {
            System.out.println("No se ha podido cargar la segunda ventana");
        }
    }

    //Controlamos que al inputBoleto solo se le puedan añadir números y que tenga un tamaño no superior a 5
    public void handlerInputBoletoKeyTyped(KeyEvent keyEvent) {

        if( !this.inputBoleto.getText().matches("\\d{1,5}")){
            this.inputBoleto.deletePreviousChar();
            MediaPlayer mediaPlayer = new MediaPlayer(new Media(MainController.class.getResource(FICHERO_SONIDO).toString()));
            mediaPlayer.play();
        }

    }
}
