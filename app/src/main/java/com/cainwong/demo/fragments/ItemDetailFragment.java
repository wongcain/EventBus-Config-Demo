package com.cainwong.demo.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cainwong.demo.R;
import com.cainwong.demo.data.Item;
import com.cainwong.demo.data.MockDataSource;
import com.cainwong.demo.events.ItemSelectedEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by cwong on 1/27/15.
 */
public class ItemDetailFragment extends Fragment {

    EventBus bus;
    TextView titleView;
    TextView dateView;
    TextView bodyView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBus.getDefault();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_detail, container, false);
        titleView = (TextView) view.findViewById(R.id.title);
        dateView = (TextView) view.findViewById(R.id.date);
        bodyView = (TextView) view.findViewById(R.id.body);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.registerSticky(this);
    }

    @Override
    public void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    public void onEvent(ItemSelectedEvent event) {
        Item item = MockDataSource.ITEMS.get(event.position);
        titleView.setText(item.title);
        dateView.setText(item.getDateStr());
        bodyView.setText(item.body);
    }

}
