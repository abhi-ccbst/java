package com.example.lecture_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Observable;
import java.util.Observer;
public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {
    private Model model;
    private Button button1;
    private Button button2;
    private Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        model = new Model();
        model.addObserver(this);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button) {
            model.setValueAtIndex(0);
        } else if (v.getId() == R.id.button2) {
            model.setValueAtIndex(1);
        } else if (v.getId() == R.id.button3) {
            model.setValueAtIndex(2);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        button1.setText("Count : " + model.getValueAtIndex(0));
        button2.setText("Count : " + model.getValueAtIndex(1));
        button3.setText("Count : " + model.getValueAtIndex(2));
    }
}
