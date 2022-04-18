package com.adl.movieomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.movieomdb.model.OMDBResponse
import com.adl.movieomdb.model.SearchItem
import com.adl.movieomdb.service.NetworkConfig
import com.adl.ujiancrud.adapter.OMDBAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var listMovie = ArrayList<SearchItem?>()
    lateinit var movieAdapter :OMDBAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSearch.setOnClickListener({
            NetworkConfig().getService()
                .getMovie(txtSearch.text.toString())
                .enqueue(object : Callback<OMDBResponse> {
                    override fun onFailure(call: Call<OMDBResponse>, t: Throwable) {
                        Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                        call: Call<OMDBResponse>,
                        response: Response<OMDBResponse>
                    ) {
                        Log.d("Response",response.toString())

                        listMovie = response.body()?.search!!

                        movieAdapter = ArrayList(listMovie)?.let { OMDBAdapter(it) }
                        lstMovie.apply{
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = movieAdapter
                        }
                    }
                })
        })

    }
}