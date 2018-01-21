package com.example.jordi.myapplication;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;


public class statsActivity extends AppCompatActivity {
    private EditText editText;
    ProgressDialog mProgressDialog;
    Handler mHandler;
    String statsloader="";
    conexion cn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText=(EditText)findViewById(R.id.editText);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        conexion cn= new conexion(getApplicationContext(),"76561198074289873");

        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        launchProgressDialog();

        }

    public void launchProgressDialog() {
        mProgressDialog = new ProgressDialog(statsActivity.this);
        mProgressDialog.setMessage("Loading ...");
        mProgressDialog.setProgressStyle(mProgressDialog.STYLE_SPINNER);
        mProgressDialog.setProgress(0);
        mProgressDialog.setMax(100);
        mProgressDialog.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(statsloader.equals("")){
                        Thread.sleep(1000);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                statsloader = cn.apistats();
                                if(statsloader!=""){
                                    mProgressDialog.dismiss();
                                    /*if(statsloader.getText().toString().equals(statsloader)){

                                    }else if(!edPassword.getText().toString().equals(statsloader)){
                                        Toast.makeText(getApplicationContext(), "ID incorrecto", Toast.LENGTH_SHORT).show();
                                    }*/
                                    editText.setText(statsloader);
                                    }

                            }
                        });

                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    }



