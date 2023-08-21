package com.limitlesscare.doctor.app_core.constants

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
enum class UserGender(val value: String) : Parcelable {
    @SerializedName("Male")
    MALE("Male"),

    @SerializedName("Female")
    FEMALE("Female"),

    @SerializedName("")
    DEFAULT("");

    companion object {
        operator fun invoke(rawValue: String) = values()
            .find { it.value == rawValue }
    }
}