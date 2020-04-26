package com.diki.idn.quiz


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_addition.*
import kotlinx.android.synthetic.main.fragment_addition.input1
import kotlinx.android.synthetic.main.fragment_addition.input2
import kotlinx.android.synthetic.main.fragment_addition.tv_result
import kotlinx.android.synthetic.main.fragment_devider.*
import kotlinx.android.synthetic.main.fragment_multiplication.*

/**
 * A simple [Fragment] subclass.
 */
class DeviderFragment : Fragment() {
    private lateinit var inputOne: String
    private lateinit var inputSecond: String
    private var resultDevider: Double? = null

    companion object {
        fun newInstance(): DeviderFragment {
            val fragment = DeviderFragment()
            val arg = Bundle()
            fragment.arguments = arg
            return fragment
        }
    }

    private var fieldEmpty: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devider, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calculate4.setOnClickListener {
            inputOne = input1.text.toString().trim()
            inputSecond = input2.text.toString().trim()

            if (inputOne.isEmpty()) {
                fieldEmpty = true
                input1.error = resources.getString(R.string.error_empty_field)
            }
            if (inputSecond.isEmpty()) {
                fieldEmpty = true
                input2.error = resources.getString(R.string.error_empty_field)
            }
            if (!fieldEmpty) {
                resultDevider = (inputOne.toDouble() / inputSecond.toDouble())
                tv_result.setText(resultDevider.toString())
            }

        }

    }
}
