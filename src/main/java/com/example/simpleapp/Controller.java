package com.example.simpleapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class Controller {

    @FXML
    private TextField inputArea;
    @FXML
    private TextArea historyArea;


    private Game game;
    private int step;

    public Controller() {
        this.game = new Game();
    }


    public void clickCheckBtn(ActionEvent actionEvent) {
        String inputText = inputArea.getText();
        if (inputText.isBlank()) {
            return;
        }
        Game.BullsAndCowsCounter count = game.calculateBullsAndCows(inputText);
        String text = String.format("%d. Введено число %s, \n кол-во быков = %d, \n кол-во коров =  %d ", ++step, inputText, count.getBulls(), count.getCows());
        historyArea.appendText(text + "\n");
        inputArea.clear();
        inputArea.requestFocus();

        if (count.getBulls() == 4) {
            if (ifWantToPlayAgain()) {
                step = 0;
                historyArea.clear();
                this.game = new Game();
            } else {
                System.exit(0);
            }
        }
    }

    private boolean ifWantToPlayAgain() {
        Alert alert = new Alert(Alert.AlertType.NONE,
                "Вы победили! \n" + " Загаданное число " + game.getGuessNum() + ". \n" + "Играть снова?",
                new ButtonType("Да", ButtonBar.ButtonData.YES),
                new ButtonType("Нет", ButtonBar.ButtonData.NO));
        alert.setTitle("Поздравляю!");
        final ButtonType answer = alert.showAndWait().get();
        return answer.getButtonData() == ButtonBar.ButtonData.YES;
    }
}