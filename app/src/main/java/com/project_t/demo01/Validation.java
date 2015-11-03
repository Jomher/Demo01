package com.project_t.demo01;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by isai on 10-12-15.
 */
public abstract class Validation implements TextWatcher {
    private final TextView textView;

    public Validation (TextView textView) {
        this.textView = textView;
    }

    public abstract void validate(TextView textView,String text);

    @Override
    final public void afterTextChanged(Editable s) {

    }
    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) { /* Don't care */ }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {
        String text = textView.getText().toString();
        validate(textView, text);
    }
}


