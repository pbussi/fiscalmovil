package com.example.pablo.miaplicacion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.CheckBox;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public void aprieta(View v) {
        setContentView(R.layout.activity_selecciona_mesa);
    }

    public void cierra(View v) {
        Log.e("cierrra","cierra");
        setContentView(R.layout.activity_principal);
    }

    public void verlista(View v) {
        Log.e("verlista","verlista");
        setContentView(R.layout.activity_listas);
    }

    public void cuenta(View v) {
        setContentView(R.layout.activity_listas);
        TableLayout ll = (TableLayout) findViewById(R.id.tlGridTable);
        String ret = "";
        try {
            File file = new File(((Context) this).getExternalFilesDir(null), "mesa.json");
            StringBuilder text = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();
            TableRow row1 = new TableRow(this);

            TextView titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.parseColor("#4183d7"));
            titulo.setText("Lista");
            row1.addView(titulo);

            titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.parseColor("#4183d7"));
            titulo.setText(" Gob ");
            row1.addView(titulo);

            titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.parseColor("#4183d7"));
            titulo.setText(" Dip ");
            row1.addView(titulo);

            titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.parseColor("#4183d7"));
            titulo.setText(" Sen ");
            row1.addView(titulo);

            titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.parseColor("#4183d7"));
            titulo.setText(" Int ");
            row1.addView(titulo);

            titulo = new TextView(this);
            titulo.setTextColor(Color.WHITE);
            titulo.setBackgroundColor(Color.MAGENTA);
            titulo.setText(" C/M ");
            row1.addView(titulo);

            ll.addView(row1, 0);

            JSONObject jObj = new JSONObject(text.toString());
            JSONObject renglones = jObj.getJSONObject("renglones");
            Iterator<String> iter = renglones.keys();
            int i = 1;
            while (iter.hasNext()) {
                String key = iter.next();
                try {
                    Object value = renglones.get(key);
                    JSONObject partido = new JSONObject(value.toString());
                    TableRow row = new TableRow(this);
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    TextView lista = new TextView(this);
                    lista.setText(partido.get("nombre").toString());
                    lista.setTextColor(Color.BLACK);
                    row.addView(lista);

                    TextView gobernador = new TextView(this);

                    JSONObject categorias = partido.getJSONObject("categorias");
                    Iterator<String> cat_iter = categorias.keys();
                    Boolean bandera=false;
                    while (cat_iter.hasNext()) {
                        String cat = cat_iter.next();
                        Log.e("zz",cat);
                        if (cat.equals("Gobernador"))
                            bandera=true;
                    }
                    if (bandera)
                        gobernador.setText("0");
                    else
                        gobernador.setBackgroundColor(Color.BLACK);
                    row.addView(gobernador);



                    TextView diputado = new TextView(this);

                    cat_iter = categorias.keys();
                    bandera=false;
                    while (cat_iter.hasNext()) {
                        String cat = cat_iter.next();
                        if (cat.equals("Diputado"))
                            bandera=true;
                    }
                    if (bandera)
                        diputado.setText("0");
                    else
                        diputado.setBackgroundColor(Color.BLACK);
                    row.addView(diputado);


                    TextView senador = new TextView(this);
                    cat_iter = categorias.keys();
                    bandera=false;
                    while (cat_iter.hasNext()) {
                        String cat = cat_iter.next();
                        if (cat.equals("Senador"))
                            bandera=true;
                    }
                    if (bandera)
                        senador.setText("0");
                    else
                        senador.setBackgroundColor(Color.BLACK);
                    row.addView(senador);


                    TextView intendente = new TextView(this);
                    cat_iter = categorias.keys();
                    bandera=false;
                    while (cat_iter.hasNext()) {
                        String cat = cat_iter.next();
                        if (cat.equals("Intendente"))
                            bandera=true;
                    }
                    if (bandera)
                        intendente.setText("0");
                    else
                        intendente.setBackgroundColor(Color.BLACK);
                    row.addView(intendente);


                    TextView concejal = new TextView(this);
                    cat_iter = categorias.keys();
                    bandera=false;
                    while (cat_iter.hasNext()) {
                        String cat = cat_iter.next();
                        if (cat.equals("Concejal"))
                            bandera=true;
                    }
                    if (bandera)
                        concejal.setText("0");
                    else
                        concejal.setBackgroundColor(Color.BLACK);
                    row.addView(concejal);

                    ll.addView(row, i);


                } catch (JSONException e) {
                    Log.e("error", "error");
                }
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (JSONException e) {
            Log.e("login activity", "Can not parse file: " + e.toString());
        }catch (Exception e) {
            Log.e("login activity", "Error: " + e.toString());
        }



       /* Intent intent = new Intent(
                "com.google.zxing.client.android.SCAN");
        //intent.putExtra("SCAN_MODE", "BARCODE_MODE");
        startActivityForResult(intent, 0);

        for (int i = 0; i < 2; i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            TextView lista = new TextView(this);
            lista.setText("10");
            row.addView(lista);
            ll.addView(row, i);
        }
        */
    }


    public void graba(View v) {
        String outdata = "";
        try {
            URL url_g = new URL("http://192.168.0.104/webservices/buscamesa.json.php?mesa=1&usuario=pablo&extranjero=0");
            URLConnection ukr = url_g.openConnection();

            BufferedReader in = new BufferedReader(new InputStreamReader(ukr.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                outdata += inputLine;
            in.close();

            outdata = outdata.replace("\\", "");
            outdata = outdata.replace("\"{", "{");
            outdata = outdata.replace("}\",", "},");
            outdata = outdata.replace("}\"", "}");

            File traceFile = new File(((Context) this).getExternalFilesDir(null), "mesa.json");
            FileWriter out = new FileWriter(traceFile);
            out.write(outdata);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {



            }
        }
    }
}
