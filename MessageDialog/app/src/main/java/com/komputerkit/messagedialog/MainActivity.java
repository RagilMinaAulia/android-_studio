package com.komputerkit.messagedialog;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        System.out.println("oncreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onstart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        System.out.println("onresume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onpause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onstop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ondestroy");
    }
}