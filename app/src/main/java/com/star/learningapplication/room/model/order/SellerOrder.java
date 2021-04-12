package com.star.learningapplication.room.model.order;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SellerOrder {

    @PrimaryKey(autoGenerate = true)
    public int buyOrderId;

    /**
     * @author Aloha
     * @date 2020/10/23 19:17
     * @explain 订单号
     */
    public String orderID;

    /**
     * @author Aloha
     * @date 2020/10/30 11:22
     * @explain 用户手机号
     */
    public String phoneNo;

    /**
     * @author Aloha
     * @date 2020/10/23 19:17
     * @explain 总金额
     */
    public String amtSum;

    /**
     * @author Aloha
     * @date 2020/10/23 19:17
     * @explain 币数量
     */
    public String bitAmtSum;

    /**
     * @author Aloha
     * @date 2020/10/23 19:18
     * @explain 币种类
     */
    public String bitType;

    /**
     * @author Aloha
     * @date 2020/10/23 19:19
     * @explain 回收单个价格
     */
    public String bitPrice;

    /**
     * @author Aloha
     * @date 2020/10/30 18:32
     * @explain 店铺ID
     */
    public String shopID;

    /**
     * @author Aloha
     * @date 2020/10/30 18:32
     * @explain 店铺名
     */
    public String shopName;

    /**
     * @author Aloha
     * @date 2020/10/23 19:19
     * @explain 付款信息
     */
    public String payInfo;

    /**
     * @author Aloha
     * @date 2020/10/23 19:19
     * @explain 是否成功
     */
    public boolean issuc;

    /**
     * @author Aloha
     * @date 2020/10/23 19:19
     * @explain 订单状态
     */
    public String orderState;

    /**
     * @author Aloha
     * @date 2020/10/23 19:19
     * @explain 订单时间
     */
    public String orderTradTime;

    public SellerOrder(String orderID, String phoneNo, String amtSum, String bitAmtSum, String bitType, String payInfo, String shopID, String shopName, String bitPrice) {
        this.orderID = orderID;
        this.phoneNo = phoneNo;
        this.amtSum = amtSum;
        this.bitAmtSum = bitAmtSum;
        this.bitType = bitType;
        this.payInfo = payInfo;
        this.shopID = shopID;
        this.shopName = shopName;
        this.bitPrice = bitPrice;
    }

    public int getBuyOrderId() {
        return buyOrderId;
    }

    public void setBuyOrderId(int buyOrderId) {
        this.buyOrderId = buyOrderId;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getShopID() {
        return shopID;
    }

    public void setShopID(String shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getBitPrice() {
        return bitPrice;
    }

    public void setBitPrice(String bitPrice) {
        this.bitPrice = bitPrice;
    }

    public String getAmtSum() {
        return amtSum;
    }

    public void setAmtSum(String amtSum) {
        this.amtSum = amtSum;
    }

    public String getBitAmtSum() {
        return bitAmtSum;
    }

    public void setBitAmtSum(String bitAmtSum) {
        this.bitAmtSum = bitAmtSum;
    }

    public String getBitType() {
        return bitType;
    }

    public void setBitType(String bitType) {
        this.bitType = bitType;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public boolean isIssuc() {
        return issuc;
    }

    public void setIssuc(boolean issuc) {
        this.issuc = issuc;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderTradTime() {
        return orderTradTime;
    }

    public void setOrderTradTime(String orderTradTime) {
        this.orderTradTime = orderTradTime;
    }
}
