package com.star.learningapplication.room.model.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    /**
     * @author Aloha
     * @date 2020/10/20 23:29
     * @explain DAO 既可以是接口，也可以是抽象类。如果是抽象类，则该 DAO 可以选择有一个以 RoomDatabase 为唯一参数的构造函数。Room 会在编译时创建每个 DAO 实现。
     */

    /**
     * @author Aloha
     * @date 2020/10/20 23:30
     * @explain 用户登陆存储信息
     */
    @Insert
    void loginUser(User2 user);

    /**
     * @author Aloha
     * @date 2020/10/20 23:34
     * @explain 获取用户表数据
     */
    @Query("SELECT * FROM User2")
    User2[] loadUser();

    /*@Query("SELECT * FROM User limit 0, 1")
    User loadUser();*/

    /**
     * @author Aloha
     * @date 2020/10/20 23:31
     * @explain 用户信息更新
     */
    @Update
    void updateUser(User2 user);

    /**
     * @author Aloha
     * @date 2020/10/20 23:33
     * @explain 用户信息删除
     */
    @Delete
    void deleteUser(User2[] user);
}
