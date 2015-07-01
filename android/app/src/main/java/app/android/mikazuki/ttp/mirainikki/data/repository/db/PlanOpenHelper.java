package app.android.mikazuki.ttp.mirainikki.data.repository.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import app.android.mikazuki.ttp.mirainikki.data.repository.db.model.PlanContract;

/**
 * Created by 01006510 on 2015/06/28.
 */
public class PlanOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "myapp.db";
    public static final int DB_VERSION = 2;
    public static final String CREATE_TABLE =
            "create table " + PlanContract.Plans.TABLE_NAME + " (" +
                    PlanContract.Plans._ID + " integer primary key autoincrement, " +
                    PlanContract.Plans.COL_DATE+ " text," +
                    PlanContract.Plans.COL_CONTENT + " text)";
    public static final String INIT_TABLE =
            "insert into plans (date, content) values " +
                    "('yy/mm/01', 'hoge'), " +
                    "('yy/mm/02', 'fuga'), " +
                    "('yy/mm/03', 'piyo')";
    public static final String DROP_TABLE =
            "drop table if exists plans";

    public PlanOpenHelper(Context c) {
        super(c, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create table
        sqLiteDatabase.execSQL(CREATE_TABLE);
        // init table
        sqLiteDatabase.execSQL(INIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // drop table
        sqLiteDatabase.execSQL(DROP_TABLE);
        // onCreate
        onCreate(sqLiteDatabase);
    }
}