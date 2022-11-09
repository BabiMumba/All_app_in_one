package com.babistone.moero_app;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private final String TAG = MainActivity.class.getSimpleName();
    public static final String SAMPLE_FILE = "sfp.pdf";
    PDFView viewPDF;
    Integer page = 0;
    String fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPDF = (PDFView) findViewById(R.id.pdf);
        displayFromAsset();

    }

    private void displayFromAsset() {
        fileName = MainActivity.SAMPLE_FILE;

        //Open PDF from file


        /**
         File file = new File(Environment.getExternalStorageDirectory() + "/test.pdf");
         viewPDF.fromFile(file);
         */

        //Open from Asset

        viewPDF.fromAsset(SAMPLE_FILE)
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();


    }

    public void onPageChanged(int page, int pageCount) {
        page = page;
        setTitle(String.format("%s %s / %s", fileName, page + 1, pageCount));
    }


    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = viewPDF.getDocumentMeta();
        printBookmarksTree(viewPDF.getTableOfContents(), "-");

    }

    public void printBookmarksTree(List<PdfDocument.Bookmark> tree, String sep) {
        for (PdfDocument.Bookmark b : tree) {
            Log.e(TAG, String.format("%s %s, p %d", sep, b.getTitle(), b.getPageIdx()));
            if (b.hasChildren()) {
                printBookmarksTree(b.getChildren(), sep + "-");
            }
        }
    }
}