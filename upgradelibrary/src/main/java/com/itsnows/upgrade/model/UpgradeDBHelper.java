package com.itsnows.upgrade.model;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: itsnows
 * E-mail: xue.com.fei@outlook.com
 * CreatedTime: 2018/2/6 22:21
 * <p>
 * UpgradeDBHelper
 */
public class UpgradeDBHelper extends SQLiteOpenHelper {

    /**
     * 数据库名称
     */
    private static final String DB_NAME = "upgrade.db";

    /**
     * 数据库版本
     */
    private static final int DB_VERSION = 1;

    /**
     * 版本忽略表
     */
    private static final String SQL_CREATE_UPGRADE_VERSION = "CREATE TABLE IF NOT EXISTS "
            + UpgradePersistenceContract.UpgradeVersionEntry.TABLE_NAME + " ("
            + UpgradePersistenceContract.UpgradeVersionEntry.COLUMN_NAME_VERSION + " INTEGER NOT NULL,"
            + UpgradePersistenceContract.UpgradeVersionEntry.COLUMN_NAME_IS_IGNORED + " INTEGER,PRIMARY KEY("
            + UpgradePersistenceContract.UpgradeVersionEntry.COLUMN_NAME_VERSION + "))";

    /**
     * 版本缓存表
     */
    private static final String SQL_CREATE_UPGRADE_BUFFER = "CREATE TABLE IF NOT EXISTS "
            + UpgradePersistenceContract.UpgradeBufferEntry.TABLE_NAME + " ("
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_DOWNLOAD_URL + " TEXT NOT NULL,"
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_FILE_MD5 + " TEXT,"
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_FILE_LENGTH + " INTEGER,"
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_BUFFER_LENGTH + " INTEGER,"
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_BUFFER_PART + " INTEGER,"
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_LAST_MODIFIED + " INTEGER,PRIMARY KEY("
            + UpgradePersistenceContract.UpgradeBufferEntry.COLUMN_NAME_DOWNLOAD_URL + "))";

    public UpgradeDBHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }

    public UpgradeDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null);
    }

    public UpgradeDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_UPGRADE_VERSION);
        db.execSQL(SQL_CREATE_UPGRADE_BUFFER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public synchronized SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public synchronized SQLiteDatabase getReadableDatabase() {
        return super.getReadableDatabase();
    }

    @Override
    public synchronized void close() {
        super.close();
    }

}
