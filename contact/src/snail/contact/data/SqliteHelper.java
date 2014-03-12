package snail.contact.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by fenghb on 3/12/14.
 */
public abstract class SqliteHelper extends SQLiteOpenHelper {
    /**
     * tag
     */

    private static final String TAG = "SqliteHelper";

    /**
     * sqlite database name
     */
    private static final String DATABASE_NAME = "im.db";

    /**
     * sqlite database version
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * sqlite database cursor factory
     */
    private static final CursorFactory factory = null;


    /**
     * construct method
     */
    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    /**
     * create tables
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

}
