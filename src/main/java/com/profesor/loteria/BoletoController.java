package com.profesor.loteria;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BoletoController implements Initializable {
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    private ArrayList<TextField> numeroONCE = new ArrayList<TextField>() {
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Guardamos los componentes TextField en una lista
        this.numeroONCE.add(this.field1);
        this.numeroONCE.add(this.field2);
        this.numeroONCE.add(this.field3);
        this.numeroONCE.add(this.field4);
        this.numeroONCE.add(this.field5);


        //Obtengo la instancia del singleton que almacena el número de la lotería ya formateado
        LotteryContext ctx = LotteryContext.getInstance();
        String lotteryNum = ctx.getLotteryNumber();

        //Recorro la lista de textField asignandole el número de loteria correspondiente
        for (int i = 0; i < this.numeroONCE.size(); i++) {
            this.numeroONCE.get(i).setText(String.valueOf(lotteryNum.charAt(lotteryNum.length() - 1 - i)));
        }


    }

    //Método para cerra la ventan actual
    public void handlerCerrarVentana(ActionEvent actionEvent) {

        Stage currentStage = (Stage) this.field1.getScene().getWindow();
        currentStage.close();

    }
}
