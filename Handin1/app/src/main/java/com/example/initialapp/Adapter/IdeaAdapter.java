package com.example.initialapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.initialapp.Domain.Idea;
import com.example.initialapp.R;

import java.util.ArrayList;

public class IdeaAdapter extends RecyclerView.Adapter<IdeaAdapter.ViewHolder> {
    private ArrayList<Idea> mIdeas;
    final private OnListIdeaClickListener mOnListIdeaClickListener;

    public IdeaAdapter(ArrayList<Idea> mIdeas, OnListIdeaClickListener mOnListIdeaClickListener) {
        this.mIdeas = mIdeas;
        this.mOnListIdeaClickListener = mOnListIdeaClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_ideas, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.activity.setText(mIdeas.get(position).getIdea());
        viewHolder.icon.setImageResource(mIdeas.get(position).getIdeaIconID());
    }

    @Override
    public int getItemCount() {
        return mIdeas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView activity;
        ImageView icon;

        ViewHolder(View ideaView) {
            super(ideaView);
            activity = ideaView.findViewById(R.id.idea_title);
            icon = ideaView.findViewById(R.id.idea_icon);
            ideaView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnListIdeaClickListener.onListIdeaClick(getAdapterPosition());
        }
    }

    public interface OnListIdeaClickListener {
        void onListIdeaClick(int clickedIdeaIndex);
    }
}
