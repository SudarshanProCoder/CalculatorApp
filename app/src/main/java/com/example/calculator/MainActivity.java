package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    ImageView btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_0;
    ImageView btn_plus, btn_multi, btn_module, btn_ac, btn_equal, btn_minus, btn_division, btn_cut, btn_info, btn_dot;
    TextView inputText, outputText;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_plus  = findViewById(R.id.btn_plus);
        btn_multi = findViewById(R.id.btn_multi);
        btn_module  = findViewById(R.id.btn_module);
        btn_ac  = findViewById(R.id.btn_ac);
        btn_equal  = findViewById(R.id.btn_equal);
        btn_minus  = findViewById(R.id.btn_minus);
        btn_division  = findViewById(R.id.btn_extra);
        btn_cut  = findViewById(R.id.btn_cut);
        btn_info  = findViewById(R.id.info);
        btn_dot = findViewById(R.id.btn_dot);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);



        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "0");
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "9");
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "+");
            }
        });
        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "%");
            }
        });

        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "x");
            }
        });
        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "-");
            }
        });


        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputText.setText(" ");
                outputText.setText(" ");
            }
        });
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ "÷");

            }
        });
        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                inputText.setText(data+ ".");

            }
        });
        btn_cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
               if(!data.isEmpty()){
                   byte var0 = 0;
                   int var1 = data.length()-1;
                   String txtData = data.substring(var0, var1);
                   inputText.setText(txtData);
               }
            }
        });

        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Developed By Sudarshan Coder", Toast.LENGTH_SHORT).show();

            }
        });


        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = inputText.getText().toString();
                data = data.replaceAll("x", "*");
                data = data.replaceAll("%", "/100");
                data = data.replaceAll("÷", "/");

                Context con = Context.enter();
                con.setOptimizationLevel(-1);
                String finalResult="";
                Scriptable scriptable = con.initStandardObjects();
                finalResult = con.evaluateString(scriptable, data, "javascript", 1,null).toString();
                outputText.setText(finalResult);


            }
        });



    }
}