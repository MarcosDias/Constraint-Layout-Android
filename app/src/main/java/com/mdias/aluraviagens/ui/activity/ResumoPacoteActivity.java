package com.mdias.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdias.aluraviagens.R;
import com.mdias.aluraviagens.model.Pacote;
import com.mdias.aluraviagens.util.DataUtil;
import com.mdias.aluraviagens.util.DiasUtil;
import com.mdias.aluraviagens.util.MoedaUtil;
import com.mdias.aluraviagens.util.ResourceUtil;

import java.math.BigDecimal;
public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITLE = "Resumo do pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITLE);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp",
                2, new BigDecimal("243.99"));

        mostraLocal(pacoteSaoPaulo);

        mostraImagem(pacoteSaoPaulo);

        mostraDias(pacoteSaoPaulo);

        mostraPreco(pacoteSaoPaulo);

        mostraData(pacoteSaoPaulo);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaDaViagem = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatadaDaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil
                .devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
