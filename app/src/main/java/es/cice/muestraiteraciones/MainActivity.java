package es.cice.muestraiteraciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTV;
    private int iter;
    Button btnCancelar, btnLanzar;
    AsyncTaskContador tareaContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tareaContador=new AsyncTaskContador();

        infoTV=(TextView) findViewById(R.id.InfoTV);
        btnCancelar=(Button) findViewById(R.id.btnCancelar);
        btnLanzar=(Button) findViewById(R.id.btnLanzar);
        //le pasa la referencia del textview a la clase del Asyntask
        tareaContador.setInfoTV(infoTV);

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });
        btnLanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzar();
            }
        });
    }
    public void lanzar(){
        tareaContador.execute(100);

    }
    public void cancelar(){
        tareaContador.cancel(true);
    }

}
