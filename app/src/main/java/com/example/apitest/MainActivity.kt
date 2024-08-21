package com.example.apitest

import CatFactResponse
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apitest.adapter.CatFactAdapter
import com.example.apitest.databinding.ActivityMainBinding
import com.example.apitest.databinding.ActivitySecondtestactivityBinding
import com.example.apitest.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter:CatFactAdapter
    private  val TAG = "MainActivity"
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchCatFact()
        setUpRV()

    }

    private fun setUpRV() {
        val layoutManager= LinearLayoutManager(this)
        binding.rv.layoutManager=layoutManager

        adapter=CatFactAdapter()

        binding.rv.adapter=adapter


    }

    private fun fetchCatFact(){
    val services= RetrofitClient.getServices()
      val call= services.fetchCatFacts()

       call.enqueue(object :Callback<CatFactResponse>{
           override fun onResponse(p0: Call<CatFactResponse>, response: Response<CatFactResponse>) {
               val body=response.body()
              viewCatFact(body)
           }

           override fun onFailure(p0: Call<CatFactResponse>, error: Throwable) {
              // Toast.makeText(this@MainActivity,"${error.message}",Toast.LENGTH_LONG)
               Log.d(TAG,"${error?.message}")
           }

       })
    }

    private fun viewCatFact(body: CatFactResponse?) {
     if(::adapter.isInitialized){
        body?.let {
            adapter.setDataSource(it.data)
        }
     }


    }
}