package com.devtau.popularmovies.database.tables;

import android.content.ContentValues;
import android.provider.BaseColumns;
import com.devtau.popularmovies.database.MySQLHelper;
import com.devtau.popularmovies.model.Movie;
import com.devtau.popularmovies.util.Util;

public abstract class MoviesTable {
    public static final String TABLE_NAME = "Movie";

    public static final String DATE = "date";
    public static final String PRICE = "price";
    public static final String DESCRIPTION = "description";
//    public static final String SHIFT_ID = "shiftID";

    public static final String FIELDS = MySQLHelper.PRIMARY_KEY
            + DATE + " TEXT, "
            + PRICE + " INTEGER, "
            + DESCRIPTION + " TEXT";

    public static ContentValues getContentValues(Movie item) {
        ContentValues cv = new ContentValues();
        if (item.getId() != -1) {
            cv.put(BaseColumns._ID, item.getId());
        }
        cv.put(DATE, Util.dateFormat.format(item.getDate().getTime()));
        cv.put(PRICE, item.getPrice());
        cv.put(DESCRIPTION, item.getDescription());
        return cv;
    }
}

/*
http://www.sqlite.org/datatype3.html
INTEGER целое число
TEXT    символьные данные, дата-время as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS")
REAL    вещественное число
NUMERIC логическое значение
BLOB    двоичные большие объекты
*/