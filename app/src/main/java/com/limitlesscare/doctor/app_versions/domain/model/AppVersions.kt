package com.limitlesscare.doctor.app_versions.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppVersions(
    @SerializedName("currentVersion") val currentVersion: String?,
    @SerializedName("minimumVersion") val minimumVersion: String?,
) : Parcelable