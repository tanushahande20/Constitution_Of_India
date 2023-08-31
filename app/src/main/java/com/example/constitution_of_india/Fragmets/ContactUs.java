package com.example.constitution_of_india.Fragmets;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.constitution_of_india.R;

public class ContactUs extends AppCompatActivity {
    EditText ename, eemail, ephone, ecity, emessage ;

    String name ,email, phone, city, message;

    TextView send;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        ename = findViewById(R.id.ename);
        eemail = findViewById(R.id.eemail);
        ephone = findViewById(R.id.ephone);
        ecity = findViewById(R.id.ecity);
        emessage = findViewById(R.id.emessage);
        send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ename.getText().toString();
                email = eemail.getText().toString();
                phone = ephone.getText().toString();
                city = ecity.getText().toString();
                message = emessage.getText().toString();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || city.isEmpty() || message.isEmpty() ) {
//                    Toast.makeText(getContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    Toast.makeText(ContactUs.this, "Fill Above Information", Toast.LENGTH_SHORT).show();
                    return;
                }
                String recipientEmail = "tanushahande20@gmail.com"; // Set your email address here
                String subject = "Contact Us Message";
                String emailBody = "Name: " + name + "\n\nEmail: " + email + " \n\nPhone: " +phone+" \n\nCity" + city+"\n\nQuery:"+message;

                String mail = "mailto:"+ recipientEmail+
                        "?&subject="+ Uri.encode(subject)+
                        "?&body=" + Uri.encode(emailBody);
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse(mail));
                try {
                    startActivity(Intent.createChooser(intent,"Send Email..."));
                }catch (Exception e){
                    Toast.makeText(ContactUs.this, "Please Try Again Later", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}