package com.example.android.recording;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Record_activity extends AppCompatActivity {



    private TextView mRecording;
    private TextView mComplete;
    private Button mButton;
    private ProgressBar mProgressBar;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecording = (TextView) findViewById(R.id.recording);
        mComplete = (TextView) findViewById(R.id.complete);
        mButton = (Button) findViewById(R.id.button);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
        mProgressBar.setVisibility(ProgressBar.INVISIBLE);
        title = (TextView) findViewById(R.id.Title);
        final ListView list = (ListView) findViewById(R.id.list);

        List<String> formats = new ArrayList<String>();
        formats.add("yy.MM.dd  HH:mm");
        final DateAdapter adapter = new DateAdapter(this,formats);





        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecording.setText("녹음중");
                mComplete.setText("완료");
                mButton.setText("녹음하기");
                mProgressBar.setVisibility(ProgressBar.VISIBLE);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });



        mComplete.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                View view = (LayoutInflater.from(Record_activity.this)).inflate(R.layout.complete, null);

                AlertDialog.Builder alertBuilder = new AlertDialog.Builder(Record_activity.this);
                alertBuilder.setView(view);
                final EditText userInput = (EditText) view.findViewById(R.id.Title);
                alertBuilder.setTitle("저장");
                alertBuilder.setMessage("녹음을 끝내시겠습니까?");


                alertBuilder.setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                alertBuilder.setCancelable(false)
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                Dialog dialog = alertBuilder.create();
                dialog.show();

            }
        });
    }
}
