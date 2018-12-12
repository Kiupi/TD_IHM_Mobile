package com.example.quent.tdmobileihm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Button saveButton;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        initView();
    }

    private void initView() {
        editTextName = findViewById(R.id.activity_edit_textInput_name);
        saveButton = findViewById(R.id.activity_edit_button_validate);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
    }

    private void saveData() {
        String name = editTextName.getText().toString();

        if (!name.isEmpty()) {
            DataManager.getInstance().addItem(name);
        } else{
            Toast.makeText(this,
                    "Veuillez saisir votre nom",
                    Toast.LENGTH_SHORT)
                    .show();
        }

        finish();
    }

}
