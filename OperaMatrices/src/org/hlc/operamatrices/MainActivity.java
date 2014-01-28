package org.hlc.operamatrices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * CLase principal de la aplicación, se muestra un menú donde el usuario puede
 * inicializar las matrices, para después operar con ellas.
 * 
 * Sólo se podrá operar cuando las matrices estén inicializadas.
 * 
 * @author Pablo Medina Suárez
 * @since 2014
 * 
 */
public class MainActivity extends Activity {
	// Matrices estaticas, podran ser accedidas por el resto de clases:
	static int[][] m1 = new int[3][3];
	static int[][] m2 = new int[3][3];

	private boolean haCreadoM1, haCreadoM2;

	// Botones:
	private int btnCrearM1;
	private int btnSumar;

	// Otros:
	private int queOperacion; // (0 = sumar, 1 = multiplicar)

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnCrearM1 = findViewById(R.id.boton_crear_m1).getId();
		btnSumar = findViewById(R.id.boton_sumar).getId();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_salir:
			salir(null);
			break;
		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1 && resultCode == RESULT_OK) {
			haCreadoM1 = true;
		} else if (requestCode == 2 && resultCode == RESULT_OK) {
			haCreadoM2 = true;
		}
	}

	public void lanzarCrear(View view) {
		if (view.getId() == btnCrearM1) {
			Intent intent = new Intent(this, Matrices.class);
			intent.putExtra("queMatriz", 1);
			startActivityForResult(intent, 1);
		} else {
			Intent intent = new Intent(this, Matrices.class);
			intent.putExtra("queMatriz", 2);
			startActivityForResult(intent, 2);
		}
	}

	public void lanzarOperacion(View view) {
		if (!haCreadoM1 && !haCreadoM2) {
			Toast.makeText(this, R.string.error_falta_matrices,
					Toast.LENGTH_LONG).show();
		} else if (!haCreadoM1) {
			Toast.makeText(this, R.string.error_falta_m1, Toast.LENGTH_LONG)
					.show();
		} else if (!haCreadoM2) {
			Toast.makeText(this, R.string.error_falta_m2, Toast.LENGTH_LONG)
					.show();
		} else {

			if (view.getId() == btnSumar) {
				queOperacion = 0;
			} else {
				queOperacion = 1;
			}

			Intent intent = new Intent(this, Operaciones.class);
			intent.putExtra("operacion", queOperacion);
			startActivity(intent);
		}
	}

	public void salir(View view) {
		finish();
	}

}
