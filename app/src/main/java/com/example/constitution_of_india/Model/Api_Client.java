package com.example.constitution_of_india.Model;

import android.content.Context;

import com.example.constitution_of_india.Pojos.Ammendment;
import com.example.constitution_of_india.Pojos.Article;
import com.example.constitution_of_india.Pojos.CaseStudies;
import com.example.constitution_of_india.Pojos.NewsArticle;
import com.example.constitution_of_india.Pojos.Notification;
import com.example.constitution_of_india.Pojos.Parts;
import com.example.constitution_of_india.Pojos.Preamble;
import com.example.constitution_of_india.Pojos.Schedule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class Api_Client {public static TrycatchInterface trycatchInterface;

    public static TrycatchInterface getTrycatchInterface(Context context) {
        if(trycatchInterface == null) {
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(80, TimeUnit.SECONDS)
                    .connectTimeout(80, TimeUnit.SECONDS)
                    .build();

            Gson gson =new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://mapi.trycatchtech.com")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();

            trycatchInterface = retrofit.create(TrycatchInterface.class);
        }
        return trycatchInterface;
    }
    public interface TrycatchInterface{
        @GET("/v1/constitution_of_india/constitution_of_india_preamble")
        Call<List<Preamble>> getData();

        @GET("/v1/constitution_of_india/constitution_of_india_amendments")
        Call<List<Ammendment>> getAmendmentData();

        @GET("/v1/constitution_of_india/constitution_of_india_schedule")
        Call<List<Schedule>> getScheduleData();

        @GET("/v1/constitution_of_india/constitution_of_india_news_article")
        Call<List<NewsArticle>> getNewsData();

        @GET("/v1/constitution_of_india/constitution_of_india_case_study")
        Call<List<CaseStudies>> getCaseData();

        @GET("/v1/constitution_of_india/constitution_of_india_parts")
        Call<List<Parts>> getPartsData();

        @GET("/v1/constitution_of_india/constitution_of_india_articles?part_id=1")
        Call<List<Article>> getArticleData(@Query("part_id") int part_id);

        @GET("/v1/constitution_of_india/constitution_of_india_articles?part_id=1")
        Call<List<Article>> getArticlesData();

        @GET("/v1/constitution_of_india/constitution_of_india_notification")
        Call<List<Notification>> getNotificationsData();

    }
}
