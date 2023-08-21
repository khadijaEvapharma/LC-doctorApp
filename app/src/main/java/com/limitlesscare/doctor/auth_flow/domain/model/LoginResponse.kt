package com.limitlesscare.doctor.auth_flow.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.limitlesscare.doctor.DoctorData
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class LoginResponse(
    @SerializedName("accessToken")
    val accessToken: String?,
    @SerializedName("doctorId")
    val doctorId: Int?,
    @SerializedName("fullName")
    val fullName: String?,
    @SerializedName("imagePath")
    val imagePath: String?,
    @SerializedName("permissions")
    val permissions: @RawValue List<Any>?
) : Parcelable

fun LoginResponse.toDoctorData(doctorData: DoctorData.Builder): DoctorData {
    return doctorData
        .setDoctorId(doctorId ?: -1)
        .setAccessToken(accessToken ?: "")
        .setFullName(fullName ?: "")
        .setImagePath(imagePath ?: "").build()
}

fun DoctorData.toAuthData(): LoginResponse {
    return LoginResponse(
        accessToken,
        doctorId,
        fullName,
        accessToken,
        null
    )

}