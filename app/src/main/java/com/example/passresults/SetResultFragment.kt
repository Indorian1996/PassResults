package com.example.passresults

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_set_result.*

class SetResultFragment: Fragment(R.layout.fragment_set_result) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editText.addTextChangedListener {
            it?.let { parentFragmentManager.setResult(GetResultFragment.FRAGMENT_RESULT_KEY, it.toString()) }
        }
    }
}