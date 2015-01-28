package com.cainwong.demo.activities;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.cainwong.demo.events.ItemSelectedEvent;
import com.cainwong.demo.fragments.ItemDetailFragment;
import com.cainwong.demo.fragments.ItemListFragment;
import com.cainwong.demo.R;
import com.cainwong.demo.events.LayoutEvent;

import de.greenrobot.event.EventBus;

/**
 * Created by cwong on 1/27/15.
 */
public class MainActivity extends Activity {

    EventBus bus;
    FrameLayout listContainer;
    FrameLayout detailContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        bus = EventBus.getDefault();
        listContainer = (FrameLayout) findViewById(R.id.list_container);
        detailContainer = (FrameLayout) findViewById(R.id.detail_container);
        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        getFragmentManager().beginTransaction()
                .replace(listContainer.getId(), new ItemListFragment())
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.registerSticky(this);
        bus.postSticky(new LayoutEvent(isTwoPane()));
    }

    @Override
    protected void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        bus.removeStickyEvent(ItemSelectedEvent.class);
        super.onBackPressed();
    }

    boolean isTwoPane(){
        return detailContainer != null;
    }

    public void onEvent(ItemSelectedEvent event) {
        if(isTwoPane()){
            getFragmentManager().beginTransaction()
                    .replace(detailContainer.getId(), new ItemDetailFragment())
                    .commit();
        } else {
            getFragmentManager().beginTransaction()
                    .replace(listContainer.getId(), new ItemDetailFragment())
                    .addToBackStack(ItemDetailFragment.class.getName())
                    .commit();
        }
    }

}
