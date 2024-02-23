package com.company.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtweight, edtheightft, edtheightinc;
        Button show;
        TextView result;
//        LinearLayout llMain;
//

        edtweight = findViewById(R.id.edtwight);
        edtheightft = findViewById(R.id.edtheightft);
        edtheightinc = findViewById(R.id.edtheightinc);
        show = findViewById(R.id.show);
        result = findViewById(R.id.result);
//        llMain = findViewById(R.id.llmain);

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtweight.getText().toString());
                int ft = Integer.parseInt(edtheightft.getText().toString());
                int inc = Integer.parseInt(edtheightinc.getText().toString());

                int totalInc = ft * 12 + inc;
                double totalcm = totalInc * 2.53;
                double totalM = totalcm/100;

                double bmi = wt / (totalM * totalM);

                if (bmi > 25) {
                    result.setVisibility(View.VISIBLE);
                    result.setText("You're OverWeight");
//                    llMain.setBackgroundColor(getResources().getColor(R.color.wtov));
                } else if (bmi < 18) {
                    result.setVisibility(View.VISIBLE);
                    result.setText("You're underWeight");
//                    llMain.setBackgroundColor(getResources().getColor(R.color.wtun));
                } else {
                    result.setVisibility(View.VISIBLE);
                    result.setText("You're Healthy");
//                    llMain.setBackgroundColor(getResources().getColor(R.color.hl));
                }

            }
        });

    }
}