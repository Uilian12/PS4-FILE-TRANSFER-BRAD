
package com.ps4filetransfer;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.*;
import android.view.View;
import android.graphics.Color;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 40, 25, 25);
        layout.setBackgroundColor(Color.rgb(20, 20, 30));

        TextView titulo = new TextView(this);
        titulo.setText("PS4 FILE TRANSFER BRAD");
        titulo.setTextSize(24);
        titulo.setTextColor(Color.WHITE);
        layout.addView(titulo);

        EditText ip = new EditText(this);
        ip.setHint("IP do PS4");
        ip.setSingleLine(true);
        layout.addView(ip);

        EditText porta = new EditText(this);
        porta.setHint("Porta FTP (ex: 2121)");
        porta.setInputType(2);
        porta.setText("2121");
        layout.addView(porta);

        Button conectar = new Button(this);
        conectar.setText("CONECTAR AO PS4");
        layout.addView(conectar);

        TextView status = new TextView(this);
        status.setTextColor(Color.GREEN);
        status.setText("Aguardando conexão...");
        layout.addView(status);

        conectar.setOnClickListener(v -> {
            String endereco = ip.getText().toString().trim();
            if (endereco.isEmpty()) {
                status.setText("Digite o IP do PS4");
            } else {
                status.setText("Endereço FTP: ftp://" + endereco + ":" + porta.getText());
            }
        });

        setContentView(layout);
    }
}
