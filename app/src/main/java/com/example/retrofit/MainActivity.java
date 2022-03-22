package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit.Adapter.RecyclerAdapter;
import com.example.retrofit.ApiService.ServiceBuilder;
import com.example.retrofit.ApiService.WebService;
import com.example.retrofit.Model.Data;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
   private List<Data> dataList;
   private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loadData();

        recyclerView=findViewById(R.id.recy_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


    }

    private void loadData() {
        dataList=new ArrayList<>();

       WebService service= (WebService) new ServiceBuilder().buildService(WebService.class);
        Call<List<Data>> respondData=service.getData();
        respondData.enqueue(new Callback<List<Data>>()  {

            @Override
            public void onResponse(Call<List<Data>> call, Response<List<Data>> response) {

                if(response.isSuccessful()){
                    dataList=response.body();
                    RecyclerAdapter adapter=new RecyclerAdapter(MainActivity.this,dataList);
                    recyclerView.setAdapter(adapter);
                    Log.d("msg",dataList.toString());
                }else{
                    Log.d("msg","fail");
                }

            }
            @Override
            public void onFailure(Call<List<Data>> call, Throwable t) {
             Log.d("msg",t.getMessage());
            }
        });
    }

}