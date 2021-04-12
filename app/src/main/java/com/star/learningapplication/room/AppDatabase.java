package com.star.learningapplication.room;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.star.learningapplication.room.model.order.BuyOrder;
import com.star.learningapplication.room.model.order.BuyOrderDao;
import com.star.learningapplication.room.model.order.SellerOrder;
import com.star.learningapplication.room.model.order.SellerOrderDao;
import com.star.learningapplication.room.model.user.User2;
import com.star.learningapplication.room.model.user.UserDao;

@Database(entities = {User2.class, BuyOrder.class, SellerOrder.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "FireCoinDatabase.db";
    private static AppDatabase instance;

    /**
     * @author Aloha
     * @date 2020/10/20 23:24
     * @explain 返回使用 @Dao 注释的类的抽象方法。
     */
    public abstract UserDao userDao();

    public abstract BuyOrderDao buyOrderDao();

    public abstract SellerOrderDao sellerOrderDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            /**
             * @author Aloha
             * @date 2020/10/20 23:25
             * @explain 获取已创建的数据库的实例
             */
            instance = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);
                }

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }

                @Override
                public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
                    super.onDestructiveMigration(db);
                }
            }).allowMainThreadQueries().build();
        }
        return instance;
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

    /**
     * @author Aloha
     * @date 2020/11/30 17:23
     * @explain 数据库升级
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE User"
                    + " ADD COLUMN merchant BOOLEAN");
        }
    };
}