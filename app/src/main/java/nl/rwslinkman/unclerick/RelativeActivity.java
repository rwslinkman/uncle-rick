package nl.rwslinkman.unclerick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        TextView tv = findViewById(R.id.my_textview);
        tv.setText("Hello world!");

        findViewById(R.id.button_to_linear).setOnClickListener(this);
        findViewById(R.id.button_to_complex).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class destination;
        switch (v.getId()) {
            case R.id.button_to_linear:
                destination = LinearActivity.class;
                break;
            case R.id.button_to_complex:
                destination = ComplexLayoutActivity.class;
                break;
            default:
                destination = null;
                break;
        }

        if (destination != null) {
            Intent navigationIntent = new Intent(this, destination);
            startActivity(navigationIntent);
        }
    }
}
