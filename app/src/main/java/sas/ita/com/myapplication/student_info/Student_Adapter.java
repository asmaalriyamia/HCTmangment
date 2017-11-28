package sas.ita.com.myapplication.student_info;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sas.ita.com.myapplication.R;

/**
 * Created by sasmob on 11/26/2017.
 */

public class Student_Adapter extends RecyclerView.Adapter<Student_Adapter.MyViewHolder>{
    Context context;
    //using to attatch with layout
    ArrayList<Student_Info>student;

    //where to display
    public Student_Adapter(Context context, ArrayList<Student_Info>student){
        this.context = context;
        this.student = student;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.student_info, parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student_Info student_info=student.get(position);
        holder.name.setText(student_info.getName());
        holder.image.setImageResource(student_info.getImage());
    }

    @Override
    public int getItemCount() {
        return student.size();
    }

    //Views that goining to display on Recycler view
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);

        }
    }
}
