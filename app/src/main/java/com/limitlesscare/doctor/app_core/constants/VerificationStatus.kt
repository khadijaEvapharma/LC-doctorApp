package com.limitlesscare.doctor.app_core.constants

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
enum class VerificationStatus(val value: String) :Parcelable{
    @SerializedName("NEEDS_VERIFICATION")
    NEEDS_VERIFICATION("NEEDS_VERIFICATION"),

    @SerializedName("PENDING_VERIFICATION")
    PENDING_VERIFICATION("PENDING_VERIFICATION"),

    @SerializedName("VERIFIED")
    VERIFIED("VERIFIED"),

    @SerializedName("REJECTED")
    REJECTED("REJECTED");

    companion object {
        val DEFAULT: VerificationStatus = VERIFIED
        operator fun invoke(rawValue: String) = values()
            .find { it.value == rawValue }
    }
}