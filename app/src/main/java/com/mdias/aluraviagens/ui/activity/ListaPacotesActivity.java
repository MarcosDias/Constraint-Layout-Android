package com.mdias.aluraviagens.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.mdias.aluraviagens.R;
import com.mdias.aluraviagens.dao.PacoteDAO;
import com.mdias.aluraviagens.model.Pacote;
import com.mdias.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        ListView viewListaPacotes = findViewById(R.id.lista_pacotes_listview);

        List<Pacote> pacotes = new PacoteDAO().lista();

        viewListaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
