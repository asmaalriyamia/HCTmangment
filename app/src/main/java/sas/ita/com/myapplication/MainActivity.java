package sas.ita.com.myapplication;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import sas.ita.com.myapplication.student_info.Student_Adapter;
import sas.ita.com.myapplication.student_info.Student_Info;

public class MainActivity extends AppCompatActivity {
    String[] studentname;
    TypedArray studentimage;
    RecyclerView recycler;
    ArrayList<Student_Info> studentArraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentArraylist=new ArrayList<>();
        recycler=(RecyclerView)findViewById(R.id.recycler);
        studentname=getResources().getStringArray(R.array.student_name);
        studentimage=getResources().obtainTypedArray(R.array.image);
        createStudentList();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycler.setLayoutManager(layoutManager);
        Student_Adapter adapter=new Student_Adapter(this,studentArraylist);
        recycler.setAdapter(adapter);
    }

    private void createStudentList() {
        for(int i=0;i<studentname.length;i++){
            Student_Info st=new Student_Info();
            st.setName(studentname[i]);
            st.setImage(studentimage.getResourceId(i,-1));
            studentArraylist.add(st);
        }
    }


}
