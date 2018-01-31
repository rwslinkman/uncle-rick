package nl.rwslinkman.unclerick.persistence.database;

import android.provider.BaseColumns;

public class UncleDatabaseContract {

    class WordTable implements BaseColumns {
        public static final String TABLE_NAME = "woorden";
        public static final String COLUMN_NAME_WORD = "word";
    }
}
