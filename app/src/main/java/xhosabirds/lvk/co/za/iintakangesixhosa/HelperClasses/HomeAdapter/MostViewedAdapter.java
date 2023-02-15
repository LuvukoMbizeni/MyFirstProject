package xhosabirds.lvk.co.za.iintakangesixhosa.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import xhosabirds.lvk.co.za.iintakangesixhosa.R;

/**
 * Created by Luvuko-Dell on 2/14/2023.
 */

public class MostViewedAdapter extends RecyclerView.Adapter<MostViewedAdapter.MostViewedViewHolder> {

    ArrayList<MostViewedHelperClass> mostViewed;


    public MostViewedAdapter(ArrayList<MostViewedHelperClass> mostViewed) {
        this.mostViewed = mostViewed;
    }

    @Override
    public MostViewedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design, parent, false);
        MostViewedViewHolder featuredViewHolder = new MostViewedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(MostViewedViewHolder holder, int position) {

        MostViewedHelperClass mostViewedHelperClass = mostViewed.get(position);
        holder.image.setImageResource(mostViewedHelperClass.getImage());
        holder.title.setText(mostViewedHelperClass.getTitle());
        holder.desc.setText(mostViewedHelperClass.getDescription());

    }

    @Override
    public int getItemCount() {
        return mostViewed.size();
    }

    public static class MostViewedViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title, desc;

        public MostViewedViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.ms_image);
            title = (TextView) itemView.findViewById(R.id.ms_title);
            desc = (TextView) itemView.findViewById(R.id.ms_description);


        }
    }


}
