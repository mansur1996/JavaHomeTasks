package com.example.javahometasks.activity;

import androidx.annotation.Nullable;
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

public class MainActivity extends AppCompatActivity {
    static final String TAG = MainActivity.class.toString();
    int LAUNCH_SECOND = 1;
    TextView teacher_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews(){

        Button nextActivityButton = findViewById(R.id.btn_next_activity);
        teacher_tv = findViewById(R.id.tv_member);

        nextActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(1, "JaxaDev");
                openSecondActivity(user);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == LAUNCH_SECOND){
            if(resultCode == Activity.RESULT_OK){
                Member member = (Member) data.getParcelableExtra("member");
                Log.d(TAG, member.toString());
                teacher_tv.setText(member.toString());
            }
        }
    }

    void openSecondActivity(User user){
        Intent intent = new Intent(this, SeconActivity.class);
        intent.putExtra("user", user);
        //startActivity(intent);
        startActivityForResult(intent, LAUNCH_SECOND);
    }
}