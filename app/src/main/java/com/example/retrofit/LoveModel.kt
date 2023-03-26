package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class LoveModel(
   @SerializedName("fname")
   var fistName:String,
   @SerializedName("fname")
   var secondName:String,
   var percentage:String,
   var result:String
):java.io.Serializable

