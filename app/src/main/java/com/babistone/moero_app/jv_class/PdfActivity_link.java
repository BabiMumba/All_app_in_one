package com.babistone.moero_app.jv_class;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import com.babistone.moero_app.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class PdfActivity_link extends AppCompatActivity {

    PDFView pdfView;
    Button btn1,btn2,btn3,btn4;
    String pdfurl ="https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf";
    String pdfurl2 ="https://www.esisalama.com/assets/upload/horaire/pdf/HORAIRE%20PREPA.pdf";
    String pdfurl3 ="https://static.oc-static.com/prod/ebooks/apprenez-a-creer-votre-site-web-avec-html5-et-css3_2016.pdf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_link);

        pdfView = findViewById(R.id.pdf);
        btn1 = findViewById(R.id.book1);
        btn2 = findViewById(R.id.book2);
        btn3 = findViewById(R.id.book3);
        btn4 = findViewById(R.id.book4);

        new RetrivePDFfromUrl().execute(pdfurl);

        btn1.setOnClickListener(view -> new RetrivePDFfromUrl().execute(pdfurl));
        btn2.setOnClickListener(view -> new RetrivePDFfromUrl().execute(pdfurl2));
        btn3.setOnClickListener(view -> new RetrivePDFfromUrl().execute(pdfurl3));
        btn4.setOnClickListener(view -> showPdf());


    }

    class RetrivePDFfromUrl extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            // we are using inputstream
            // for getting out PDF.
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                // below is the step where we are
                // creating our connection.
                HttpURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                if (urlConnection.getResponseCode() == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }

            }catch (IOException e) {
                // this is the method
                // to handle errors.
                e.printStackTrace();
                return null;
            }
            return inputStream;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            // after the execution of our async
            // task we are loading our pdf in our pdf view.
            pdfView.fromStream(inputStream)
                    .enableSwipe(true) // allows to block changing pages using swipe
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .defaultPage(0)
                    .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                    .password(null)
                    .scrollHandle(null)
                    .enableAntialiasing(true)
                    .spacing(0)
                    .load();
        }
    }

    public void showPdf(){
        File file = new File(Environment.getExternalStorageDirectory()+"/test.pdf");
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(file);
        intent.setDataAndType(uri, "application/pdf");
        startActivity(intent);

    }
}