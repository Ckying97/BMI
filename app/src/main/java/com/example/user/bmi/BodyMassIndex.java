package com.example.user.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class BodyMassIndex extends AppCompatActivity {
    //Global or module level available
    private EditText editTextWeight, editTextHeight;
    private TextView BMI;
    private ImageView image;

    //onCreate=main()function
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView method displays the UI
        //R=resource class
        setContentView(R.layout.activity_body_mass_index);

        //Linking program with UI
        editTextWeight=(EditText)findViewById(R.id.editText);
        editTextHeight=(EditText)findViewById(R.id.editText2);
        BMI=(TextView)findViewById(R.id.textView);
        image=(ImageView)findViewById(R.id.imageView);
    }

    //A method to handle View click event
    public void displayMessage(View view){
        double weight,height,bmi;

        weight=Double.parseDouble(editTextWeight.getText().toString());
        height=Double.parseDouble(editTextHeight.getText().toString());

        height=height/100;
        bmi=weight/(height*height);

        if(bmi<=18.5) {
            BMI.setText("Under Weight");
            image.setImageResource(R.drawable.under);
        }
        else if (bmi>=25) {
            BMI.setText("Over weight");
            image.setImageResource(R.drawable.over);
        }
        else {
            BMI.setText("Normal");
            image.setImageResource(R.drawable.normal);
        }
    }

    public void resetScreen(View view){
        editTextWeight.setText("");
        editTextHeight.setText("");
        BMI.setText("");
        image.setImageResource(R.drawable.empty);
    }
}
