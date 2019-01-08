package com.example.kin.kotlindemo.db.gen

import android.database.Cursor
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import org.greenrobot.greendao.AbstractDao
import org.greenrobot.greendao.InternalQueryDaoAccess
import org.greenrobot.greendao.query.QueryBuilder
import java.util.concurrent.Callable

/**
 *作者：kin
 *时间:2018/12/27 13:51
 *email:549064230@qq.com
 */
open abstract class BaseModel<T, K> {
    var dbManager: DbManager? = null
    private var daoAccess: InternalQueryDaoAccess<T>? = null

    init {
        dbManager = DbManager.instance
        daoAccess = InternalQueryDaoAccess(getAbstractDao())
    }

    fun makObservable(funs: Callable<T>): Observable<T>? {
        return Observable.fromCallable(funs).subscribeOn(Schedulers.io())
    }

    fun getDaoSession() = dbManager!!.getDaoSession()!!

    fun exeSql(sql: String, vararg arg: String?): Observable<MutableList<T>> {
        val cursor = getDaoSession().database.rawQuery(sql, arg)
        return Observable.fromCallable { daoAccess!!.loadAllAndCloseCursor(cursor) }.subscribeOn(Schedulers.io())
    }

    abstract fun getAbstractDao(): AbstractDao<T, K>
    abstract fun getQueryBuilder(): QueryBuilder<T>?
}
