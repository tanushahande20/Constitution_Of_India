package com.example.constitution_of_india;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class RateUsDialog extends Dialog {
    private float userRate = 0;
    public RateUsDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rateus);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final AppCompatButton ratenowbtn = findViewById(R.id.ratenowbtn);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final AppCompatButton laterbtn = findViewById(R.id.laterbtn);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final RatingBar ratingBar = findViewById(R.id.ratingbar);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final ImageView ratingimage = findViewById(R.id.ratingimage);
        ratingBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        laterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                if (rating <= 1){
                    ratingimage.setImageResource(R.drawable.one_star);
                }
                else if (rating <=2){
                    ratingimage.setImageResource(R.drawable.two_star);
                }
                else if (rating <=3){
                    ratingimage.setImageResource(R.drawable.three_star);
                }
                else if (rating <=4){
                    ratingimage.setImageResource(R.drawable.four_star);
                }
                else {
                    ratingimage.setImageResource(R.drawable.five_star);
                }
                animationimage(ratingimage);
                userRate = rating;
            }
        });
    }
    private void animationimage(ImageView ratingimage){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1f,0,1f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(200);
        ratingimage.startAnimation(scaleAnimation);
    }
}
