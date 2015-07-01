package app.android.mikazuki.ttp.mirainikki.data.repository.db.model;

import android.provider.BaseColumns;

/**
 * Created by 01006510 on 2015/06/28.
 */
public final class PlanContract {

    public PlanContract() {
    }

    public static abstract class Plans implements BaseColumns {
        public static final String TABLE_NAME = "plans";
        public static final String COL_DATE = "date";
        public static final String COL_CONTENT = "content";
    }

}
