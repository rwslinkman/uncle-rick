package nl.rwslinkman.unclerick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import nl.rwslinkman.unclerick.persistence.FileStorageExample;
import nl.rwslinkman.unclerick.persistence.SharedPreferencesExample;
import nl.rwslinkman.unclerick.persistence.database.SqliteExample;

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
        new FileStorageExample(this).example();
        new SqliteExample(this).example();
    }
}
