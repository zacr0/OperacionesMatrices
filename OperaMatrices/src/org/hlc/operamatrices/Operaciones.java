package org.hlc.operamatrices;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Clase que se encarga de operar con las dos matrices que el usuario ha
 * inicializado previamente.
 * 
 * En función del botón por el que se accedió a esta actividad, se muestra la
 * suma o la multiplicacion de las matrices, cambiando el título y resultados
 * mostrados.
 * 
 * MEJORAS PREVISTAS: Obtención y modificación de las vistas dinámicamente.
 * 
 * @author Pablo Medina Suarez
 * @since 2014
 * 
 */
public class Operaciones extends Activity {
	private int[][] m1 = MainActivity.m1;
	private int[][] m2 = MainActivity.m2;
	private int[][] resultado = new int[3][3];

	private int queOperacion;

	private TextView titulo;

	private TextView texto111, texto112, texto113, texto121, texto122,
			texto123, texto131, texto132, texto133;
	private TextView texto211, texto212, texto213, texto221, texto222,
			texto223, texto231, texto232, texto233;
	private TextView textor11, textor12, textor13, textor21, textor22,
			textor23, textor31, textor32, textor33;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.operaciones);

		titulo = (TextView) findViewById(R.id.titulo_operaciones);

		// Obtencion de textos para la matriz 1
		texto111 = (TextView) findViewById(R.id.m1_1_1);
		texto112 = (TextView) findViewById(R.id.m1_1_2);
		texto113 = (TextView) findViewById(R.id.m1_1_3);

		texto121 = (TextView) findViewById(R.id.m1_2_1);
		texto122 = (TextView) findViewById(R.id.m1_2_2);
		texto123 = (TextView) findViewById(R.id.m1_2_3);

		texto131 = (TextView) findViewById(R.id.m1_3_1);
		texto132 = (TextView) findViewById(R.id.m1_3_2);
		texto133 = (TextView) findViewById(R.id.m1_3_3);

		// Obtencion de campos para la matriz 2
		texto211 = (TextView) findViewById(R.id.m2_1_1);
		texto212 = (TextView) findViewById(R.id.m2_1_2);
		texto213 = (TextView) findViewById(R.id.m2_1_3);

		texto221 = (TextView) findViewById(R.id.m2_2_1);
		texto222 = (TextView) findViewById(R.id.m2_2_2);
		texto223 = (TextView) findViewById(R.id.m2_2_3);

		texto231 = (TextView) findViewById(R.id.m2_3_1);
		texto232 = (TextView) findViewById(R.id.m2_3_2);
		texto233 = (TextView) findViewById(R.id.m2_3_3);

		// Obtencion de campos para la matriz resultado
		textor11 = (TextView) findViewById(R.id.r_1_1);
		textor12 = (TextView) findViewById(R.id.r_1_2);
		textor13 = (TextView) findViewById(R.id.r_1_3);

		textor21 = (TextView) findViewById(R.id.r_2_1);
		textor22 = (TextView) findViewById(R.id.r_2_2);
		textor23 = (TextView) findViewById(R.id.r_2_3);

		textor31 = (TextView) findViewById(R.id.r_3_1);
		textor32 = (TextView) findViewById(R.id.r_3_2);
		textor33 = (TextView) findViewById(R.id.r_3_3);

		Bundle extras = getIntent().getExtras();
		queOperacion = extras.getInt("operacion");

		// Mostramos las matrices en los TextView
		mostrarMatrizA(null);
		mostrarMatrizB(null);

		// En función de la operación, mostramos un título y un resultado
		// distintos
		if (queOperacion == 0) {
			titulo.setText(R.string.texto_titulo_sumar);
			calcularYMostrarSuma(null);
		} else {
			titulo.setText(R.string.texto_titulo_multiplicar);
			calcularYMostrarMultiplicacion(null);
		}

	}

	public void mostrarMatrizA(View view) {

		texto111.setText("" + m1[0][0]);
		texto112.setText("" + m1[0][1]);
		texto113.setText("" + m1[0][2]);

		texto121.setText("" + m1[1][0]);
		texto122.setText("" + m1[1][1]);
		texto123.setText("" + m1[1][2]);

		texto131.setText("" + m1[2][0]);
		texto132.setText("" + m1[2][1]);
		texto133.setText("" + m1[2][2]);

	}

	public void mostrarMatrizB(View view) {
		texto211.setText("" + m2[0][0]);
		texto212.setText("" + m2[0][1]);
		texto213.setText("" + m2[0][2]);

		texto221.setText("" + m2[1][0]);
		texto222.setText("" + m2[1][1]);
		texto223.setText("" + m2[1][2]);

		texto231.setText("" + m2[2][0]);
		texto232.setText("" + m2[2][1]);
		texto233.setText("" + m2[2][2]);
	}

	public void calcularYMostrarSuma(View view) {
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2.length; j++) {
				resultado[i][j] = m1[i][j] + m2[i][j];
			}
		}

		// Mostramos el resultado en los TextView correspondientes
		textor11.setText("" + resultado[0][0]);
		textor12.setText("" + resultado[0][1]);
		textor13.setText("" + resultado[0][2]);

		textor21.setText("" + resultado[1][0]);
		textor22.setText("" + resultado[1][1]);
		textor23.setText("" + resultado[1][2]);

		textor31.setText("" + resultado[2][0]);
		textor32.setText("" + resultado[2][1]);
		textor33.setText("" + resultado[2][2]);
	}

	public void calcularYMostrarMultiplicacion(View view) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				resultado[i][j] = 0;
				for (int l = 0; l < 3; l++) {
					resultado[i][j] = resultado[i][j] + (m1[i][l] * m2[l][j]);
				}
			}
		}

		// Mostramos el resultado en los TextView correspondientes
		textor11.setText("" + resultado[0][0]);
		textor12.setText("" + resultado[0][1]);
		textor13.setText("" + resultado[0][2]);

		textor21.setText("" + resultado[1][0]);
		textor22.setText("" + resultado[1][1]);
		textor23.setText("" + resultado[1][2]);

		textor31.setText("" + resultado[2][0]);
		textor32.setText("" + resultado[2][1]);
		textor33.setText("" + resultado[2][2]);
	}

	public void salir(View view) {
		finish();
	}
}
