package com.insightvalley.samsungapp;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TaskFragment extends Fragment {

    private ListView taskListView;
    private ArrayAdapter adapter;
    private ArrayList<Task> taskList;
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference taskRef = databaseReference.child("tasks");
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        taskList = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_task, container, false);

        taskListView = view.findViewById(R.id.listViewTaskList);

        adapter = new taskAdapter(getActivity(), taskList);

        taskListView.setAdapter(adapter);


        taskRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                taskList.clear();

                for(DataSnapshot dadoFireBase : dataSnapshot.getChildren()){

                    Log.e("FIREBASE", dadoFireBase.toString());
                    Task task = dadoFireBase.getValue( Task.class );
                    Log.e("dado adicionado", task.toString());

                    taskList.add( task );
                }

                adapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Se deu ruim
            }
        });

        return view;
    }
}