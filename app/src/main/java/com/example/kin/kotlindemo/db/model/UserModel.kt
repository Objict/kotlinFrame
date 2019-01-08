package com.example.kin.kotlindemo.db.model

import com.example.kin.kotlindemo.db.dao.KUserDao
import com.example.kin.kotlindemo.db.entity.KUser
import com.example.kin.kotlindemo.db.gen.BaseModel
import io.reactivex.Observable
import org.greenrobot.greendao.AbstractDao
import org.greenrobot.greendao.query.QueryBuilder
import java.util.concurrent.Callable

/**
 *作者：kin
 *时间:2018/12/27 13:57
 *email:549064230@qq.com
 */
class UserModel : BaseModel<KUser, String>() {

    override fun getQueryBuilder(): QueryBuilder<KUser>? {
        return getDaoSession().queryBuilder(KUser::class.java)
    }

    override fun getAbstractDao(): AbstractDao<KUser, String> {
        return getDaoSession().kUserDao
    }

    companion object {
        val instance: UserModel by lazy { UserModel() }
    }

    fun getUserByGreen(account: String): Observable<KUser>? {
        return makObservable(Callable {
            val qb = getQueryBuilder()!!
            qb.where(KUserDao.Properties.Uaccount.eq(account))
            var kUser = qb.unique()
            if(kUser == null){ kUser = KUser() }
            return@Callable kUser
        })
    }

    fun getUserBySql(account: String): Observable<MutableList<KUser>>? {
        return exeSql("select * from " + KUserDao.TABLENAME + " where " + KUserDao.Properties.Uaccount.columnName + "=?", account)
    }
}