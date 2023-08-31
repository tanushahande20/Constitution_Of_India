package com.example.constitution_of_india.Roomdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.constitution_of_india.R;

public class UpdateActivity extends AppCompatActivity {
    EditText text31 , text32;
    ImageView update2;
    UserDatabase userDatabase;
    UserDao userDao;
    PojoOne pojoOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        userDatabase = UserDatabase.getInstance(this);
        userDao = userDatabase.getDao();
        text31 = findViewById(R.id.text31);
        text32 = findViewById(R.id.text32);
        update2 = findViewById(R.id.update2);
        pojoOne = (PojoOne) getIntent().getSerializableExtra("modal");
        text31.setText(pojoOne.getTitle());
        text32.setText(pojoOne.getName());
        update2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PojoOne userModal = new PojoOne(pojoOne.getId(), text31.getText().toString(),text32.getText().toString());
                userDao.Update(userModal);
                finish();

            }
        });


    }
}