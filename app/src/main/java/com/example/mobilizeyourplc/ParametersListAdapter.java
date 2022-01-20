package com.example.mobilizeyourplc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.mobilizeyourplc.remote.parameter;

import java.util.ArrayList;

/**
 * Created by User on 3/14/2017.
 */

public class ParametersListAdapter extends ArrayAdapter<parameter> {
    private static final String TAG = "AlarmListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {
        TextView deviceId;
        TextView value;
        TextView Parameter;
    }

    /**
     * Default constructor for the PersonListAdapter
     * @param context
     * @param resource
     * @param objects
     */
    public ParametersListAdapter(Context context, int resource, ArrayList<parameter> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the alarms information
        String Parameter = getItem(position).getParameter();
        int deviceId = getItem(position).getDeviceId();
        int value = getItem(position).getValue();


        //Create the alarm object with the information
        parameter parameter = new parameter(Parameter, deviceId,  value);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.deviceId = (TextView) convertView.findViewById(R.id.textView3);
            holder.value = (TextView) convertView.findViewById(R.id.textView2);
            holder.Parameter = (TextView) convertView.findViewById(R.id.textView1);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }


        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

//        holder.value.setText(parameter.getValue());
//        holder.Parameter.setText(parameter.getParameter());
//        holder.deviceId.setText(parameter.getDeviceId());


        return convertView;
    }
}
