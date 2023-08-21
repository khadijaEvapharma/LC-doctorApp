package com.limitlesscare.doctor.app_core.data.remote.exception

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApiError(
    @SerializedName("path")
    val path: String?,
    @SerializedName("message")
    val message: String?
):Parcelable