package nl.rwslinkman.unclerick.persistence;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferencesExample {

    private static final String TAG = "SharedPreferencesExampl";
    private Context prefsContext;
    private static final String PREFS_STORAGE_NAME = "iStoreSuperSecretDataHere";

    public SharedPreferencesExample(Context c) {
        this.prefsContext = c;
    }

    public void example() {

        SharedPreferences preferences = prefsContext.getSharedPreferences(PREFS_STORAGE_NAME, Context.MODE_PRIVATE);
        Log.d(TAG, "example: The preference object is obtained");

        // Getting a value is easy
        String obtainedString = preferences.getString("myFirstString", "defaultInCaseNotFound");
        int obtainedInteger = preferences.getInt("myFirstInt", 420);
        Log.d(TAG, "example: myFirstString = " + obtainedString);
        Log.d(TAG, "example: myFirstInt = " + Integer.toString(obtainedInteger));

        // Storing a value is also pretty easy
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("myFirstBoolean", true);
        editor.apply();
    }

}
