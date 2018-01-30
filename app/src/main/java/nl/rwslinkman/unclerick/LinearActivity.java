package nl.rwslinkman.unclerick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nl.rwslinkman.unclerick.persistence.SharedPreferencesExample;

public class LinearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new SharedPreferencesExample(this).example();
    }
}
