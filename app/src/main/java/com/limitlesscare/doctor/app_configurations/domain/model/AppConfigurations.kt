package com.limitlesscare.doctor.app_configurations.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class AppConfigurations(
    @SerializedName("dummyConfigs")
    val dummyConfigs: List<String> = listOf()
) : Parcelable
