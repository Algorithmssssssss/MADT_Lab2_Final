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
    private EditText InputText;
    private TextView CharCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InputText = findViewById(R.id.InputText);
        this.OptionDrop = (Spinner) findViewById(R.id.OptionDrop);
        this.CharCount = findViewById(R.id.CharCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Option_Array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.OptionDrop.setAdapter(adapter);



    }

    public void GetCount(View view) {
        String UserInputText = this.InputText.getText().toString();
        if (UserInputText.matches(""))
        {
            Toast.makeText(this, "You did not input any text", Toast.LENGTH_LONG).show();
        }
        else
        {
            if(OptionDrop.getSelectedItem().toString().equalsIgnoreCase(getResources().getString(R.string.char_selection)))
            {
                String InputTextStr = this.InputText.getText().toString();
                this.CharCount.setText("Chars Count:" + Counter.getCharLength(InputTextStr));

            }
            else
            {
                String UserInputWord = InputText.getText().toString();
                CharCount.setText("Words: " + Counter.getWordsCount(UserInputWord));
            }
        }

    }
}