package com.cainwong.demo.fragments;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.cainwong.demo.adapters.ItemListAdapter;
import com.cainwong.demo.events.ItemSelectedEvent;
import com.cainwong.demo.events.LayoutEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by cwong on 1/27/15.
 */
public class ItemListFragment extends ListFragment {


    EventBus bus;
    int activePosition;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBus.getDefault();
        activePosition = ListView.INVALID_POSITION;
        setListAdapter(new ItemListAdapter(getActivity()));
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

    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        super.onListItemClick(listView, itemView, position, id);
        bus.postSticky(new ItemSelectedEvent(position));
    }

    public void onEvent(LayoutEvent event) {
        if(event.isTwoPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            updateSelectedItem(activePosition);
        } else {
            getListView().setChoiceMode(ListView.CHOICE_MODE_NONE);
        }
    }

    public void onEvent(ItemSelectedEvent event) {
        updateSelectedItem(event.position);
    }

    void updateSelectedItem(int position){
        if (position == ListView.INVALID_POSITION) {
            getListView().setItemChecked(activePosition, false);
            getListView().smoothScrollToPosition(0);
        } else {
            getListView().setItemChecked(position, true);
            getListView().smoothScrollToPosition(position);
        }

        activePosition = position;
    }
}
