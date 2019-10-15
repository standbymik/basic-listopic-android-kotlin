package com.standbymik.standbymik2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.standbymik.standbymik2.model.RoomTopic
import com.standbymik.standbymik2.service.ForumService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private  val forumAdapter = ForumAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callService()
        setupView()
    }

    private fun setupView() {
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.adapter = forumAdapter
    }

    private fun callService() {
        val service = ForumService.create()

        service.getRoomTopic("food", null).enqueue(object : Callback<RoomTopic?> {
            override fun onFailure(call: Call<RoomTopic?>, t: Throwable) {
                Log.d(TAG,"Error = [$t]")
            }

            override fun onResponse(call: Call<RoomTopic?>, response: Response<RoomTopic?>) {
                val body = response.body()
                forumAdapter.submitList(body?.data)
                Log.d(TAG,"call = [$call] , response = [$body]")
            }
        })

    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
