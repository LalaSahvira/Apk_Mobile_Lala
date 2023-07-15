package com.example.quis_lala.app

import com.example.quis_lala.model.ObatModel
import com.example.quis_lala.model.ResponModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
        @FormUrlEncoded
        @POST("tblproduk/save")
        fun saveobat(
            @Body data: ObatModel,
        ): Call<ResponModel>

        @GET("obat")
        fun getObat(): Call<ResponModel>

    }
