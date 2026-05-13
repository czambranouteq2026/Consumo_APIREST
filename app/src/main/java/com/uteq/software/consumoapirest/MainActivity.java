package com.uteq.software.consumoapirest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class MainActivity extends AppCompatActivity {

    private TextView txtAlumnos;

    private final String url = BuildConfig.API_URL;
    private final String apiKey = BuildConfig.API_KEY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtAlumnos = findViewById(R.id.txtAlumnos);

        cargarAlumnos();
    }

    private void cargarAlumnos() {

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                response -> {
                    try {
                        StringBuilder texto = new StringBuilder();
                        JSONArray data = response.getJSONArray("data");
                        for (int i = 0; i < data.length(); i++) {
                            JSONObject alumno = data.getJSONObject(i);
                            JSONObject datosalumno = alumno.getJSONObject("data");
                            texto.append((i + 1) + ".- " + datosalumno.optString("nombres", "") + "\n");
                            texto.append("Paralelo: " +datosalumno.optString("paralelo", "") + "\n");
                            texto.append("Periodo: " +datosalumno.optString("periodoacademico", "") + "\n");
                            texto.append("Email: " +datosalumno.optString("correo", "") + "\n");
                            texto.append("Periodo: " +datosalumno.optString("periodoacademico", "") + "\n\n");
                        }
                        txtAlumnos.setText(texto.toString());

                    } catch (Exception e) {
                        txtAlumnos.setText(
                                "Error procesando datos:\n" + e.getMessage()
                        );
                    }
                },

                error -> txtAlumnos.setText("Error API:\n" + error.getMessage()
                )

        ) {

            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> headers = new HashMap<>();
                headers.put("x-api-key", apiKey);
                return headers;
            }
        };

        queue.add(request);
    }
}