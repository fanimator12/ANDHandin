package com.example.initialapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Database.BucketListGoals;
import com.example.initialapp.R;

import java.util.ArrayList;
import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder> {
    private List<BucketListGoals> mGoals = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_goals, parent, false);

        context = parent.getContext();

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        viewHolder.label.setText(mGoals.get(position).getGoal());
        viewHolder.icon.setImageResource(mGoals.get(position).getImageID());
    }

    @Override
    public int getItemCount() {
        return mGoals.size();
    }

    public void setGoals(List<BucketListGoals> goals){
        this.mGoals = goals;
        notifyDataSetChanged();
    }

    public BucketListGoals getBucketListGoalAt(int position){
        return mGoals.get(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView label;
        ImageView icon;

        ViewHolder(View goalView) {
            super(goalView);
            label = goalView.findViewById(R.id.goal_title);
            icon = goalView.findViewById(R.id.goal_icon);
        }

    }

    public interface OnListGoalClickListener {
        void onListGoalClick(int clickedGoalIndex);
    }
}
