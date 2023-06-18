package com.example.submissionawal

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getGithub(
        @Query("q") query: String
    ): Call<GithubResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetail(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<Users>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<Users>>
}