package com.example.ass03loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditUserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btdone;
    private EditText edUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_user);
        edUser = (EditText)findViewById(R.id.edUser);
        btdone = (Button)findViewById(R.id.btDone);
        btdone.setOnClickListener(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("USER_NAME");
        edUser.setText(username);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btDone:
                onDone();
                break;
            default:
                break;

        }
    }

    private void onDone() {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("RESULT",edUser.getText().toString());
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
