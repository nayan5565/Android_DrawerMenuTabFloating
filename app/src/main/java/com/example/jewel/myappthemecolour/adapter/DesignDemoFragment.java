package com.example.jewel.myappthemecolour.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Jewel on 1/20/2016.
 */
public class DesignDemoFragment extends Fragment{

    private static final String TAB_POSITION="tab_position";

    public DesignDemoFragment(){

    }

    public static DesignDemoFragment newInstance(int tabPosition){
        DesignDemoFragment fragment=new DesignDemoFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(TAB_POSITION,tabPosition);
        fragment.setArguments(bundle);

        return fragment;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle=getArguments();
        int tabPosition=bundle.getInt(TAB_POSITION);
        TextView tv=new TextView(getActivity());
        tv.setGravity(Gravity.CENTER);
        tv.setText("TAB_POSITION #"+tabPosition);
        return tv;
    }
}
