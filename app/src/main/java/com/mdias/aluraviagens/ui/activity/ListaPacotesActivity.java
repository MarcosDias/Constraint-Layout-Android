package com.mdias.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mdias.aluraviagens.R;
import com.mdias.aluraviagens.dao.PacoteDAO;
import com.mdias.aluraviagens.model.Pacote;
import com.mdias.aluraviagens.ui.PacoteActivityConstantes;
import com.mdias.aluraviagens.ui.adapter.ListaPacotesAdapter;

import java.util.List;

import static com.mdias.aluraviagens.ui.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView viewListaPacotes = findViewById(R.id.lista_pacotes_listview);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        viewListaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

        viewListaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Pacote pacoteClicado = pacotes.get(posicao);
                vaiParaResumoPacote(pacoteClicado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(
                ListaPacotesActivity.this, ResumoPacoteActivity.class
        );
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }
}
