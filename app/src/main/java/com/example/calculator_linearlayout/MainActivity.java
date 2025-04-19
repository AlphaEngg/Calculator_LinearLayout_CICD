package com.example.calculator_linearlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;


public class MainActivity extends AppCompatActivity {

            TextView txtCal;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnAdd, btnSub, btnMul, btnDiv, btnClear, btnCal;
    double value1, value2;
    boolean isAdd, isSub, isMul, isDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCenter.start(getApplication(), "{Your app secret here}",
                Analytics.class, Crashes.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCal = findViewById(R.id.txtCal);

        // Initialize buttons
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnClear = findViewById(R.id.btnClear);
        btnCal = findViewById(R.id.btnCal);

        // Set onClickListeners for number buttons
        btn1.setOnClickListener(v -> txtCal.append("1"));
        btn2.setOnClickListener(v -> txtCal.append("2"));
        btn3.setOnClickListener(v -> txtCal.append("3"));
        btn4.setOnClickListener(v -> txtCal.append("4"));
        btn5.setOnClickListener(v -> txtCal.append("5"));
        btn6.setOnClickListener(v -> txtCal.append("6"));
        btn7.setOnClickListener(v -> txtCal.append("7"));
        btn8.setOnClickListener(v -> txtCal.append("8"));
        btn9.setOnClickListener(v -> txtCal.append("9"));
        btn0.setOnClickListener(v -> txtCal.append("0"));

        // Clear the screen
        btnClear.setOnClickListener(v -> txtCal.setText(""));

        // Operator buttons functionality
        btnAdd.setOnClickListener(v -> {
            String input = txtCal.getText().toString();
            if (!input.isEmpty()) {
                value1 = Double.parseDouble(input);
                isAdd = true;
                txtCal.setText("");
            }
        });

        btnSub.setOnClickListener(v -> {
            String input = txtCal.getText().toString();
            if (!input.isEmpty()) {
                value1 = Double.parseDouble(input);
                isSub = true;
                txtCal.setText("");
            }
        });

        btnMul.setOnClickListener(v -> {
            String input = txtCal.getText().toString();
            if (!input.isEmpty()) {
                value1 = Double.parseDouble(input);
                isMul = true;
                txtCal.setText("");
            }
        });

        btnDiv.setOnClickListener(v -> {
            String input = txtCal.getText().toString();
            if (!input.isEmpty()) {
                value1 = Double.parseDouble(input);
                isDiv = true;
                txtCal.setText("");
            }
        });

        // Calculate the result
        btnCal.setOnClickListener(v -> {
            String input = txtCal.getText().toString();
            if (!input.isEmpty()) {
                value2 = Double.parseDouble(input);
                if (isAdd) {
                    txtCal.setText(String.valueOf(value1 + value2));
                    isAdd = false;
                } else if (isSub) {
                    txtCal.setText(String.valueOf(value1 - value2));
                    isSub = false;
                } else if (isMul) {
                    txtCal.setText(String.valueOf(value1 * value2));
                    isMul = false;
                } else if (isDiv) {
                    if (value2 != 0) {
                        txtCal.setText(String.valueOf(value1 / value2));
                    } else {
                        txtCal.setText("Error");
                    }
                    isDiv = false;
                }
            }
        });
    }
}
