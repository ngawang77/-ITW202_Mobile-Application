package com.gcit.todo_16;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class WordlistAdapter extends RecyclerView.Adapter<WordlistAdapter.WordViewHolder> {
    private final LinkedList<String> mWordlist;
    private LayoutInflater mInflater;

    public WordlistAdapter(Context context, LinkedList<String> mWordlist) {
        mInflater = LayoutInflater.from(context);
        this.mWordlist = mWordlist;
    }


    @NonNull
    @Override
    public WordlistAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull WordlistAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordlist.get(position);
        holder.wordItemView.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return  mWordlist.size();

    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView wordItemView;
        final WordlistAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, WordlistAdapter mAdapter) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.word);
            this.mAdapter = mAdapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            int mPosition = getLayoutPosition();
            String element = mWordlist.get(mPosition);
            mWordlist.set(mPosition, "Clicked!" + element);
            mAdapter.notifyDataSetChanged();
        }
    }
}
