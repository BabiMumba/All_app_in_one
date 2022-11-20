package com.babistone.moero_app.jv_class

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.babistone.moero_app.R
import com.babistone.moero_app.jv_class.Frag_Flipper

class ViewFlipper : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_flipper)

        val fragManager = supportFragmentManager
        val tManager = fragManager.beginTransaction()
        tManager.replace(R.id.containerView, Frag_Flipper()).commit()
    }
}