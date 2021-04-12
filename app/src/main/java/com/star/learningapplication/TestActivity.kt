package com.star.learningapplication

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.star.learningapplication.databinding.ActivityTestBinding
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        binding.tvHello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                doPost()


            }
        })


        val okHttpClientBuilder = OkHttpClient.Builder().addInterceptor { chain ->
            val originalRequest = chain.request()
            val originalHttpUrl = originalRequest.url
            val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("access_token", "gg")
                    .build()
            val request = originalRequest.newBuilder()
                    .url(url)
                    .method(originalRequest.method, originalRequest.body)
                    .addHeader("head1", "value1")
                    .addHeader("head2", "value2")
                    .build()
            chain.proceed(request)
        }

        val okHttpClientBuilder2 = OkHttpClient.Builder().addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                TODO("Not yet implemented")
            }
        })
    }


   fun doPost(){

   }
}