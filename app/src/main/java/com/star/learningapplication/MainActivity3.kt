package com.star.learningapplication

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.SkinAppCompatDelegateImpl
import androidx.databinding.DataBindingUtil
import com.star.learningapplication.databinding.ActivityMain3Binding
import com.star.learningapplication.mvvm.viewmodel.SharedViewModel
import com.google.android.material.snackbar.Snackbar
import skin.support.SkinCompatManager

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding
    private val viewModel: SharedViewModel by viewModels()
    var choose: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main3)

        /**
         * @author Aloha
         * @date 2021/2/12 18:50
         * @explain viewBinding.  已知绑定生成的绑定类
         */
        /*binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)*/

        /**
         * @author Aloha
         * @date 2021/2/12 21:55
         * @explain 无法预先知道绑定类型,使用以下方法泛型返回
         */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main3)
        setSupportActionBar(binding.toolbar)
        binding.fab.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Snackbar.make(v!!, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                choose = if(choose){
                    SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN)
                    false
                } else{
                    SkinCompatManager.getInstance().restoreDefaultTheme()
                    true
                }
            }
        })
        binding.includeHead.tv.text = "hahahah"

        //viewModel = ViewModelProvider(this).get(SharedViewModel.class)
        //ViewModelProviders.of(this).get(MyViewModel.class);
        binding.viewmodel = viewModel
        //需要换肤的资源为R.color.windowBackgroundColor, 添加对应资源R.color.windowBackgroundColor_night。
        //SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN); // 后缀加载
        //SkinCompatManager.getInstance().loadSkin("night", SkinCompatManager.SKIN_LOADER_STRATEGY_PREFIX_BUILD_IN); // 前缀加载
    }


    override fun getDelegate(): AppCompatDelegate {
        return SkinAppCompatDelegateImpl.get(this, this)
    }
}
