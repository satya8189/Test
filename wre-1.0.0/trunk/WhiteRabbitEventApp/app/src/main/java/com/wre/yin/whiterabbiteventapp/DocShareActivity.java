package com.wre.yin.whiterabbiteventapp;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wre.yin.whiterabbiteventapp.beans.GalaryBean;
import com.wre.yin.whiterabbiteventapp.utils.Callback;
import com.wre.yin.whiterabbiteventapp.utils.Constants;
import com.wre.yin.whiterabbiteventapp.utils.MyAsyncTask;
import com.wre.yin.whiterabbiteventapp.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DocShareActivity extends AppCompatActivity {

   private CoordinatorLayout coordinatorLayout;
    private GridView wordGrid, pdfGrid, excelGrid;

    private String eventId;
    private List<HashMap<String,String>> docList;
    private TextView loadingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_share);

        String nameTxt = getIntent().getExtras().getString("name");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(nameTxt);
         eventId = getIntent().getExtras().getString("eventId");
        wordGrid = (GridView) findViewById(R.id.word_docs_grid);
        pdfGrid = (GridView) findViewById(R.id.pdf_doc_grid);
        excelGrid = (GridView) findViewById(R.id.excel_doc_grid);
        loadingText=(TextView)findViewById(R.id.downloading_file_text);


        new MyAsyncTask(Constants.FILES_LIST + eventId + "&type=document", null, DocShareActivity.this, new Callback() {
            @Override
            public void onResult(String result) {
                docList=new ArrayList<HashMap<String, String>>();
                List<GalaryBean> docBeanList= Utils.getList(result,GalaryBean.class);
                for(GalaryBean bean:docBeanList){
                    HashMap<String,String> docMap=new HashMap<String, String>();
                    docMap.put("docName",bean.getName());
                    docMap.put("docFileName",Constants.IMAGE_URL+eventId+"/document/"+bean.getFileName());
                    docList.add(docMap);
                }
                pdfGrid.setAdapter(new CustomAdapter(DocShareActivity.this, (ArrayList<HashMap<String, String>>) docList));
                // excelGrid.setAdapter(new CustomAdapter(this, excelDocsNameList, excelDocImage));

            }
        }).execute();

       // wordGrid.setAdapter(new CustomAdapter(this, wordDocsNameList, wordDocImage));


    }

    void setText(final String msg){
        runOnUiThread(new Runnable() {
            public void run() {
                loadingText.setText(msg);
            }
        });

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

    public class CustomAdapter extends BaseAdapter {
        private  LayoutInflater inflater = null;
        Context context;
        float per = 0;
        int downloadedSize = 0, totalsize;
        ArrayList<HashMap<String,String>> docList1;
        HashMap<String,String> result;
        public CustomAdapter(Context context1, ArrayList<HashMap<String,String>> docList) {
            context = context1;
            docList1=docList;
            inflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }



        @Override
        public int getCount() {
            return docList1.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            Holder holder = new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.docs_list_row, null);
            holder.docsName = (TextView) rowView.findViewById(R.id.docs_name_text);
            holder.docsTypeImage = (ImageView) rowView.findViewById(R.id.docs_type_image);
            result=docList1.get(position);
            holder.docsName.setText(result.get("docName"));

            rowView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();

                    final String[] items = {"Share", "View", "Download"};


                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    result=docList1.get(position);
                    builder.setTitle(result.get("docName"));
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int item) {
                            // Do something with the selection
                            String itemName = (items[item]);
                            if (itemName == "Share") {

                            } else if (itemName == "View") {
                                new Thread(new Runnable() {
                                    public void run() {
                                        Uri path = Uri.fromFile(downloadFile(result.get("docFileName"),result.get("docName")+".pdf"));
                                        try {
                                            Intent intent = new Intent(Intent.ACTION_VIEW);
                                            intent.setDataAndType(path, "application/pdf");
                                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            context.startActivity(intent);

                                        } catch (ActivityNotFoundException e) {

                                            Toast.makeText(context,"PDF Reader application is not installed in your device",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }).start();

                            } else if (itemName == "Download") {
                                new Thread(new Runnable() {
                                    public void run() {
                                        downloadFile(result.get("docFileName"),result.get("docName")+".pdf");
                                    }
                                }).start();
                            }
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
            });
            return rowView;
        }

        public class Holder {
            TextView docsName;
            ImageView docsTypeImage;
        }

        File downloadFile(String dwnload_file_path, String dest_file_path) {
            File file = null;
            try {

                URL url = new URL(dwnload_file_path);
                HttpURLConnection urlConnection = (HttpURLConnection) url
                        .openConnection();

                urlConnection.setRequestMethod("GET");
                urlConnection.setDoOutput(true);

                // connect
                urlConnection.connect();

                // set the path where we want to save the file
                File SDCardRoot = new File(Environment.getExternalStorageDirectory(),"WREX Documents");
                // create a new file, to save the downloaded file
                if(!SDCardRoot.exists())
                    SDCardRoot.mkdir();

                file = new File(SDCardRoot, dest_file_path);

                FileOutputStream fileOutput = new FileOutputStream(file);

                // Stream used for reading the data from the internet
                InputStream inputStream = urlConnection.getInputStream();

                // this is the total size of the file which we are
                // downloading
                totalsize = urlConnection.getContentLength();
                //setText("Starting PDF download...");

                // create a buffer...
                byte[] buffer = new byte[1024 * 1024];
                int bufferLength = 0;

                while ((bufferLength = inputStream.read(buffer)) > 0) {
                    fileOutput.write(buffer, 0, bufferLength);
                    downloadedSize += bufferLength;
                    per = ((float) downloadedSize / totalsize) * 100;
                setText("Total PDF File size  : "
                        + (totalsize / 1024)
                        + " KB\n\nDownloading PDF " + (int) per
                        + "% complete");



                }
                // close the output stream when complete //
                fileOutput.close();

                // setText("Download Complete. Open PDF Application installed in the device.");

            } catch (final MalformedURLException e) {
            /*setTextError("Some error occured. Press back and try again.",
                    Color.RED);*/
            } catch (final IOException e) {
            /*setTextError("Some error occured. Press back and try again.",
                    Color.RED);*/
            } catch (final Exception e) {
            /*setTextError(
                    "Failed to download image. Please check your internet connection.",
                    Color.RED);*/
            }
            return file;
        }
    }
}
