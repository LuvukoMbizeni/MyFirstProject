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

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>{

    ArrayList<CategoriesHelperClass> categories;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categories) {
        this.categories = categories;
    }

    @Override
    public CategoriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);

        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesViewHolder holder, int position) {

        CategoriesHelperClass categoriesHelperClass = categories.get(position);
        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.text.setText(categoriesHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;
        public CategoriesViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.cat_image);
            text = (TextView) itemView.findViewById(R.id.cat_title);
        }
    }

}
