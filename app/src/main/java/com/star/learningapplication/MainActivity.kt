package com.star.learningapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.star.learningapplication.databinding.ActivityMainBinding
import com.star.learningapplication.network.NetworkOperator
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)
        binding.tvHello.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }
        })


        /*var tvHello = findViewById<TextView>(R.id.tv_hello).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                TODO("Not yet implemented")
            }
        })*/

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


        /*if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();
            builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
            builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);
            NetworkRequest request = builder.build();
            ConnectivityManager.NetworkCallback callback = new ConnectivityManager.NetworkCallback() {
                @TargetApi(Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    if("CT".equals(mobileNetwork)){
                        //发送移动的请求

                    }else if("CU".equals(mobileNetwork)){
                        发送联通请求
                    }else if("CM".equals(mobileNetwork)){
                        //发送电信请求
                    }
                    //显示结果
                    textView.setText(VALIDATE_RESULT);
                    connectivityManager.unregisterNetworkCallback(this);
                }
            };
            connectivityManager.registerNetworkCallback(request, callback);
            connectivityManager.requestNetwork(request, callback);
        }*/

        if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            var connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var builder = NetworkRequest.Builder()
            builder.addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET);
            builder.addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR);
            var request = builder.build();
            var callback = ConnectivityManager.NetworkCallback()

            connectivityManager.registerNetworkCallback(request, callback);
            connectivityManager.requestNetwork(request, callback);
        }

        /**
         * @author Aloha
         * @date 2021/1/29 18:33
         * @explain
         * TelephonyManager.getSimOperator(): 46009  // 当前流量卡，联通
         * TelephonyManager.getSimOperatorName(): CMCC  // 联通
         * TelephonyManager.getNetworkOperator(): 46000  // 移动，卡一
         * TelephonyManager.getNetworkOperatorName(): CHINA MOBILE  // 移动
         * TelephonyManager.getSubscriberId(): 46002326951xxxx  // 移动，这就是 IMSI，xxxx 部分是由我隐去的
         * Operator name: 联通
         */

        val tm = this.getSystemService<TelephonyManager>()
        //TelephonyManager.getSubscriberId(): ${tm?.subscriberId}
        val text = """
        TelephonyManager.getSimOperator(): ${tm?.simOperator}
        TelephonyManager.getSimOperatorName(): ${tm?.simOperatorName}
        TelephonyManager.getNetworkOperator(): ${tm?.networkOperator}
        TelephonyManager.getNetworkOperatorName(): ${tm?.networkOperatorName}
        Operator name: ${NetworkOperator.from(Integer.valueOf(tm?.simOperator)).opName}""".trimIndent()




    }

    override fun onResume() {
        super.onResume()
    }
}