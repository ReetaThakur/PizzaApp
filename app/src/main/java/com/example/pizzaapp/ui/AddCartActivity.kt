package com.example.pizzaapp.ui

import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pizzaapp.R
import kotlinx.android.synthetic.main.activity_add_cart.*

class AddCartActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_cart)
        //var data=intent
        var regularSize=intent.getIntExtra("regularPrice",32)
        var mediumSize=intent.getIntExtra("mediumPrice",21)
        var largeSize=intent.getIntExtra("largePrice",43)
        txtprice.text=regularSize.toString()
        txtMediumPrice.text=mediumSize.toString()
        txtLargePrice.text=largeSize.toString()
        addItem.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        var id:Int= view!!.id

        when(id){
            R.id.addItem ->

               txtTotalPrice.text =txtprice.text

        }
    }
}