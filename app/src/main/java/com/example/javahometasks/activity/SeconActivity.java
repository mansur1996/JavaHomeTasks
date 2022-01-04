package com.example.javahometasks.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.javahometasks.R;
import com.example.javahometasks.model.Member;
import com.example.javahometasks.model.User;

public class SeconActivity extends AppCompatActivity {

    static final String TAG = SeconActivity.class.toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secon);

        initViews();
    }
    void initViews(){
        TextView userTextView = findViewById(R.id.tv_user);
        Button backButton = findViewById(R.id.btn_back);

        User user = (User) getIntent().getParcelableExtra("user");
        Log.d(TAG,user.toString());
        userTextView.setText(user.toString());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Member member = new Member(2, "Mansur");
                backToFinish(member);
            }
        });
    }
    void backToFinish(Member member){
        Intent returnIntent = new Intent();
        returnIntent.putExtra("member", member);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}