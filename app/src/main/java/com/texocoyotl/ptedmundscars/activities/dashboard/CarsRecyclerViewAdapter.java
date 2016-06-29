package com.texocoyotl.ptedmundscars.activities.dashboard;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.texocoyotl.ptedmundscars.R;
import com.texocoyotl.ptedmundscars.data.Contract;
import com.texocoyotl.ptedmundscars.utils.CursorRecyclerViewAdapter;


public class CarsRecyclerViewAdapter extends CursorRecyclerViewAdapter<CarsRecyclerViewAdapter.ViewHolder> {

    private final Context mListener;

    public CarsRecyclerViewAdapter(Context context, Cursor cursor) {
        super(context,cursor);
        mListener = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(
                        R.layout.cars_list_row,
                        parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Cursor cursor) {

        final int position = cursor.getPosition();

        final String name = cursor.getString(Contract.StylesEntry.DashBoardQuery.COLNUM_NAME);
        final String id = cursor.getString(Contract.StylesEntry.DashBoardQuery.COLNUM_STYLE_ID);
        final String year = cursor.getString(Contract.StylesEntry.DashBoardQuery.COLNUM_YEAR);

        viewHolder.mNameView.setText(name);
        viewHolder.mYear.setText(year);

        viewHolder.mRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    ((OnStylesListInteractionListener) mListener).onListFragmentInteraction(id);
                }
            }
        });

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mRow;
        public final TextView mNameView;
        private final ImageButton mDetailsButton;
        private final TextView mYear;

        public ViewHolder(View view) {
            super(view);
            mRow = view;
            mNameView = (TextView) view.findViewById(R.id.cars_list_name);
            mYear = (TextView) view.findViewById(R.id.cars_list_year);
            mDetailsButton = (ImageButton) view.findViewById(R.id.cars_list_button);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }


}
