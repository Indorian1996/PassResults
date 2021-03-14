package com.example.passresults

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import kotlinx.android.synthetic.main.fragment_set_result.*

class SetResultFragment : Fragment(R.layout.fragment_set_result) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText.addTextChangedListener {
            it?.toString()?.let { result ->
                val key = GetResultFragment.FRAGMENT_RESULT_KEY
                Log.d(key, "set result $result")
                setFragmentResult(
                    requestKey = GetResultFragment.FRAGMENT_RESULT_KEY,
                    bundleOf(Pair(key, result))
                )
            }
        }
    }
}