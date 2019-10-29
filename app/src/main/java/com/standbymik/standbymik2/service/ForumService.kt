package com.standbymik.standbymik2.service

import com.standbymik.standbymik2.model.RoomTopic
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ForumService {

    @GET("forum/room_topic")
    @Headers("authorization: Basic xxx")
    fun getRoomTopic(@Query("room") room: String, @Query("next_id") nextId: Int?): Call<RoomTopic>

    companion object{

        private var service: ForumService? = null

        fun create() :ForumService{
            if(service == null){
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://pantip.com/api/forum-service/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                service = retrofit.create(ForumService::class.java)
            }
            return service!!
        }
    }
}
