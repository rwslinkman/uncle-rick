package nl.rwslinkman.unclerick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        TextView tv = findViewById(R.id.top_textview);
        tv.setText("Hello world!");

    }
}
