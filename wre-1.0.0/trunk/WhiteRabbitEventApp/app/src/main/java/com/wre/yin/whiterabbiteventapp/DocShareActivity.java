package com.wre.yin.whiterabbiteventapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.TextView;

import com.wre.yin.whiterabbiteventapp.adapters.CustomAdapter;

public class DocShareActivity extends AppCompatActivity {

    public static String[] wordDocsNameList = {"Event Details 1.doc", "Event Details 2.doc", "Event Details 3.doc", "Event Details 4.doc"};
    public static int[] wordDocImage = {R.drawable.word_icon, R.drawable.word_icon, R.drawable.word_icon, R.drawable.word_icon};
    public static String[] pdfDocsNameList = {"Event Details 1.pdf", "Event Details 2.pdf", "Event Details 3.pdf", "Event Details 4.pdf"};
    public static int[] pdfDocImage = {R.drawable.pdf_icon, R.drawable.pdf_icon, R.drawable.pdf_icon, R.drawable.pdf_icon};
    public static String[] excelDocsNameList = {"Event Details 1.xlsx", "Event Details 2.xlsx", "Event Details 3.xlsx", "Event Details 4.xlsx"};
    public static int[] excelDocImage = {R.drawable.excel_icon, R.drawable.excel_icon, R.drawable.excel_icon, R.drawable.excel_icon};
    private TextView text;
    private GridView wordGrid, pdfGrid, excelGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_share);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);

        wordGrid = (GridView) findViewById(R.id.word_docs_grid);
        pdfGrid = (GridView) findViewById(R.id.pdf_doc_grid);
        excelGrid = (GridView) findViewById(R.id.excel_doc_grid);

        wordGrid.setAdapter(new CustomAdapter(this, wordDocsNameList, wordDocImage));
        pdfGrid.setAdapter(new CustomAdapter(this, pdfDocsNameList, pdfDocImage));
        excelGrid.setAdapter(new CustomAdapter(this, excelDocsNameList, excelDocImage));


        // text = (TextView) findViewById(R.id.activity_text);
        //hai

        // text.setText(nameTxt);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                //   NavUtils.navigateUpFromSameTask(this);
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
