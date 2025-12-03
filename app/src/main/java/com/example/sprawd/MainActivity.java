package com.example.sprawd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
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

        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        ArrayAdapter<CharSequence> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Wygenerowane hasło");
                builder.setMessage(generatePassword(check1.isChecked(), check2.isChecked(), check3.isChecked()))
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Xd!
                            }
                        });
                builder.create().show();
            }
        });
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Wygenerowane hasło");
                builder.setMessage("Imię: "+nameInput.getText().toString() + "\n" +
                                "Nazwisko: "+surnameInput.getText().toString() + "\n" +
                                "Stanowisko: "+surnameInput.getText().toString() + "\n" +
                                "Hasło: "+generatePassword(check1.isChecked(), check2.isChecked(), check3.isChecked()) + "\n")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Xd!
                            }
                        });
                builder.create().show();
            }
        });
    }

    String generatePassword(boolean u, boolean d, boolean s) {
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "1234567890";
        String symbols = "!@#$%^&*()_+-=.";


        Random rnd = new Random();
        String pass = "";

        for (int i = 0; i < 8; i++) {
            if (i == 0 && u) pass += upper.charAt(rnd.nextInt(upper.length()));
            else if (i == 1 && d) pass += digits.charAt(rnd.nextInt(digits.length()));
            else if (i == 2 && s) pass += symbols.charAt(rnd.nextInt(symbols.length()));
            else pass += lower.charAt(rnd.nextInt(lower.length()));
        }
        return pass;
    }
}