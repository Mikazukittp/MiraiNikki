package app.android.mikazuki.ttp.mirainikki.data.repository.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import app.android.mikazuki.ttp.mirainikki.data.repository.db.model.PlanContract;

public class PlanContentProvider extends ContentProvider {

    public static final String AUTHORITY = 
            "app.android.mikazuki.ttp.mirainikki";
    public static final Uri CONTENT_URI =
            Uri.parse("content://" + AUTHORITY + "/" + PlanContract.Plans.TABLE_NAME);

    // UriMatcher
    private static final int PLANS = 1;
    private static final int PLAN_ITEM = 2;
    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, PlanContract.Plans.TABLE_NAME, PLANS);
        uriMatcher.addURI(AUTHORITY, PlanContract.Plans.TABLE_NAME+"/#", PLAN_ITEM);
    }



    public PlanContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
