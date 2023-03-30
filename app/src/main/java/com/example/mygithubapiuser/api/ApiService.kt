package com.example.mygithubapiuser.api

import com.example.mygithubapiuser.ItemsItem
import com.example.mygithubapiuser.UserDetail
import com.example.mygithubapiuser.UserSearchResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun searchUser(
        @Query("q") q : String
    ): Call<UserSearchResponse>
    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getUser(
        @Path("username") q: String
    ): Call<UserDetail>
    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollower(
        @Path("username") q : String
    ): Call<List<ItemsItem>>
    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowing(
        @Path("username") q : String
    ): Call<List<ItemsItem>>
}