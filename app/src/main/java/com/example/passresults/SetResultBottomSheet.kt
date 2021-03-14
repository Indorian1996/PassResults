package com.example.passresults

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.setFragmentResult
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_set_result.*

class SetResultBottomSheet: BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bootom_sheet_set_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText.addTextChangedListener {
            it?.toString()?.let { result ->
                val key = GetResultFragment.DIALOG_RESULT_KEY
                Log.d(key, "set result $result")
                setFragmentResult(
                    requestKey = GetResultFragment.DIALOG_RESULT_KEY,
                    bundleOf(Pair(key, result))
                )
            }
        }
    }
}