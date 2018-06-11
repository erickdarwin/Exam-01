package pe.edu.erickdqs.upeurestexam.dbcon;

import android.content.Context;

import pe.edu.upeu.dbexterno.ExternalSQLiteOpenHelper;


public class DBConn extends ExternalSQLiteOpenHelper {

    private static final String DATABASE_NAME="asistenciadb.db";
    private static final int DATABASE_VERSION=3;

    public DBConn(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
