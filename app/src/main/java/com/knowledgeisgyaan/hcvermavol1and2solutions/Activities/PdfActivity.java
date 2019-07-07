package com.knowledgeisgyaan.hcvermavol1and2solutions.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.github.barteksc.pdfviewer.PDFView;
import com.knowledgeisgyaan.hcvermavol1and2solutions.*;

public class PdfActivity extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        String chpname = getIntent().getStringExtra("chapter");

        getSupportActionBar().setTitle(chpname);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String num = getIntent().getStringExtra("number");

        String filename = namecreate(num);

        pdfView = (PDFView) findViewById(R.id.v_pdf);
        pdfView.fromAsset(filename)
         .load();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private String namecreate(String chpnum) {
        // format of pdf file in assets folders is saved as a1 where it is 1st chapter
        String filename = "a"+chpnum+".pdf";
        return filename;
    }
}


