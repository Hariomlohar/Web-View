package com.example.webview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            webViewSetup()
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun webViewSetup(){
        // webViewclient allows you to handle on pagefinished and override url loading
    web_view.webViewClient= WebViewClient()
   // this will load the url of the website
        web_view.apply {
            loadUrl("https://www.google.com/")
            // this will enable javascript settings
            settings.javaScriptEnabled=true
            settings.safeBrowsingEnabled=true
            // if you want to enable zoom feature
            settings.setSupportZoom(true)
        }


    }
       // if you prees back button this code will work
    override fun onBackPressed() {
        // if your webview can go back it will go back
        if (web_view.canGoBack())
            web_view.goBack()
        // if your webview cannot go back

        else
            super.onBackPressed()
    }
    }

