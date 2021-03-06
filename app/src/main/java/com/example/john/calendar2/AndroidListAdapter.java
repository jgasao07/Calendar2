package com.example.john.calendar2;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.john.calendar2.R;
import com.example.john.calendar2.CalendarCollection;

public class AndroidListAdapter extends ArrayAdapter<CalendarCollection>{

    private final Context context;
    private final ArrayList<CalendarCollection> values;
    private ViewHolder viewHolder;
    private final int resourceId;

    public AndroidListAdapter(Context context, int resourceId,ArrayList<CalendarCollection> values) {
        super(context, resourceId, values);

        this.context = context;
        this.values = values;
        this.resourceId = resourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resourceId, parent, false);


            viewHolder = new ViewHolder();
            viewHolder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.tv_event = (TextView) convertView.findViewById(R.id.tv_event);
            viewHolder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
            viewHolder.tv_location = (TextView) convertView.findViewById(R.id.tv_location);
            viewHolder.tv_description = (TextView) convertView.findViewById(R.id.tv_description);


            convertView.setTag(viewHolder);


        }else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CalendarCollection list_obj=values.get(position);
        viewHolder.tv_date.setText(list_obj.date);
        viewHolder.tv_event.setText(list_obj.eventName);
        viewHolder.tv_time.setText(list_obj.time);
        viewHolder.tv_location.setText(list_obj.location);
        viewHolder.tv_description.setText(list_obj.description);

        return convertView;
    }

    public class ViewHolder {

        TextView tv_event;
        TextView tv_date;
        TextView tv_time;
        TextView tv_location;
        TextView tv_description;

    }

}
