package com.tmannapps.converterapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner mySpinnerSourceUnit;
    Spinner mySpinnerDestinationUnit;
    Button myButtonConvert;
    TextView myTextViewSource;
    TextView myTextViewDestination;
    EditText myTextEnterNumber;
    TextView myTextAnswer;

// Tiffany Mann SIT708 Task 2.1 Converter App Student ID: 221457972
    @Override
   public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextViewSource = findViewById(R.id.myTextViewSourceUnit);
        myTextViewDestination = findViewById(R.id.myTextViewDestinationUnit);
        myTextAnswer = findViewById(R.id.myTextAnswer);
        myTextEnterNumber = findViewById(R.id.myTextEnterNumber);
        mySpinnerSourceUnit = findViewById(R.id.mySpinnerSourceUnit);
        myButtonConvert = findViewById(R.id.myButtonConvert);
        //Source spinner config here
        ArrayAdapter<CharSequence> adapterSource = ArrayAdapter.createFromResource(this, R.array.Units, android.R.layout.simple_spinner_item);
        adapterSource.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerSourceUnit.setAdapter(adapterSource);
        mySpinnerSourceUnit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mySpinnerDestinationUnit = findViewById(R.id.mySpinnerDestinationUnit);
                ArrayAdapter<CharSequence> adapterDest = ArrayAdapter.createFromResource(adapterView.getContext(), R.array.Units, android.R.layout.simple_spinner_item);
                adapterDest.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mySpinnerDestinationUnit.setAdapter(adapterDest);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Please select a source unit ", Toast.LENGTH_SHORT).show();
            }
        });

        myButtonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // error handling if user enters an invalid entry such as a decimal point only, or a double value
                try {
                myTextEnterNumber = (EditText)findViewById(R.id.myTextEnterNumber);
                String value = myTextEnterNumber.getText().toString();
                double inputValue = Double.parseDouble(value);

                // create an empty list to add the src snd dest selection items t
                List selection = new ArrayList();
                // create a variable to store the conversion value to
                Double output = 0.0;
                // set the resulting value as the input value multiplied by the conversion value
                Double result = 0.0;

               switch (mySpinnerSourceUnit.getSelectedItem().toString()) {
                   case "Kilograms":
                       selection.add("KG");
                       break;
                   case "Grams":
                       selection.add("G");
                       break;
                   case "Milligrams":
                       selection.add("MG");
                       break;
                   case "Pounds":
                       selection.add("LB");
                       break;
                   case "Ounces":
                       selection.add("OZ");
                       break;
                   case "How many cats?":
                       selection.add("nCAT");
                       break;
               }

                switch (mySpinnerDestinationUnit.getSelectedItem().toString()) {
                    case "Kilograms":
                        selection.add("kg");
                        break;
                    case "Grams":
                        selection.add("g");
                        break;
                    case "Milligrams":
                        selection.add("mg");
                        break;
                    case "Pounds":
                        selection.add("lb");
                        break;
                    case "Ounces":
                        selection.add("oz");
                        break;
                    case "How many cats?":
                        selection.add(" Cats");
                        break;
                }
                //Depending on the source and dest items in the list, create a conversion value for each possibility
                if (selection.get(0) == "KG") {
                    if (selection.get(1) == "g")
                        output = 1000.0;
                    else if (selection.get(1) == "mg")
                        output = 1000000.0;
                    else if (selection.get(1) == "lb")
                        output = 2.20462;
                    else if (selection.get(1) == "oz")
                        output = 35.27396;
                    else if (selection.get(1) == " Cats")
                        output = 0.166667;
                    else if (selection.get(1) == "kg")
                        output = inputValue;}
                else if (selection.get(0) == "G")
                    {if (selection.get(1) == "g")
                        output = inputValue;
                    else if (selection.get(1) == "mg")
                        output = 1000.0;
                    else if (selection.get(1) == "lb")
                        output = .00220462;
                    else if (selection.get(1) == "oz")
                        output = .03527396;
                    else if (selection.get(1) == " Cats")
                        output = .000166667;
                    else if (selection.get(1) == "kg")
                        output = .001;}
                else if (selection.get(0) == "MG")
                        {if (selection.get(1) == "g")
                        output = .001;
                    else if (selection.get(1) == "mg")
                        output = inputValue;
                    else if (selection.get(1) == "lb")
                        output = .00000220462;
                    else if (selection.get(1) == "oz")
                        output = .00003527396;
                    else if (selection.get(1) == " Cats")
                        output = 0.000000166667;
                    else if (selection.get(1) == "kg")
                        output = 0.0000001;}
                else if (selection.get(0) == "LB") {
                    if (selection.get(1) == "g")
                        output = 453.59237;
                    else if (selection.get(1) == "mg")
                        output = 453592.37;
                    else if (selection.get(1) == "lb")
                        output = inputValue;
                    else if (selection.get(1) == "oz")
                        output = 16.0;
                    else if (selection.get(1) == " Cats")
                        output = 0.083;
                    else if (selection.get(1) == "kg")
                        output = 0.45359;}
                else if (selection.get(0) == "OZ") {
                    if (selection.get(1) == "g")
                        output = 28.3492;
                    else if (selection.get(1) == "mg")
                        output = 28349.2;
                    else if (selection.get(1) == "lb")
                        output = 0.0625;
                    else if (selection.get(1) == "oz")
                        output = inputValue;
                    else if (selection.get(1) == " Cats")
                        output = 0.005187;
                    else if (selection.get(1) == "kg")
                        output = 0.02835;}
                else if (selection.get(0) == "nCAT") {
                    if (selection.get(1) == "g")
                        output = 6000.0;
                    else if (selection.get(1) == "mg")
                        output = 6000000.0;
                    else if (selection.get(1) == "lb")
                        output = (2.20462 * 6);
                    else if (selection.get(1) == "oz")
                        output = (35.27396 * 6);
                    else if (selection.get(1) == " Cats")
                        output = inputValue;
                    else if (selection.get(1) == "kg")
                        output = 6.0;}

                // add error handling here for if input value is not a number

                    if (output == inputValue) {
                        // error handling for input value and output value the same
                        myTextAnswer.setText("Units are the same, please try again");
                    } else {
                        //convert the value to a string, and pass to the text box
                        result = inputValue * output;
                        String stringResult = String.valueOf(result);
                        myTextAnswer.setText(stringResult + (selection.get(1)));
                    }
                } catch (Exception exception) {
                    Toast.makeText(MainActivity.this, "Please enter a number ", Toast.LENGTH_SHORT).show();
                }




                //use this to practice locating spinner elements
                //Toast.makeText(MainActivity.this, "Please enter a number ", Toast.LENGTH_SHORT).show();


            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}