package com.example.profile_datamodel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nameInput;
    Button saveButton;
    Profile profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.nameEditText);
        saveButton = findViewById(R.id.submitButton);

        profile = new Profile();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameInput.getText().toString();

                if (name.isEmpty()) {
                    Toast.makeText(MainActivity.this, "نام را وارد کنید", Toast.LENGTH_SHORT).show();
                } else {
                    profile.setName(name);

                    Intent i = new Intent(MainActivity.this, ProfileActivity.class);
                    i.putExtra("USER_NAME", profile.getName());
                    startActivity(i);
                }
            }
        });
    }
}
