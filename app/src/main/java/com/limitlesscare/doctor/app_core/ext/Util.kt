package com.limitlesscare.doctor.app_core.ext

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    val lastEmailPattern = listOf(".com", ".org", ".net", ".edu")
    return (Patterns.EMAIL_ADDRESS.matcher(this.trim()).matches()
            && lastEmailPattern.contains(this.trim().takeLast(4))) || this.isEmpty()
}

fun String.isValidPassword(): Boolean {
    return (this.length >= 6)
}