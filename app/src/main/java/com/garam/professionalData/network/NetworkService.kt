package com.garam.professionalData.network

import com.garam.professionalData.data.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NetworkService {

    @GET("/v1/search/doc.json")
    fun search(
        @Header ("X-Naver-Client-Id") clientId: String,
        @Header ("X-Naver-Client-Secret") clientSecret: String,
        @Query("query") query : String,
        @Query("display") display : Int?,
        @Query("start") start : Int?
    ) : Call<ResponseData>
}