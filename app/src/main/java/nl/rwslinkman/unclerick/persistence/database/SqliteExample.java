package nl.rwslinkman.unclerick.persistence.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SqliteExample {
    private static final String TAG = "SqliteExample";
    private Context context;

    public SqliteExample(Context context) {
        this.context = context;
    }

    public void example() {

        UncleDatabaseHelper helper = new UncleDatabaseHelper(this.context);

        SQLiteDatabase database = helper.getWritableDatabase();
        ContentValues myRowToCreate = new ContentValues();
        myRowToCreate.put(UncleDatabaseContract.WordTable.COLUMN_NAME_WORD, "koekwaus");

        long insertedColumnId = database.insert(UncleDatabaseContract.WordTable.TABLE_NAME, null, myRowToCreate);

        String insertedMessage = String.format(Locale.US, "Created new row in table '%s' with id %d",
                UncleDatabaseContract.WordTable.COLUMN_NAME_WORD, insertedColumnId);

        Log.d(TAG, "example: " + insertedMessage);


        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                UncleDatabaseContract.WordTable._ID,
                UncleDatabaseContract.WordTable.COLUMN_NAME_WORD,
        };
        Cursor cursor = db.query(
                UncleDatabaseContract.WordTable.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        List<String> items = new ArrayList<>();
        while (cursor.moveToNext()) {
            int columnIndex = cursor.getColumnIndexOrThrow(UncleDatabaseContract.WordTable._ID);
            long itemId = cursor.getLong(columnIndex);
            String msg = String.format(Locale.US, "example: Read item %d from the database", itemId);
            Log.d(TAG, msg);

            int wordColumnIndex = cursor.getColumnIndexOrThrow(UncleDatabaseContract.WordTable.COLUMN_NAME_WORD);
            String itemWord = cursor.getString(wordColumnIndex);
            items.add(itemWord);
        }
        cursor.close();

        Log.d(TAG, "example: Finished reading words from the database");
        for (String item : items) {
            Log.d(TAG, "example: " + item);
        }
    }
}
