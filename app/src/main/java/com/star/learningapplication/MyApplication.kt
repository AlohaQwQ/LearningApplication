package com.star.learningapplication

import android.app.Application
import skin.support.SkinCompatManager
import skin.support.app.SkinAppCompatViewInflater
import skin.support.app.SkinCardViewInflater
import skin.support.constraint.app.SkinConstraintViewInflater
import skin.support.design.app.SkinMaterialViewInflater

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        SkinCompatManager.withoutActivity(this)
            .addInflater(object : SkinAppCompatViewInflater(){})           // 基础控件换肤初始化
            .addInflater(object : SkinMaterialViewInflater(){})            // material design 控件换肤初始化[可选]
            .addInflater(object : SkinConstraintViewInflater(){})          // ConstraintLayout 控件换肤初始化[可选]
            .addInflater(object : SkinCardViewInflater(){})                // CardView v7 控件换肤初始化[可选]
            .setSkinStatusBarColorEnable(true)                     // 关闭状态栏换肤，默认打开[可选]
            .setSkinWindowBackgroundEnable(true)                   // 关闭windowBackground换肤，默认打开[可选]
            .loadSkin();
    }


}