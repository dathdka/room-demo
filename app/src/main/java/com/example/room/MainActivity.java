package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.room.database.AppDatabase;
import com.example.room.database.user;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn ;
    EditText name;
    EditText location;
    AppDatabase ad;
    private final ArrayList<user> userList = new ArrayList<user>();
    private ArrayAdapter<user> listViewAdapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        name = (EditText) findViewById(R.id.name);
        location = (EditText) findViewById(R.id.location);
        listView = (ListView) findViewById(R.id.listView);

        ad = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"users")
                .allowMainThreadQueries().build();
        displayUsers();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });
    }

    public void addUser () {
        user u = new user(name.getText().toString(),location.getText().toString());
        ad.uDao().insertUser(u);
        Toast.makeText(this,"new user has been added",Toast.LENGTH_LONG).show();
        finish();
        overridePendingTransition(0, 0);
        startActivity(getIntent());
        displayUsers();
    }

    public void displayUsers (){
        List<user> ul = ad.uDao().getAllUser();
        this.userList.addAll(ul);
        this.listViewAdapter =new ArrayAdapter<user>(this, android.R.layout.simple_list_item_1, android.R.id.text1, this.userList);
        listView.setAdapter(this.listViewAdapter);
    }
}