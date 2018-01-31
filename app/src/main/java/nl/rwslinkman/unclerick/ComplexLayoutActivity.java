package nl.rwslinkman.unclerick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ComplexLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex);

        findViewById(R.id.button_to_linear).setOnClickListener(this);
        findViewById(R.id.button_to_relative).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Class destination;
        switch (v.getId()) {
            case R.id.button_to_relative:
                destination = RelativeActivity.class;
                break;
            case R.id.button_to_linear:
                destination = LinearActivity.class;
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
