package com.mdias.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mdias.aluraviagens.R;
import com.mdias.aluraviagens.model.Pacote;
import com.mdias.aluraviagens.util.DiasUtil;
import com.mdias.aluraviagens.util.MoedaUtil;
import com.mdias.aluraviagens.util.ResourceUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        bindLocal(viewCriada, pacote);
        bindImage(viewCriada, pacote);
        bindDias(viewCriada, pacote);
        bindPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void bindPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);

        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void bindDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void bindImage(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_img);
        Drawable drawableImagemPacote = ResourceUtil.devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void bindLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
