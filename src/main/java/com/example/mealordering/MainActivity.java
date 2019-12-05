package com.example.mealordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText MealPrice ;
TextView seekbarText;
Spinner MealSpinner;
SeekBar quantity_seek;
int quantity  ;
EditText totalPrice;
    int price_of_meal = 0 ;
    double total;
    RadioGroup rg;
    ImageView img;
    CheckBox confirm;
    Button order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       MealPrice = findViewById(R.id.meal_price);
      MealSpinner =findViewById(R.id.meal_spinner);
      quantity_seek = findViewById(R.id.quantity_seekbar);
        totalPrice = findViewById(R.id.total_price);
        seekbarText= findViewById(R.id.seekbar_text);
        rg = (RadioGroup) findViewById(R.id.radio_group);
        img  = findViewById(R.id.image);
        confirm = findViewById(R.id.confirm);
        order = findViewById(R.id.order);


      MealSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


              switch(MealSpinner.getSelectedItem().toString()){
                  case "Poutine" :
                      MealPrice.setText("15");
                      img.setImageResource(R.drawable.poutine);
                      break;
                  case "Begals" :
                      MealPrice.setText("5");
                      img.setImageResource(R.drawable.begals);

                      break;
                  case "Bacon" :
                      MealPrice.setText("10");
                      img.setImageResource(R.drawable.bacon);

                      break;
                  case "Soup" :
                      MealPrice.setText("16");
                      img.setImageResource(R.drawable.soup);

                      break;
                  case "Chips" :
                      MealPrice.setText("8");
                      img.setImageResource(R.drawable.chips);

                      break;
                  case "Sandwich" :
                      MealPrice.setText("12");
                      img.setImageResource(R.drawable.sandwich);

                      break;
                  case "Choose your meal" :
                      MealPrice.setText("");
                      img.setImageResource(R.drawable.food);

                      totalPrice.setText("");
                      break;
              }

          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {
              MealPrice.setText("");

          }
      });


quantity_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        quantity = progress;
    //seekBar.setMax(10);

        if (!MealPrice.getText().toString().isEmpty()) {
            price_of_meal = Integer.valueOf(MealPrice.getText().toString());
           double tax = Double.valueOf((quantity *price_of_meal * 13)/100 );

             total = (quantity * price_of_meal) + tax;
           totalPrice.setText(String.valueOf(total));

            seekbarText.setText(String.valueOf(progress));
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});


rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.ten){
            double tip = ((quantity * price_of_meal) * 10)/100;
            totalPrice.setText(String.valueOf(total + tip ));


//            Toast.makeText(MainActivity.this, "10", Toast.LENGTH_SHORT).show();
        }
        else if (checkedId == R.id.fifteen){
            double tip = ((quantity * price_of_meal) * 15)/100;
            totalPrice.setText(String.valueOf(total + tip ));
//            Toast.makeText(MainActivity.this, "15", Toast.LENGTH_SHORT).show();

        }
      else  if (checkedId == R.id.twenty){
            double tip = ((quantity * price_of_meal) * 20)/100;
            totalPrice.setText(String.valueOf(total + tip ));
           // Toast.makeText(MainActivity.this, "20", Toast.LENGTH_SHORT).show();
        }

    }
});

order.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(totalPrice.getText().toString().trim().length() > 0 && confirm.isChecked()){
            Toast.makeText(MainActivity.this, "Your order has been successfully placed", Toast.LENGTH_SHORT).show();
        }
        else if (totalPrice.getText().toString().trim().length() > 0 && !confirm.isChecked()){
            Toast.makeText(MainActivity.this, "Please confirm your order", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(MainActivity.this, "Please select some food to make the order", Toast.LENGTH_SHORT).show();

        }
        
        

    }
});





        }
    }



















