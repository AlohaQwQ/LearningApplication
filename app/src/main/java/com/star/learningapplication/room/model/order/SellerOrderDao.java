package com.star.learningapplication.room.model.order;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface SellerOrderDao {

    /**
     * @author Aloha
     * @date 2020/10/20 23:29
     * @explain DAO 既可以是接口，也可以是抽象类。如果是抽象类，则该 DAO 可以选择有一个以 RoomDatabase 为唯一参数的构造函数。Room 会在编译时创建每个 DAO 实现。
     */

    @Insert
    void saveSellerOrder(SellerOrder... SellerOrders);

    /**
     * @author Aloha
     * @date 2020/10/20 23:34
     * @explain 获取表数据
     */
    @Query("SELECT * FROM SellerOrder")
    List<SellerOrder> loadSellerOrders();

    /**
     * @author Aloha
     * @date 2020/10/28 20:30
     * @explain 根据订单编号查询
     */
    @Query("SELECT * FROM SellerOrder WHERE orderID IN (:orderID)")
    SellerOrder loadSellerOrderByOrderID(String orderID);

    /**
     * @author Aloha
     * @date 2020/10/28 20:30
     * @explain 根据用户手机号查询
     */
    @Query("SELECT * FROM SellerOrder WHERE phoneNo IN (:phoneNo)")
    List<SellerOrder> loadSellerOrderByUserPhone(String phoneNo);

    /**
     * @author Aloha
     * @date 2020/10/20 23:33
     * @explain 表删除
     */
    @Delete
    void deleteSellerOrders(List<SellerOrder> sellerOrders);


}