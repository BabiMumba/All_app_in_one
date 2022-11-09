package com.babistone.moero_app.jv_class;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import android.widget.ViewFlipper;

import com.babistone.moero_app.R;

public class Frag_Flipper extends Fragment {
    ViewFlipper viewFlipper;
    //TextView imgdesc;
    int images[] = {R.drawable.img3,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
    //String names[] ={"Image 1", "Image 2", "Image 3", "Image 4", "Image 5", "Image 6"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.fragment_flipper, container, false);

        viewFlipper = (ViewFlipper) rootView.findViewById(R.id.viewflip);
        //imgdesc = (TextView) rootView.findViewById(R.id.imgdesc);

        for(int i=0; i<images.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage( images[i] );
        }

        return rootView;
    }

    private void setFlipperImage(int res) {
        ImageView image = new ImageView(getActivity());
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(5000); //five seconds interval
        viewFlipper.setAutoStart(true);
    }

}
