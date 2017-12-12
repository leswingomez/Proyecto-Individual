package co.com.smartgeeks.appimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtTalla, txtPeso;
    Button botonCalcular;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTalla = (EditText)findViewById(R.id.etTalla);
        txtPeso = (EditText)findViewById(R.id.etPeso);
        botonCalcular = (Button)findViewById(R.id.btnCalcular);
        resultado = (TextView)findViewById(R.id.tvResultado);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double talla = Double.parseDouble(txtTalla.getText().toString());
                double peso = Double.parseDouble(txtPeso.getText().toString());
                double resultadoIMC = peso/(talla*talla);
                resultado.setText("Su Indice de masa corporal es: "+resultadoIMC);

                if (resultadoIMC<18.5){
                    Toast.makeText(getApplicationContext(), "Su peso es menor del normal", Toast.LENGTH_LONG).show();
                }else if(resultadoIMC>=18.5&&resultadoIMC<24.9){
                    Toast.makeText(getApplicationContext(), "Su peso es  normal", Toast.LENGTH_LONG).show();
                }else if (resultadoIMC>=24.9&&resultadoIMC<29.9){
                    Toast.makeText(getApplicationContext(), "Su peso es superior al normal", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Obesidad", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
