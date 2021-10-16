package com.example.pizzaapp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzaapp.R;

public class PriceActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView addItem;
    ImageView addItemMedium;
    ImageView addItemLarge;
    ImageView removeRegular;
    ImageView removeMedium;
    ImageView removeLarge;
    TextView regualerPrice;
    TextView mediumPrice;
    TextView largePrice;
    TextView totalPrice;
    int addPrice=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
        regualerPrice=findViewById(R.id.txtprice);
        mediumPrice=findViewById(R.id.txtMediumPrice);
        largePrice=findViewById(R.id.txtLargePrice);
        totalPrice=findViewById(R.id.txtTotalPrice);
        int regularSize=getIntent().getIntExtra("regularPrice",32);
        int mediumSize=getIntent().getIntExtra("mediumPrice",21);
        int largeSize=getIntent().getIntExtra("largePrice",43);
        regualerPrice.setText(regularSize+"");
        mediumPrice.setText(mediumSize+"");
        largePrice.setText(largeSize+"");
        addItem=findViewById(R.id.addItem);
        addItemMedium=findViewById(R.id.addItemMedium);
        addItemLarge=findViewById(R.id.addItemLarge);
        removeRegular=findViewById(R.id.removeItem);
        removeMedium=findViewById(R.id.removeItemMedium);
        removeLarge=findViewById(R.id.removeItemLarge);
        addItem.setOnClickListener(this);
        addItemMedium.setOnClickListener(this);
        addItemLarge.setOnClickListener(this);
        removeLarge.setOnClickListener(this);
        removeMedium.setOnClickListener(this);
        removeRegular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.addItem:
                addPrice+=Integer.parseInt(regualerPrice.getText().toString());
                totalPrice.setText(addPrice+"");
                break;
            case R.id.addItemMedium:
                addPrice+=Integer.parseInt(mediumPrice.getText().toString());
                totalPrice.setText(addPrice+"");
                break;
            case R.id.addItemLarge:
                addPrice+=Integer.parseInt(largePrice.getText().toString());
                totalPrice.setText(addPrice+"");
                break;
            case R.id.removeItem:
                if (addPrice==0) Toast.makeText(this,"First add pizza",Toast.LENGTH_LONG).show();
                else {
                    addPrice-=Integer.parseInt(regualerPrice.getText().toString());
                    totalPrice.setText(addPrice+"");
                }
                break;
            case R.id.removeItemMedium:
                if (addPrice==0) Toast.makeText(this,"First add pizza",Toast.LENGTH_LONG).show();
                else {
                    addPrice-=Integer.parseInt(mediumPrice.getText().toString());
                    totalPrice.setText(addPrice+"");
                }
                break;
            case R.id.removeItemLarge:
                if (addPrice==0) Toast.makeText(this,"First add pizza",Toast.LENGTH_LONG).show();
                else {
                    addPrice-=Integer.parseInt(largePrice.getText().toString());
                    totalPrice.setText(addPrice+"");
                }
                break;
        }
    }
}