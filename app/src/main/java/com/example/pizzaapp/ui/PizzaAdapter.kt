package com.example.pizzaapp.ui


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.R
import com.example.pizzaapp.apiCall.ClickListner
import com.example.pizzaapp.responseData.Crust
import com.example.pizzaapp.responseData.ResponseDTO
import kotlinx.android.synthetic.main.pizza_item_layout.view.*

class PizzaAdapter(val list:List<Crust>,val responseDTO: ResponseDTO,var click:ClickListner):RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.pizza_item_layout,parent,false)
        return PizzaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val respo= list[position]
        holder.setData(respo,responseDTO)
        holder.btnClick.setOnClickListener {
            click.click(position)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class PizzaViewHolder(val itemView: View):RecyclerView.ViewHolder(itemView){
        var btnClick:Button=itemView.findViewById(R.id.btnAddToCart)
        fun setData(crust: Crust,responseDTO: ResponseDTO){
            itemView.apply {
                txtname.text=crust.name
                description.text=responseDTO.description
                price.text="Price - ${crust.sizes[position].price}"
              if (responseDTO.isVeg==false)   vegOrNonvegCircle.setColorFilter(Color.rgb(255,87,51))
                else  vegOrNonvegCircle.setColorFilter(Color.rgb(34,139,34))

            }
        }

    }
}