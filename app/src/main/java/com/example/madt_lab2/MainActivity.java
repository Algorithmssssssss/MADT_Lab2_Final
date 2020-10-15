package com.example.madt_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner OptionDrop;
    private EditText inputText;
    private TextView charCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputText = findViewById(R.id.InputText);
        this.OptionDrop = (Spinner) findViewById(R.id.OptionDrop);
        this.charCount = findViewById(R.id.CharCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Option_Array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.OptionDrop.setAdapter(adapter);



    }

    public void getCount(View view) {
        String textString = this.inputText.getText().toString();
        if (textString.matches(""))
        {
            Toast.makeText(this, "You did not input any text", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(OptionDrop.getSelectedItem().toString().equalsIgnoreCase(getResources().getString(R.string.char_selection)))
            {
                String inputString = this.inputText.getText().toString();
                this.charCount.setText("Chars Count:" + Counter.getCharLength(inputString));

            }
            else
            {
                String userWord = inputText.getText().toString();
                charCount.setText("Words: " + Counter.getWordsCount(userWord));
            }
        }

    }
}