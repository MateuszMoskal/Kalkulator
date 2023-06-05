package com.example.kalkulator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Objects;

public class HelloController {
    private Double variable1;
    private Double variable2;
    private Double result;
    private String operator;


    @FXML
    private TextField textFieldResult;

    public void onClickButtonEquals() {
        System.out.println("onClickButtonEquals");
        switch (operator) {
            case "+":
                result = variable1 + variable2;
                break;
            case "-":
                result = variable1 - variable2;
                break;
            case "×":
                result = variable1 * variable2;
                break;
            case ":":
                result = variable1 / variable2;
                break;
        }
        variable1 = null;
        variable2 = null;
        operator = null;
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonNumber(ActionEvent e) {
        System.out.println("onClickButtonNumber: " + ((Button) e.getSource()).getText());
        if (Objects.isNull(operator))
            if (Objects.isNull(variable1)) variable1 = Double.valueOf(((Button) e.getSource()).getText());
            else {
                String[] parts = String.valueOf(variable1).split("\\.");
                variable1 = Double.valueOf(parts[0] + ((Button) e.getSource()).getText() + "." + parts[1]);
            }
        else {
            if (Objects.isNull(variable2)) variable2 = Double.valueOf(((Button) e.getSource()).getText());
            else {
                String[] parts = String.valueOf(variable2).split("\\.");
                variable2 = Double.valueOf(parts[0] + ((Button) e.getSource()).getText() + "." + parts[1]);
            }
        }
    }

    public void onClickButtonOperator(ActionEvent e) {
        System.out.println("onClickButtonOperator" + ((Button) e.getSource()).getText());
        operator = ((Button) e.getSource()).getText();
    }

    public void onClickButtonBackspace() {
        System.out.println("onClickButtonBackspace");
    }

    public void onClickButtonNegative() {
        System.out.println("onClickButtonNegative");
        result = 1 / variable1;
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonPower() {
        System.out.println("onClickButtonPower");
        result = variable1 * variable1;
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonPercentage() {
        System.out.println("onClickButtonPercentage");
        result = variable1 / 100;
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonCE() {
        System.out.println("onClickButtonCE");
    }

    public void onClickButtonC() {
        System.out.println("onClickButtonC");
        result = null;
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonSquare() {
        System.out.println("onClickButtonSquare");
        result = Math.sqrt(variable1);
        textFieldResult.setText(String.valueOf(result));
    }

    public void onClickButtonDot() {
        System.out.println("onClickButtonDot");
    }

    public void onClickButtonPlusMinus() {
        System.out.println("onClickButtonPlusMinus");
        result = variable1 * -1;
        textFieldResult.setText(String.valueOf(result));
    }
}
