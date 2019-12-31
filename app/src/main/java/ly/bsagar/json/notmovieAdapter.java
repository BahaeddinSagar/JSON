package ly.bsagar.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class notmovieAdapter extends ArrayAdapter<notmovie> {


    public notmovieAdapter(@NonNull Context context, int resource,
                           @NonNull ArrayList<notmovie> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position,
                        @Nullable View convertView,
                        @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.item_layout,parent,false);
        }
        TextView titleView = convertView.findViewById(R.id.name);
        TextView desView = convertView.findViewById(R.id.desc);
        TextView yearView = convertView.findViewById(R.id.year);
        notmovie currentMovie = getItem(position);

        titleView.setText(currentMovie.name);
        desView.setText(currentMovie.description);
        yearView.setText(String.valueOf(currentMovie.year));

        return convertView;

    }
}
