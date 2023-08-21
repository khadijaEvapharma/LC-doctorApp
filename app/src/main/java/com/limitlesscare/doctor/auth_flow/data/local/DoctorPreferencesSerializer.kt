package com.limitlesscare.doctor.auth_flow.data.local

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.limitlesscare.doctor.DoctorData
import java.io.InputStream
import java.io.OutputStream

object DoctorPreferencesSerializer : Serializer<DoctorData> {
    override val defaultValue: DoctorData = DoctorData.getDefaultInstance()
    override suspend fun readFrom(input: InputStream): DoctorData {
        try {
            return DoctorData.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: DoctorData, output: OutputStream) = t.writeTo(output)
}
