package com.asad.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class reAdapter extends RecyclerView.Adapter<reAdapter.MyViewHolder> implements Filterable {

    Context context;
    ArrayList<GetData> cityNamesArray;
    ArrayList<GetData> getCityNamesArrayFull;

    public reAdapter(Context context, ArrayList<GetData> cityNames) {
        this.context = context;
        this.cityNamesArray = cityNames;
        getCityNamesArrayFull = new ArrayList<>(cityNames);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.child_layout,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
       // holder.cityName.setText(cityNamesArray.get(position));

        GetData getData = cityNamesArray.get(position);

        holder.cityName.setText(getData.getCity());
        holder.dec.setText(getData.getDes());
        holder.img.setImageResource(getData.getImg());




    }


    @Override
    public int getItemCount() {
        return cityNamesArray.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<GetData> filterList = new ArrayList<>();
            if (charSequence == null || charSequence.length() == 0)
            {
                filterList.addAll(getCityNamesArrayFull);
            }
            else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for (GetData item:getCityNamesArrayFull)
                {
                    if (item.getCity().toLowerCase().contains(filterPattern))
                    {
                        filterList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filterList;
            return  results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            cityNamesArray.clear();
            cityNamesArray.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView cityName;
        TextView dec;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName = itemView.findViewById(R.id.city_name_id);
            dec = itemView.findViewById(R.id.description_id);
            img = itemView.findViewById(R.id.image_id);

        }

    }
}
