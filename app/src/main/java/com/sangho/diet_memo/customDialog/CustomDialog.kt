package com.sangho.diet_memo.customDialog

import android.app.Activity
import android.app.Application
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.sangho.diet_memo.R
import com.sangho.diet_memo.databinding.CustomDialogBinding

class CustomDialog() : DialogFragment() {

    lateinit var binding: CustomDialogBinding
    val TAG = "LifeCycle"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.i(TAG,"CustomDialog-fragment-LifeCycle-onCreateView")
        binding = CustomDialogBinding.inflate(layoutInflater)
        val view = binding.root

        return view
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"CustomDialog-fragment-LifeCycle-onStart")
        dialog?.window?.setLayout(   //다이얼로그사이즈조정
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog?.setCancelable(false)
    }

    //아래는 fragment life cycle 확인용 코드입니다.

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        Log.i(TAG,"CustomDialog-fragment-LifeCycle-onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"CustomDialog-fragment-LifeCycle-onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i(TAG,"CustomDialog-fragment-LifeCycle-onViewCreated")
    }

    //여기까지 fragment life cycle 확인용 코드입니다.
}