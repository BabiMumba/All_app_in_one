package com.babistone.moero_app.jv_class

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.babistone.moero_app.R
import com.babistone.moero_app.jv_class.Frag_Flipper
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ViewFlipper : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)


/*
 val fragManager = supportFragmentManager
        val tManager = fragManager.beginTransaction()
        tManager.replace(R.id.containerView, Frag_Flipper()).commit()
 */

        MobileAds.initialize(this)
//build ad
        val adLoader = AdLoader.Builder(this,"ca-app-pub-3940256099942544/2247696110")
            .forNativeAd {
                val style  = NativeTemplateStyle.Builder().withMainBackgroundColor(ColorDrawable(
                    Color.WHITE))
                    .build()
                val template = findViewById<TemplateView>(R.id.my_template)
                template.setStyles(style)
                template.setNativeAd(it)
            }.build()
//show ad
        adLoader.loadAd(AdRequest.Builder().build())
    }
}