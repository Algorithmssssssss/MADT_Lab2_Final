package com.example.madt_lab2;

import android.widget.EditText;

public class Counter
{
    public static String getCharLength(String text)
    {
        return String.valueOf(text.length());
    }

    public static int getWordsCount(String text)
    {
        text = text.replace(".", "").replace(",", "");
        String[] textArray = text.split(" ");

        return textArray.length;
    }
}

