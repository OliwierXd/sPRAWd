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
                Character[] lower = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
                Character[] upper = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
                Character[] digits = {'1', '2','3','4','5','6','7','8','9','0'};
                Character[] symbols = {'!', '?',  '@', '#', '$', '%', '&'};
                ArrayList<Character> all = new ArrayList<Character>();

                if (check1.isChecked()) {
                    all.addAll(Arrays.asList(lower));
                    all.addAll(Arrays.asList(upper));
                },
                if (check2.isChecked()) all.addAll(Arrays.asList(digits));
                if (check3.isChecked()) all.addAll(Arrays.asList(symbols));

                Random rnd = new Random();
                String pass = "";

                for (int i = 0; i < 8; i++) {
                    pass += all.get(rnd.nextInt(all.size()));
                }

                Toast.makeText(MainActivity.this, pass, Toast.LENGTH_SHORT).show();
            }
        });
    }
}