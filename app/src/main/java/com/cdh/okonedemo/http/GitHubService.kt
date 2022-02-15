package com.cdh.okonedemo.http

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Query


interface GitHubService {

    @GET("/search/users")
    fun listRepos(@Query("q") user: String?): Call<SearchData?>?

    @HEAD("a")
    fun preConnect(): Call<Void>?


}