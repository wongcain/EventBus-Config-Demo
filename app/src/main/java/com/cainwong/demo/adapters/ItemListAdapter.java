package com.cainwong.demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cainwong.demo.R;
import com.cainwong.demo.data.Item;
import com.cainwong.demo.data.MockDataSource;

/**
 * Created by cwong on 1/27/15.
 */
public class ItemListAdapter extends ArrayAdapter<Item> {

    public ItemListAdapter(Context context) {
        super(context, R.layout.list_item, MockDataSource.ITEMS);


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.titleView = (TextView) convertView.findViewById(R.id.title);
            viewHolder.dateView = (TextView) convertView.findViewById(R.id.date);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) convertView.getTag();
        }

        Item item = MockDataSource.ITEMS.get(position);
        viewHolder.titleView.setText(item.title);
        viewHolder.dateView.setText(item.getDateStr());
        return convertView;
    }


    class ItemViewHolder {
        TextView titleView;
        TextView dateView;
    }

}
