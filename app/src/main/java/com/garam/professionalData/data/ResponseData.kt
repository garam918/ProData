package com.garam.professionalData.data

data class ResponseData(
    val lastBuildDate : String,
    val total : Int,
    val start : Int,
    val display : Int,
    val items: Array<Items>
) {
    data class Items(
        val title : String,
        val link : String,
        val description : String
    )
}
