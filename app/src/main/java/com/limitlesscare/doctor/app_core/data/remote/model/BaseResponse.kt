package com.limitlesscare.doctor.app_core.data.remote.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.limitlesscare.core.domain.DataState
import com.limitlesscare.doctor.app_core.data.remote.exception.ApiError
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import retrofit2.HttpException
import retrofit2.Response

@Parcelize
data class BaseResponse<T>(
    @SerializedName("data")
    val data: @RawValue T? = null,

    @SerializedName("message")
    val message: String = "",

    @SerializedName("code")
    val code: Int = 0,

    @SerializedName("error")
    val error: ApiError? = null,

    @SerializedName("errorsList")
    val errors: List<ApiError>? = null
):Parcelable


fun <T> Response<BaseResponse<T>>.getDataState(): DataState<T> {
    val responseBody = body()
    return if (isSuccessResponse(responseBody))
        DataState.Success(data = responseBody!!.data!!)
     else
        DataState.Error(throwable = HttpException(this))
}

private fun <T> Response<BaseResponse<T>>.isSuccessResponse(
    responseBody: BaseResponse<T>?
) = isSuccessful && responseBody != null && responseBody.data != null
        && responseBody.error == null && responseBody.errors == null


