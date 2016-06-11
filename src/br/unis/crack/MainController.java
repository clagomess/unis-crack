package br.unis.crack;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class MainController {
    @FXML
    TextField txtRequestCode;

    @FXML
    TextField txtChave;

    public void gerarAction() {
        String request_code = txtRequestCode.getText();

        // Validar
        if(request_code.length() == 0 || request_code.length() != 36){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Request Code Inválido!");

            alert.showAndWait();
            return;
        }

        // Negócio
        request_code = request_code.replace("-", "");

        String upper = request_code.substring(8, 12);
        upper += request_code.substring(request_code.length() - 6, request_code.length() - 6 + 4);
        upper += request_code.substring(12, 16);
        upper += request_code.substring(0, 3);

        Long lupper = new BigInteger(upper.toLowerCase(), 16).longValue();
        lupper = lupper / 2L;

        txtChave.setText(Long.toHexString(lupper).toUpperCase());
    }
}
