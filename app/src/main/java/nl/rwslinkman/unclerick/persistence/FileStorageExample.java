package nl.rwslinkman.unclerick.persistence;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStorageExample {
    private static final String TAG = "FileStorageExample";
    private static final String FILE_NAME = "saveThisFilePlease.txt";
    private static final String FILE_CONTENT = "This is the files' content";

    private Context storageContext;

    public FileStorageExample(Context context) {
        this.storageContext = context;
    }

    public void example() {
        try {
            // Write to file
            FileOutputStream fos = storageContext.openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            fos.write(FILE_CONTENT.getBytes());
            fos.close();
            Log.d(TAG, "example: Content written to File");

            // Read from file
            FileInputStream fis = storageContext.openFileInput(FILE_NAME);
            int content;
            StringBuilder result = new StringBuilder();
            while ((content = fis.read()) != -1) {
                char readChar = (char) content;
                result.append(readChar);
            }
            String readResult = result.toString();
            Log.d(TAG, "example: Read result = " + readResult);

            // External
            boolean writable = isExternalStorageWritable();
            boolean readable = isExternalStorageReadable();
            System.out.println("Can I write? " + Boolean.toString(writable));
            System.out.println("Can I read? " + Boolean.toString(readable));

        } catch (IOException e) {
            Log.e(TAG, "example: Helemaal kapot!");
            // Sum ting wong
            e.printStackTrace();
        }
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
    }
}