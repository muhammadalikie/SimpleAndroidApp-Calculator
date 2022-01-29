package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button zero, one, two, three, four, five, six, seven, eight, nine, dot, equal, plus, minus, multiply, divide, clear;
    TextView result, operation, operatorText;
    String operator;
    double x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();

        clear.setOnClickListener(v -> {
            operation.setText("0");
            result.setText("0");
            operator = "";
            operatorText.setText(operator);
        });
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        dot.setOnClickListener(v -> {

            if (!operation.getText().toString().trim().contains(".")){

                if (operation.getText().toString().trim().equals("0")){
                    operation.setText("0.");
                } else {
                    operation.setText(String.format("%s%s",operation.getText().toString(),"."));
                }
            }

        });
        equal.setOnClickListener(view -> calculation());


        plus.setOnClickListener(view -> setOperator("+"));
        minus.setOnClickListener(view -> setOperator("-"));
        multiply.setOnClickListener(view -> setOperator("*"));
        divide.setOnClickListener(view -> setOperator("/"));
    }

    private void initialize(){
        zero = findViewById(R.id.btn0);
        one = findViewById(R.id.btn1);
        two = findViewById(R.id.btn2);
        three = findViewById(R.id.btn3);
        four = findViewById(R.id.btn4);
        five = findViewById(R.id.btn5);
        six = findViewById(R.id.btn6);
        seven = findViewById(R.id.btn7);
        eight = findViewById(R.id.btn8);
        nine = findViewById(R.id.btn9);
        dot = findViewById(R.id.dot);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        divide = findViewById(R.id.divide);
        clear = findViewById(R.id.clear);
        result = findViewById(R.id.result);
        operation = findViewById(R.id.operation);
        equal = findViewById(R.id.equal);
        operatorText = findViewById(R.id.operatorText);
    }

    @Override
    public void onClick(View view) {

        if (operation.getText().toString().trim().equals("0")){
            operation.setText("");
        }

        operation.setText(String.format("%s%s",operation.getText().toString(), ((Button)view).getText()));

    }

    private void setOperator(String operator){

        if (!result.getText().toString().trim().equals("0") && !operation.getText().toString().trim().equals("0")
            && !operator.equals("")) {
            calculation();
        }

        this.operator = operator;
        operatorText.setText(operator);

        if (!operation.getText().toString().trim().equals("0")){
            result.setText(operation.getText().toString().trim());
            operation.setText("0");
        }

    }


    private void calculation(){

        if (!result.getText().toString().trim().equals("0") && !operation.getText().toString().trim().equals("0")
                && !operator.equals("")) {

        x = Double.parseDouble(operation.getText().toString().trim());
        y = Double.parseDouble(result.getText().toString().trim());

        switch (operator.charAt(0)) {
            case '+':
                result.setText(String.format("%s", y + x));
                break;
            case '-':
                result.setText(String.format("%s", y - x));
                break;
            case '*':
                result.setText(String.format("%s", y * x));
                break;
            case '/':
                result.setText(String.format("%s", y / x));
                break;

        }

        operation.setText("0");
        x = Double.parseDouble(operation.getText().toString().trim());;
        y = Double.parseDouble(result.getText().toString().trim());
        operator = "";
        operatorText.setText(operator);

    }

    }

}