package com.example.data_dagger.di.model

import com.example.model.Profile
import com.example.network_dagger.model.RemoteProfile

fun RemoteProfile.Data.asExternalModel() = Profile.Data(
    id = id,
    age = age,
    birth_day = birth_day,
    cover_picture_path = cover_picture_path,
    created = created,
    description = description,
    first_name = first_name,
    gender = gender,
    last_name = last_name,
    last_updated = last_updated,
    name = name,
    native_place = native_place,
    nick_name = nick_name,
    picture_path = picture_path,
    place_of_study = place_of_study,
    place_of_work = place_of_work,
    rating = rating,
    reg_email = reg_email,
    reg_phone = reg_phone,
    residence_place = residence_place,
    status = status,
    subscriber_count = subscriber_count,
    subscription_count = subscription_count,
    type = type,
    username = username,
)


