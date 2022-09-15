package com.example.model

data class Profile(
    val `data`: List<Data>,
    val header: Header
){
    class Header
    data class Data(
        val id: String,
        val age: Int?,
        val birth_day: String?,
        val cover_picture_path: String?,
        val created: String,
        val description: String?,
        val first_name: String?,
        val gender: String?,
        val last_name: String?,
        val last_updated: String?,
        val name: String,
        val native_place: String?,
        val nick_name: String?,
        val picture_path: String?,
        val place_of_study: String?,
        val place_of_work: String?,
        val rating: Double?,
        val reg_email: String?,
        val reg_phone: String?,
        val residence_place: String?,
        val status: String,
        val subscriber_count: Int,
        val subscription_count: Int,
        val type: String?,
        val username: String,
    )
}