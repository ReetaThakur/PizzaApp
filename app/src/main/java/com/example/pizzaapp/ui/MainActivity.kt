package com.example.pizzaapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pizzaapp.R
import com.example.pizzaapp.apiCall.APICall
import com.example.pizzaapp.apiCall.ClickListner
import com.example.pizzaapp.apiCall.Network
import com.example.pizzaapp.responseData.Crust
import com.example.pizzaapp.responseData.ResponseDTO
import com.example.pizzaapp.responseData.Size
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),ClickListner {
    private lateinit var viewModelClass: PizzaViewModelClass
    private lateinit var pizzaList: List<Crust>
    private lateinit var responseDTO: ResponseDTO
    private lateinit var sliderView: SliderView
    private lateinit var sizeList: List<Size>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        sliderView=findViewById(R.id.imageSlider)
        setImageSlider()
        viewModelClass= ViewModelProvider(this).get(PizzaViewModelClass::class.java)
        viewModelClass.callApi()
        viewModelClass.liveData.observe(this,{
            it.let {
                pizzaList= it.crusts
                responseDTO=it
                setRecyclerView()

            }
        })
    }



       private fun setImageSlider() {
        var imageSlideList = ArrayList<String>()
        imageSlideList.add("https://static.toiimg.com/thumb/53110049.cms?width=1200&height=900")
        imageSlideList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMTWXbSAvow-MzUboE39OH9h5fMSgOk6uOeA&usqp=CAU")
        imageSlideList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRG5vm_TDTjc64FO6hlWtL8TlWrG5HxdK5P3g&usqp=CAU")
        imageSlideList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNBXbW_HI5GqntiAlekCd7sANM2VYc91di9g&usqp=CAU")
        imageSlideList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTCvSItmAkOC2Fa5sQ_obzt-g2OsTkLveaA4g&usqp=CAU")
        imageSlideList.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe3bAdvu_2PiObusyF3QhRttFnSaGHpe6ntg&usqp=CAU")
        imageSlideList.add("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/delish-homemade-pizza-horizontal-1542312378.png?crop=1.00xw:0.752xh;0,0.139xh&resize=640:*")
        val sliderAdapter=SliderAdapter(imageSlideList)
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.startAutoCycle()
    }

    private fun setRecyclerView() {
        val listAdapter=PizzaAdapter(pizzaList,responseDTO,this)
        val linearLayoutManager= GridLayoutManager(this,2)
        recyclerView.apply {
            adapter=listAdapter
            layoutManager=linearLayoutManager
        }
    }

    override fun click(positon: Int) {
        if (positon == 1) {
            val intent = Intent(this, PriceActivity::class.java)
            intent.putExtra("regularPrice", 235)
            intent.putExtra("mediumPrice", 265)
            intent.putExtra("largePrice", 295)
            startActivity(intent)
        } else {
            val intent = Intent(this, PriceActivity::class.java)
            intent.putExtra("regularPrice", 245)
            intent.putExtra("mediumPrice", 295)
            intent.putExtra("largePrice", 325)
            startActivity(intent)
        }
    }

}