package com.example.john.calendar2;

import java.util.ArrayList;
import com.example.john.calendar2.R;
import com.example.john.calendar2.AndroidListAdapter;
import com.example.john.calendar2.CalendarCollection;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewActivity extends Activity implements OnClickListener {

    private ListView lv_android;
    private AndroidListAdapter list_adapter;
    private Button btn_calender;
    private AndroidListAdapter.ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        getWidget();
    }

    public void getWidget(){
        btn_calender = (Button) findViewById(R.id.btn_calender);
        btn_calender.setOnClickListener(this);

        lv_android = (ListView) findViewById(R.id.lv_android);
        list_adapter=new AndroidListAdapter(ListViewActivity.this,R.layout.list_item,
                CalendarCollection.date_collection_arr);
        lv_android.setAdapter(list_adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_calender:
                Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }

    public void addEventClicked(View v) {
        Intent intent = new Intent(ListViewActivity.this, AddEvent.class);
        startActivity(intent);
    }

    public void deleteClicked(View v) {
        TextView tv_event = (TextView) findViewById(R.id.tv_event);
        String ename = tv_event.getText().toString();
        for (int i = 0; i < CalendarCollection.date_collection_arr.size(); i++) {
            if (ename.equals(CalendarCollection.date_collection_arr.get(i).eventName)) {
                CalendarCollection.date_collection_arr.remove(i);

                finish();
                startActivity(getIntent());
            }
        }
    }
}
