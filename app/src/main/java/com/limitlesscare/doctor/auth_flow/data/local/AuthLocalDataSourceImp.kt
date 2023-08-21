package com.limitlesscare.doctor.auth_flow.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.limitlesscare.doctor.DoctorData
import com.limitlesscare.doctor.app_core.constants.AppConstants.DATA_STORE_FILE_NAME
import com.limitlesscare.doctor.auth_flow.domain.model.LoginResponse
import com.limitlesscare.doctor.auth_flow.domain.model.toAuthData
import com.limitlesscare.doctor.auth_flow.domain.model.toDoctorData
import kotlinx.coroutines.flow.first
import javax.inject.Inject

val Context.userPreferencesStore: DataStore<DoctorData> by dataStore(
    fileName = DATA_STORE_FILE_NAME,
    serializer = DoctorPreferencesSerializer
)

class AuthLocalDataSourceImp @Inject constructor(
    private val dataStore: DataStore<DoctorData>
) : AuthLocalDataSource {
    override suspend fun updateDoctorData(loginResponse: LoginResponse) {
        dataStore.updateData {
            loginResponse.toDoctorData(it.toBuilder())
        }
    }

    override suspend fun getToken(): String {
        return dataStore.data.first().accessToken
    }

    override suspend fun getDoctorData(): LoginResponse {
        return dataStore.data.first().toAuthData()
    }
}