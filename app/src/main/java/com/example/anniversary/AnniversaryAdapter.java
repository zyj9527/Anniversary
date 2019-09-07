package com.example.anniversary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.AnimatorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AnniversaryAdapter extends ArrayAdapter<Anniversary> {

    private int m_resourceId;

    public AnniversaryAdapter(@NonNull Context context, int resource, @NonNull List<Anniversary> objects) {
        super(context, resource, objects);
        m_resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        Anniversary anniversary = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(m_resourceId, parent, false);
            viewHolder = new ViewHolder(view, anniversary);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(anniversary.getName()+anniversary.getDate().toString());
        return view;
    }

    private class ViewHolder {
        Anniversary anniversary;
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(View v, Anniversary a) {
            linearLayout = (LinearLayout) v.findViewById(R.id.layout_hide);
            textView = (TextView)v.findViewById(R.id.text_name);
            imageView = (ImageView)v.findViewById(R.id.image_arrow);
            imageView.setImageResource(R.drawable.right_arrow);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView = linearLayout.findViewById(R.id.text_date);
                    textView.setText(anniversary.getDate().toString());
                    linearLayout.setVisibility(View.VISIBLE);
                }
            });
        }
    }
}
