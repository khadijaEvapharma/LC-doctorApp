package com.limitlesscare.doctor.app_core.data.remote.model

import com.google.gson.annotations.SerializedName
import com.limitlesscare.doctor.app_core.constants.AppConstants.DEFAULT_FIRST_PAGE
import com.limitlesscare.doctor.app_core.constants.AppConstants.DEFAULT_PAGE_SIZE


data class PaginationRequest(
    @Transient
    val isRefreshing: Boolean = false,
    @SerializedName("pageNumber")
    val pageNumber: Int = DEFAULT_FIRST_PAGE,
    @SerializedName("pageSize")
    val pageSize: Int = DEFAULT_PAGE_SIZE
)
