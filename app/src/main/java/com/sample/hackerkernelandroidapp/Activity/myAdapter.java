package com.sample.hackerkernelandroidapp.Activity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sample.hackerkernelandroidapp.Page3_data.Data;
import com.sample.hackerkernelandroidapp.R;

class myAdapter extends RecyclerView.Adapter<myAdapter.myHolder> {

    Data p;


    public myAdapter(Data data) {

        p = data;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_page3data, viewGroup, false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder myHolder, int i) {




        String status = p.getImages().get(i).getStatus();
        myHolder.status.setText("Status: "+status);

        String File = p.getImages().get(i).getFile();
        myHolder.file.setText("File: "+File);

        String Pitch = p.getImages().get(i).getFaces().get(0).getPitch().toString();
        myHolder.pitch.setText("Pitch: "+Pitch);

       String Lips = p.getImages().get(i).getFaces().get(0).getAttributes().getLips();
        myHolder.lips.setText("Lips: "+Lips);

        String maleConfidence = p.getImages().get(i).getFaces().get(0).getAttributes().getGender().getMaleConfidence().toString();
        myHolder.maleConfidence.setText("MaleConfidence: "+maleConfidence);

    }

    @Override
    public int getItemCount() {


        return p.getImages().size();

    }

    public class myHolder extends RecyclerView.ViewHolder {

        TextView status, file, pitch, lips, maleConfidence;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            status = itemView.findViewById(R.id.status);
            file = itemView.findViewById(R.id.file);
            lips = itemView.findViewById(R.id.lips);
            pitch = itemView.findViewById(R.id.pitch);
            maleConfidence = itemView.findViewById(R.id.maleConfidence);


        }
    }
}