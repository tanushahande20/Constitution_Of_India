package com.example.constitution_of_india.Roomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.constitution_of_india.Adapters.Rd_adapter;
import com.example.constitution_of_india.R;

import java.util.List;

public class InsertActivity extends AppCompatActivity implements AdapterListener {
    EditText text26, text27;
    ImageView save;
    RecyclerView rv;
    UserDatabase userDatabase;
    UserDao userDao;
    Rd_adapter rd_adapter;
    LinearLayoutManager linearLayoutManager;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        text26 = findViewById(R.id.text26);
        text27 = findViewById(R.id.text27);
        save = findViewById(R.id.save);
        rv = findViewById(R.id.rv);
        userDatabase = UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = text26.getText().toString();
                String text = text27.getText().toString();

                PojoOne pojoOne = new PojoOne(0, title, text);
                rd_adapter.addUser(pojoOne);
                userDao.Insert(pojoOne);
                text26.setText("");
                text27.setText("");
                Toast.makeText(InsertActivity.this, "Inserted", Toast.LENGTH_SHORT).show();

            }
        });
        rd_adapter = new Rd_adapter(this,this);

        linearLayoutManager = new LinearLayoutManager(this);
        rv.setAdapter(rd_adapter);
        rv.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        fetchData();
    }

    private void fetchData() {
        rd_adapter.clearData();
        List<PojoOne> pojos = userDao.getAllUsers();
        for (int i = 0; i < pojos.size(); i++) {
            PojoOne pojo = pojos.get(i);
            rd_adapter.addUser(pojo);
        }

    }

    @Override
    public void OnUpdate(PojoOne pojo) {
        Intent i =  new Intent(InsertActivity.this,UpdateActivity.class);
        i.putExtra("modal",pojo);
        startActivity(i);

    }

    @Override
    public void OnDelete(int id, int pos) {
        userDao.delete(id);
        rd_adapter.removeUser(pos);


    }
}