package com.example.kin.kotlindemo.db.gen

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.kin.kotlindemo.MyApp
import com.example.kin.kotlindemo.base.BaseConfig
import com.example.kin.kotlindemo.db.dao.DaoMaster
import com.example.kin.kotlindemo.db.dao.DaoSession

/**
 *作者：kin
 *时间:2018/12/26 18:11
 *email:549064230@qq.com
 */
class DbManager {
    private var mDevOpenHelper: DaoMaster.DevOpenHelper? = null
    private var mDaoMaster: DaoMaster? = null
    private var mDaoSession: DaoSession? = null
    private val context: Context = MyApp.getInstanc()!!.applicationContext
    private var instance: DbManager? = null

    init {
        mDevOpenHelper =  DaoMaster.DevOpenHelper(context, BaseConfig.DB_NAME)
        getDaoMaster()
        getDaoSession()
    }


    companion object {

        val instance: DbManager by lazy { DbManager() }

    }

    /**
     * 获取可读数据库
     *
     * @param context
     * @return
     */
    fun getReadableDatabase(): SQLiteDatabase? {
        if (null == mDevOpenHelper) {
            instance
        }
        return mDevOpenHelper?.getReadableDatabase()
    }


    /**
     * 获取可写数据库
     *
     * @param context
     * @return
     */
    fun getWritableDatabase(): SQLiteDatabase? {
        if (null == mDevOpenHelper) {
            instance
        }
        return mDevOpenHelper?.getWritableDatabase()
    }


    fun getDaoMaster(): DaoMaster? {
        if (null == mDaoMaster) {
            synchronized(DbManager::class.java) {
                mDaoMaster = DaoMaster(getWritableDatabase())
            }
        }
        return mDaoMaster
    }

    fun getDaoSession(): DaoSession? {
        if (null == mDaoSession) {
            synchronized(DbManager::class.java) {
                mDaoSession = getDaoMaster()?.newSession()
            }
        }
        return mDaoSession
    }

    fun exeSql(sql: String) {
        exeSql(sql, null)

    }

    fun exeSql(sql: String, selectionArgs: Array<String>?) {
        getDaoSession()!!.database.rawQuery(sql, selectionArgs)
    }


}