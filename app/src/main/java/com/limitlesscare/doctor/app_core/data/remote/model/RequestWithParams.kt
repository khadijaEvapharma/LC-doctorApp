package com.jo.mvicleandemo.app_core.data.remote.model

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class RequestWithParams<T>(
    @Transient
    val input:@RawValue T
) : Parcelable
