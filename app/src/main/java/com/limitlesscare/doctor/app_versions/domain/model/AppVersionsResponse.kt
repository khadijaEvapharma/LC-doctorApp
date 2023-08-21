package com.limitlesscare.doctor.app_versions.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppVersionsResponse(
    @SerializedName("android") val android: AppVersions? = null,
    @SerializedName("ios") val iOS: AppVersions? = null,
    @SerializedName("configuration") val configuration: AppVersions? = null,
    @SerializedName("specialities") val specialities: AppVersions? = null,
) : Parcelable
