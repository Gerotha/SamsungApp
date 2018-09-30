package com.insightvalley.samsungapp;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class HomeActivity extends AppCompatActivity {

    private DatabaseReference firebaseReference = FirebaseDatabase.getInstance(). getReference();
    private Button mainButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNav);
        mainButton = findViewById(R.id.btnPlus);

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateModal();
            }
        });


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new TaskFragment()).commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_user:
                            selectedFragment = new UserFragment();
                            break;
                        case R.id.nav_tasks:
                            selectedFragment = new TaskFragment();
                            break;
                        case R.id.nav_modal:
                            //Deveria ser o botao mais é nois
                            selectedFragment = new UserFragment();
                            break;
                        case R.id.nav_dashboard:
                            selectedFragment = new DashboardFragment();
                            break;
                        case R.id.nav_habits:
                            selectedFragment = new HabitsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

     private void openCreateModal(){

        LayoutInflater li = getLayoutInflater();
        View modalView = li.inflate(R.layout.activity_main_modal,null);

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(HomeActivity.this);

         final EditText mTaskTime = modalView.findViewById(R.id.editTxtTaskHour);
         final EditText mTaskDate = modalView.findViewById(R.id.editTxtTaskDate);
         final EditText mTaskTitle = modalView.findViewById(R.id.editTxtTaskTitle);
         final EditText mTaskDescription = modalView.findViewById(R.id.editTxtTaskDescription);
         Button mBtnAddTask = modalView.findViewById(R.id.btnAddTask);


         alertDialog.setView(modalView);

         final AlertDialog dialog = alertDialog.create();

         mBtnAddTask.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 //Puxa informações do modal
                 Task task = new Task();
                 task.setHour(mTaskTime.getText().toString());
                 task.setDate(mTaskDate.getText().toString());
                 task.setTitle(mTaskTitle.getText().toString());
                 task.setDescription(mTaskDescription.getText().toString());

                 Log.e("TASK INSERT", task.toString());

                 //Insere no firebase
                 firebaseReference.child("tasks").push().setValue(task);

                 //Fecha o modal
                 dialog.dismiss();
             }
         });

         //Mostra o modal
         dialog.show();
     }




}