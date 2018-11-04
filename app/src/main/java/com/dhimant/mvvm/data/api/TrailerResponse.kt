package com.dhimant.mvvm.data.api

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Dhimant Desai on 05/11/18.
 * Copyright 2018. All rights reserved.
 */
data class TrailerResponse(

        @Expose
        @SerializedName("id")
        var id: Integer,
        @Expose
        @SerializedName("results")
        var results: List<Trailer>)

data class Trailer(
        @Expose
        @SerializedName("id")
        val id: String,
        @Expose
        @SerializedName("iso_639_1")
        val iso_639_1: String,
        @Expose
        @SerializedName("iso_3166_1")
        val iso_3166_1: String,
        @Expose
        @SerializedName("key")
        val key: String,
        @Expose
        @SerializedName("name")
        val name: String,
        @Expose
        @SerializedName("site")
        val site: String,
        @Expose
        @SerializedName("size")
        var size: Integer,
        @Expose
        @SerializedName("type")
        val type: String)