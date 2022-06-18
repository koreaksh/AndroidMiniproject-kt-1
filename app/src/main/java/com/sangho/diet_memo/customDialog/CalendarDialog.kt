package com.sangho.diet_memo.customDialog

import android.app.DatePickerDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.DatePicker
import com.sangho.diet_memo.R
import com.sangho.diet_memo.databinding.CustomDialogBinding
import java.util.*
import java.util.zip.Inflater

data class CalendarDialog(val context: Context?, val inflate: LayoutInflater) {
    lateinit var dateString : String
    val binding by lazy { CustomDialogBinding.inflate(inflate) }
    fun dataPicker() {
        val cal = Calendar.getInstance()
        val dataSetListener = DatePickerDialog.OnDateSetListener {
            view, year, month, dayOfMonth ->
            dateString = "${year}년 ${month+1}월 ${dayOfMonth}일"
            binding.dataInfo.text = dateString
        }

    }

}