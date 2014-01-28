package org.hlc.operamatrices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Clase utilizada para inicializar cada una de las matrices, en función del
 * botón que la llamara en la actividad principal.
 * 
 * La información mostrada al usuario y el contenido almacenado varía en función
 * de la matriz creada.
 * 
 * MEJORAS PREVISTAS: Obtención y modificación de las vistas dinámicamente.
 * 
 * @author Pablo Medina Suárez
 * @since 2014
 * 
 */
public class Matrices extends Activity {
	private int[][] matriz = new int[3][3];
	private int queMatriz;

	private TextView titulo;
	private EditText campo1, campo2, campo3, campo4, campo5, campo6, campo7,
			campo8, campo9;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.crear_matriz);

		titulo = (TextView) findViewById(R.id.titulo_crear_matriz);

		campo1 = (EditText) findViewById(R.id.campo_1_1);
		campo2 = (EditText) findViewById(R.id.campo_1_2);
		campo3 = (EditText) findViewById(R.id.campo_1_3);

		campo4 = (EditText) findViewById(R.id.campo_2_1);
		campo5 = (EditText) findViewById(R.id.campo_2_2);
		campo6 = (EditText) findViewById(R.id.campo_2_3);

		campo7 = (EditText) findViewById(R.id.campo_3_1);
		campo8 = (EditText) findViewById(R.id.campo_3_2);
		campo9 = (EditText) findViewById(R.id.campo_3_3);

		Bundle extras = getIntent().getExtras();
		queMatriz = extras.getInt("queMatriz");

		if (queMatriz == 1) {
			matriz = MainActivity.m1;
			titulo.setText(R.string.texto_titulo_crear_m1);
		} else {
			matriz = MainActivity.m2;
			titulo.setText(R.string.texto_titulo_crear_m2);
		}

	}

	public void crearYSalir(View view) {
		try {
			matriz[0][0] = Integer.valueOf(campo1.getText().toString());
			matriz[0][1] = Integer.valueOf(campo2.getText().toString());
			matriz[0][2] = Integer.valueOf(campo3.getText().toString());

			matriz[1][0] = Integer.valueOf(campo4.getText().toString());
			matriz[1][1] = Integer.valueOf(campo5.getText().toString());
			matriz[1][2] = Integer.valueOf(campo6.getText().toString());

			matriz[2][0] = Integer.valueOf(campo7.getText().toString());
			matriz[2][1] = Integer.valueOf(campo8.getText().toString());
			matriz[2][2] = Integer.valueOf(campo9.getText().toString());
			
			Intent intent = new Intent();
			intent.putExtra("matriz", matriz);
			setResult(RESULT_OK, intent);

			finish();
		} catch (NumberFormatException e) {
			Toast.makeText(this, R.string.error_falta_numero, Toast.LENGTH_LONG).show();
		}
		
		
	}
}
