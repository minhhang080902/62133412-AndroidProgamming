package ntu.MSSV62133412.cau2_chuyendoidonvinhietdo;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText inputTemperature;
    private EditText resultText;
    private Spinner unitFromSpinner, unitToSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTemperature = findViewById(R.id.input_temperature);
        resultText = findViewById(R.id.result_text);
        unitFromSpinner = findViewById(R.id.unit_from_spinner);
        unitToSpinner = findViewById(R.id.unit_to_spinner);
        Button convertButton = findViewById(R.id.convert_button);
        Button clearButton = findViewById(R.id.clearButton);
        Button exitButton = findViewById(R.id.exitButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.temperature_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        unitFromSpinner.setAdapter(adapter);
        unitToSpinner.setAdapter(adapter);

        unitFromSpinner.setSelection(adapter.getPosition("Độ C"));
        unitToSpinner.setSelection(adapter.getPosition("Độ F"));

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputTemperature.setText("");
                resultText.setText("");
            }
        });

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private static double getResult(String fromUnit, String toUnit, double temperature) {
        double result;

        if (fromUnit.equals("Độ C")) {
            if (toUnit.equals("Độ F")) {
                result = temperature * 9 / 5 + 32;
            } else {
                result = temperature + 273.15;
            }
        } else if (fromUnit.equals("Độ F")) {
            if (toUnit.equals("Độ C")) {
                result = (temperature - 32) * 5 / 9;
            } else {
                result = (temperature - 32) * 5 / 9 + 273.15;
            }
        } else {
            if (toUnit.equals("Độ C")) {
                result = temperature - 273.15;
            } else {
                result = (temperature - 273.15) * 9 / 5 + 32;
            }
        }
        return result;
    }

    private void convertTemperature() {
        String fromUnit = unitFromSpinner.getSelectedItem().toString();
        String toUnit = unitToSpinner.getSelectedItem().toString();

        double temperature;

        try {
            temperature = Double.parseDouble(inputTemperature.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập nhiệt độ hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        double result = getResult(fromUnit, toUnit, temperature);

        if (fromUnit.equals(toUnit)) {
            resultText.setText(String.format(Locale.US,"%.2f", temperature));
        } else {
            resultText.setText(String.format("%.2f", result));
        }
    }


}