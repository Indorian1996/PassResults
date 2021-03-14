package com.example.passresults

import android.os.Bundle
import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import java.io.Serializable

fun FragmentManager.setResult(key: String, data: Serializable) {
    setFragmentResult(key, bundleOf(Pair(key, data)))
}

fun FragmentManager.setResult(key: String,data: String) {
    Log.d(key, "set result $data")
    setFragmentResult(key, bundleOf(Pair(key, data)))
}