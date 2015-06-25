package cuiserve.com.volleyframework.temp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragmentRight extends Fragment {

    public MainActivityFragmentRight() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        FrameLayout view = (FrameLayout)inflater.inflate(R.layout.fragment_main_right, container, false);

        view.addView(createGridView());
        return view;
    }

    private GridView createGridView() {
        GridView grid = new GridView(getActivity());
        grid.setLayoutParams(new GridView.LayoutParams(GridLayout.LayoutParams.FILL_PARENT, GridLayout.LayoutParams.FILL_PARENT));
        grid.setBackgroundColor(Color.GRAY);
        grid.setNumColumns(20);
        grid.setColumnWidth(GridView.AUTO_FIT);
        grid.setVerticalSpacing(5);
        grid.setHorizontalSpacing(5);
        //grid.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);

        grid.setAdapter(new ImageAdapter(getActivity()));
        return grid;
    }
}
