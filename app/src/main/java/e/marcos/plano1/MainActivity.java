package e.marcos.plano1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editPrecoCombustivel;
    private EditText editUltimoKm;
    private EditText editAtualKm;
    private EditText editValor;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoCombustivel = findViewById(R.id.editPrecoCombustivel);
        editUltimoKm = findViewById(R.id.editUltimoKm);
        editAtualKm = findViewById(R.id.editAtualKm);
        editValor = findViewById(R.id.editValor);
        textResultado = findViewById(R.id.textResultado);

    }
    public void calculo(View view){
        String precoCombustivel = editPrecoCombustivel.getText().toString();
        String ultimoKm = editUltimoKm.getText().toString();
        String atualKm = editAtualKm.getText().toString();
        String valor = editValor.getText().toString();

        boolean camposValidos = this.validarCampos(precoCombustivel,ultimoKm,atualKm,valor);

        if (camposValidos){
            this.calculoMelhor(precoCombustivel,ultimoKm,atualKm,valor);

        }else {
            textResultado.setText("preencha os campos acima");
        }


    }
    public void calculoMelhor(String pCombustivel, String ultimoK, String atualK, String v ){

        Double precoCombustivel = Double.parseDouble(pCombustivel);
        Double ultimoKm = Double.parseDouble(ultimoK);
        Double atualKm = Double.parseDouble(atualK);
        Double valor = Double.parseDouble(v);

        double resultado = (valor/precoCombustivel);
        double litros = (atualKm - ultimoKm )/resultado;
        if ( litros == litros){
            textResultado.setText("Média " + litros + " Km/l");
        }

    }



    public boolean validarCampos(String pCombustivel, String ultimoK, String atualK, String v ){
        boolean camposValidos = true;

        if (pCombustivel == null || pCombustivel.equals("")){
            camposValidos = false;
        }if (ultimoK == null || ultimoK.equals("")){
            camposValidos = false;
        }if (atualK == null || atualK.equals("")){
            camposValidos = false;
        }if (v == null || v.equals("")){
            camposValidos = false;
        }
     return camposValidos;
    }
}
