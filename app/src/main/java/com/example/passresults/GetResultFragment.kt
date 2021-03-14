package com.example.passresults

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_get_result.*

class GetResultFragment : Fragment(R.layout.fragment_get_result) {

    companion object {
        const val FRAGMENT_RESULT_KEY = "FRAGMENT_RESULT_KEY"
        const val DIALOG_RESULT_KEY = "DIALOG_RESULT_KEY"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        parentFragmentManager.setFragmentResultListener(FRAGMENT_RESULT_KEY, this,
            { requestKey, result ->
                (result.get(requestKey) as? String)?.let {
                    Log.d("passed result(fragment)", it)
                    resultFragment.text = it
                }
            }
        )
        parentFragmentManager.setFragmentResultListener(DIALOG_RESULT_KEY, this,
            { requestKey, result ->
                (result.get(requestKey) as? String)?.let {
                    Log.d("passed result(dialog)", it)
                    resultDialog.text = it
                }
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonSetResultDialog.setOnClickListener {
            findNavController().navigate(R.id.setResultBottomSheet)
        }
        buttonSetResultFragment.setOnClickListener {
            findNavController().navigate(R.id.setResultFragment)
        }

    }
}