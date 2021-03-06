package at.fh.swengb.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextGallon;
    private EditText editTextLiter;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextGallon = (EditText) findViewById(R.id.editTextGallon);
        editTextLiter = (EditText) findViewById(R.id.editTextLiter);
        resultView = (TextView) findViewById(R.id.textViewResult);

    }

    public void convertToLiter(View view){
        String gallonString = editTextGallon.getText().toString();
        double gallon = 0;

        try {
            gallon=Double.parseDouble(gallonString);

            String result = new DecimalFormat("##.##").format(gallon * 3.785411784);
            resultView.setText("Result: " + gallonString +" Galons = " + result + " Liters");
        } catch (NumberFormatException e) {
            resultView.setText("WRONG INPUT!!!");
            e.printStackTrace();
        }

    }

    public void convertToGallon(View view){
        String literString = editTextLiter.getText().toString();
        double liter = 0;

        try {
            liter=Double.parseDouble(literString);

            String result = new DecimalFormat("##.##").format(liter * 0.26417205235815);
            resultView.setText("Result: " + literString +" Liters = " + result + " Galons");
        } catch (NumberFormatException e) {
            resultView.setText("WRONG INPUT!!!");
            e.printStackTrace();
        }

    }

    public void showAbout(View view) {
        Intent intent = new Intent(this,DisplayAboutActivity.class);
        String message = resultView.getText().toString();
        intent.putExtra("extra",message);
        startActivity(intent);
    }


}
