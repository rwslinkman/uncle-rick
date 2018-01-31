package nl.rwslinkman.unclerick;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import nl.rwslinkman.unclerick.persistence.FileStorageExample;
import nl.rwslinkman.unclerick.persistence.SharedPreferencesExample;
import nl.rwslinkman.unclerick.persistence.database.SqliteExample;

public class LinearActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);

        findViewById(R.id.button_to_relative).setOnClickListener(this);
        findViewById(R.id.button_to_complex).setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new SharedPreferencesExample(this).example();
        new FileStorageExample(this).example();
        new SqliteExample(this).example();
    }

    @Override
    public void onClick(View v) {
        Class destination;
        switch (v.getId()) {
            case R.id.button_to_relative:
                destination = RelativeActivity.class;
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
