package com.example.john.calendar2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.lang.String;
import android.widget.EditText;


public class AddEvent extends Activity {
    EditText eventName;
    EditText date;
    EditText time;
    EditText loc;
    EditText description;
    Button addBtn;
    String input_e = "";
    String input_date = "";
    String input_t = "";
    String input_l = "";
    String input_desc = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        addBtn = (Button) findViewById(R.id.btn_finish_add);
        eventName = (EditText) findViewById(R.id.et_name);
        date = (EditText) findViewById(R.id.et_date);
        time = (EditText) findViewById(R.id.et_time);
        loc = (EditText) findViewById(R.id.et_location);
        description = (EditText) findViewById(R.id.et_description);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input_e = eventName.getText().toString();
                input_date = date.getText().toString();
                input_t = time.getText().toString();
                input_l = loc.getText().toString();
                input_desc = description.getText().toString();

                CalendarCollection.date_collection_arr.add(new CalendarCollection
                        (input_e, input_date, input_t, input_l, input_desc));

                startActivity(new Intent(AddEvent.this, ListViewActivity.class));
            }
        });
    }

    public void cancelClicked(View v) {
        startActivity(new Intent(AddEvent.this,ListViewActivity.class));
    }
}
