package nl.rwslinkman.unclerick.persistence.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UncleDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UncleRick.db";
    private static final int DATABASE_VERSION = 1;

    public UncleDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `" + UncleDatabaseContract.WordTable.TABLE_NAME + "` (" +
                "`" + UncleDatabaseContract.WordTable._ID + "` INTEGER PRIMARY KEY, " +
                "`" + UncleDatabaseContract.WordTable.COLUMN_NAME_WORD + "` VARCHAR(255) " +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE `woorden`");
        }
    }
}
