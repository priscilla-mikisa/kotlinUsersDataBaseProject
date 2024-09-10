package com.akirachix.mycontacts.api

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface apiInterface {
    @Multipart
    @POST("/selfie")
    suspend fun postPhoto(
        @Part image: MultipartBody.Part,
        @Part caption: MultipartBody.Part
    ): Response<SelfieResponse>

}
