package com.gll.testmvvm

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.gll.testmvvm.databinding.DialogLayoutBinding

/**
 * User: highsixty
 * Date: 2020-04-17 18:12
 * email: gaolulin@sunmi.com
 */
class MyDialog:DialogFragment() {

    lateinit var binding:DialogLayoutBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.dialog_layout,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.clicklistener = object : BtnClick {
            override fun onClickListener(view: View, a: Int) {
                Log.d("TAG","11111111111111")
            }
        }
        binding.lifecycleOwner = viewLifecycleOwner
    }

}