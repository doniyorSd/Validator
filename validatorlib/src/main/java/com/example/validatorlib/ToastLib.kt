package com.example.validatorlib

import android.content.Context
import android.widget.Toast

object ToastLib {
    fun showMessage(context: Context, message: String) {
        Toast.makeText(context, "$message", Toast.LENGTH_SHORT).show()
    }
}