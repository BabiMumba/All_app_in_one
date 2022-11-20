package com.babistone.moero_app.jv_class

import com.babistone.moero_app.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.fragment.app.Fragment

class Frag_Flipper : Fragment() {
    var viewFlipper: ViewFlipper? = null

    var images = intArrayOf(
        R.drawable.banner_design,
        R.drawable.banner_genie_log,
        R.drawable.banner_principale,
        R.drawable.banner_reseaux,
        R.drawable.img9
    )

    //String names[] ={"Image 1", "Image 2", "Image 3", "Image 4", "Image 5", "Image 6"};
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_flipper, container, false)
        viewFlipper = rootView.findViewById<View>(R.id.viewflip) as ViewFlipper
        for (i in images.indices) {
            setFlipperImage(images[i])
        }
        return rootView
    }

    private fun setFlipperImage(res: Int) {
        val image = ImageView(activity)
        image.setBackgroundResource(res)
        viewFlipper!!.addView(image)
        viewFlipper!!.flipInterval = 5000 //five seconds interval
        viewFlipper!!.isAutoStart = true
    }
}