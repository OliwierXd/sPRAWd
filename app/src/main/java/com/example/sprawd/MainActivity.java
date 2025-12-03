package com.example.sprawd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button generateBtn = findViewById(R.id.generateBtn);
        Button submitBtn = findViewById(R.id.submitBtn);
        EditText nameInput = findViewById(R.id.nameInput);
        EditText surnameInput = findViewById(R.id.surnameInput);
        EditText countInput = findViewById(R.id.countInput);
        CheckBox check1 = findViewById(R.id.check1);
        CheckBox check2 = findViewById(R.id.check2);
        CheckBox check3 = findViewById(R.id.check3);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lower = "abcdefghijklmnopqrstuvwxyz";
                String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                String digits = "1234567890";
                String symbols = "!@#$%^&*()_+-=.";


                Random rnd = new Random();
                String pass = "";

                for (int i = 0; i < 8; i++) {
                    if (i == 0 && check1.isChecked()) pass += upper.charAt(rnd.nextInt(upper.length()));
                    else if (i == 1 && check2.isChecked()) pass += digits.charAt(rnd.nextInt(digits.length()));
                    else if (i == 2 && check3.isChecked()) pass += symbols.charAt(rnd.nextInt(symbols.length()));
                    else pass += lower.charAt(rnd.nextInt(lower.length()));
                }

                Toast.makeText(MainActivity.this, pass, Toast.LENGTH_SHORT).show();
            }
        });
    }
}