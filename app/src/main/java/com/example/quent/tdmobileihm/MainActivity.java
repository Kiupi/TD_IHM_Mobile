package com.example.quent.tdmobileihm;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonEdition;
    RecyclerView recyclerView;
    NameListAdapter nameListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initList();

        /*
        textViewName =findViewById(R.id.Activity_main_textView_name);
        buttonEdit = findViewById(R.id.Activity_main_button_edit);
        */

    }

    protected void initViews() {
        buttonEdition = findViewById(R.id.activity_main_button_edition);
        recyclerView = findViewById(R.id.activity_main_recyclerView);
        nameListAdapter=new NameListAdapter();

        buttonEdition.setOnClickListener(this);
    }

    private void initList() {
        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(nameListAdapter);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK && data.getExtras() != null) {
                Bundle args =  data.getExtras();
                String name = args.getString("USERNAME");
                textViewName.setText(name);
                Log.d("Username",name);

            }else{

            }
        }
    }
*/

    @Override
    protected void onResume() {
        super.onResume();

        nameListAdapter.updateList(DataManager.getInstance().getNameList());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_button_edition:
                Intent intent = new Intent(this, EditActivity.class);
                startActivity(intent);

                break;
            default:
        }
    }
}
