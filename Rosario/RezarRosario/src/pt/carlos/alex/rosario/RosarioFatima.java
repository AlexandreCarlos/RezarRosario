/*
 * Copyright (c) 2012. Alexanndre Carlos.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package pt.carlos.alex.rosario;

import android.app.Activity;
import android.content.res.Resources;
import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;
import com.googlecode.androidannotations.api.Scope;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexandre
 * Date: 18-11-2012
 * Time: 21:53
 * Implementação do Rosário de Fátima
 */
@EBean(scope = Scope.Singleton)
public class RosarioFatima implements Rosario {
    private List<String> oracao;
    private List<Integer> coresContas;
    private Misterio tipoMisterioActual = null;
    private int misterioActual = -1;
    private int contasActual = -1;
    private String[] misterios = null;
    private Resources resources;
    private static final Misterio[] MISTERIOS = {null, // Erro ???
            Misterio.GLORIOSO, // Domingo - Mistérios Gloriosos (da Glória)
            Misterio.GOZOSO, // 2ª Feira - Mistérios Gozosos (da Alegria)
            Misterio.DOLOROSO, // 3ª Feira - Mistérios Dolorosos (da Dor)
            Misterio.GLORIOSO, // 4ª Feira - Mistérios Gloriosos (da Glória)
            Misterio.LUMINOSO, // 5ª Feira - Mistérios Luminosos (da Luz)
            Misterio.DOLOROSO, // 6ª Feira - Mistérios Dolorosos (da Dor)
            Misterio.GOZOSO // Sábado - Mistérios Gozosos (da Alegria)
    };

    @RootContext
    Activity activity;


    public RosarioFatima() {
    }

    @AfterInject
    protected void afterCreate() {
        this.resources = this.activity.getResources();
    }

    /**
     * Obter a lista das orações da Dezena do Mistério selecionado para o dia da
     * semana.
     *
     * @param pDiaSemana int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *                   4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @param pMisterio  int com o mistério selecionado (Base de Referência 0)
     * @return String List com as Orações (Dezena) do Mistério selecionado para
     *         o dia da semana
     */
    @Override
    public List<String> obterDezena(int pDiaSemana, int pMisterio) {

        if (isNewMistery(pDiaSemana)) {

            obterOracoesMisterio(pDiaSemana, pMisterio);

        }


        if (misterioActual != pMisterio) {
            if (pMisterio < 5 && misterioActual == 5) {
                obterOracoesMisterio(pDiaSemana, pMisterio);
            } else {
                if (pMisterio == 5) {
                    obterOracoesFinais();
                }
            }
        }

        misterioActual = pMisterio;

        return oracao;

    }

    private void obterOracoesFinais() {
        oracao = new ArrayList<String>();

        for (int i = 1; i < 4; i++) {
            oracao.add(aveMaria());
        }

        oracao.add(salveRainha());
        oracao.add(consagracao());
        oracao.add(oracaoFinal());
    }

    private void obterOracoesMisterio(int pDiaSemana, int pMisterio) {

        oracao = new ArrayList<String>();

        oracao.add(obterTextoMisterio(pDiaSemana, pMisterio));

        oracao.add(paiNosso());

        for (int i = 2; i < 12; i++) {
            oracao.add(aveMaria());
        }

        oracao.add(gloria());
        oracao.add(jaculatoria());
    }

    /**
     * Obter a lista das cores das contas da Dezena do Mistério selecionado
     *
     * @param pMisterio int com o mistério selecionado (Base de Referência 0)
     * @return String List com as cores das contas de cada Oração do Mistério selecionado
     */
    @Override
    public List<Integer> obterContas(int pMisterio) {

        if (contasActual != pMisterio) {
            if (pMisterio < 5 && contasActual == 5) {
                obterContasMisterio();
            } else {
                if (pMisterio == 5) {
                    obterContasOracoesFinais();
                }
            }
        }

        contasActual = pMisterio;

        return coresContas;

    }

    private void obterContasOracoesFinais() {
        coresContas = new ArrayList<Integer>();

        for (int i = 1; i < 4; i++) {
            coresContas.add(resources.getColor(R.color.ics_blue)); // Avé-Maria
        }

        coresContas.add(resources.getColor(R.color.ics_bold_blue)); // Salvé Rainha
        coresContas.add(resources.getColor(R.color.ics_bold_yellow)); // Consagração a Nossa Senhora
        coresContas.add(resources.getColor(R.color.ics_bold_red)); // Oração Final
    }

    private void obterContasMisterio() {
        coresContas = new ArrayList<Integer>();

        coresContas.add(resources.getColor(R.color.ics_yellow)); // Evangelho
        coresContas.add(resources.getColor(R.color.ics_green)); // Pai-Nosso

        for (int i = 2; i < 12; i++) {
            coresContas.add(resources.getColor(R.color.ics_blue)); // Avé-Maria
        }

        coresContas.add(resources.getColor(R.color.ics_bold_yellow)); // Glória
        coresContas.add(resources.getColor(R.color.ics_violet)); // Jaculatória
    }

    /**
     * Obter a designação dos Mistérios do dia da semana.
     *
     * @param pDiaSemana int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *                   4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @return String Array com os Mistérios associados ao dia da semana
     */
    @Override
    public String[] obterDesignacaoMisterios(int pDiaSemana) {

        switch (MISTERIOS[pDiaSemana]) {
            case DOLOROSO:
                return resources.getStringArray(R.array.design_dolorosos);
            case GLORIOSO:
                return resources.getStringArray(R.array.design_gloriosos);
            case GOZOSO:
                return resources.getStringArray(R.array.design_gozosos);
            case LUMINOSO:
                return resources.getStringArray(R.array.design_luminosos);
            default:
                break;
        }

        return null;

    }

    /**
     * Obter a designação do tipo de Mistério do dia da semana.
     *
     * @param pDiaSemana int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *                   4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @return String com a designação do tipo de Mistério do dia da semana
     */
    @Override
    public String obterTipoMisterio(int pDiaSemana) {
        return MISTERIOS[pDiaSemana].tipo();
    }

    /**
     * Obter a identificação do Mistério selecionado para o dia da semana.
     *
     * @param pMisterio int com o mistério selecionado (Base de Referência 0)
     * @return String com a identificação do Mistério selecionado para o dia da
     *         semana
     */
    @Override
    public String obterIdMisterio(int pMisterio) {

        if (pMisterio < 5) {
            return (pMisterio + 1) + "º Mistério";
        }

        return "Oração Final";

    }

    /**
     * Obter o texto bíblico referente ao Mistério selecionado para o dia da
     * semana.
     *
     * @param pDiaSemana int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *                   4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @param pMisterio  int com o mistério selecionado (Base de Referência 0)
     * @return String com o texto bíblico referente ao Mistério selecionado para
     *         o dia da semana
     */
    @Override
    public String obterTextoMisterio(int pDiaSemana, int pMisterio) {

        if (isNewMistery(pDiaSemana)) {

            obterOracoes(pDiaSemana);

            tipoMisterioActual = MISTERIOS[pDiaSemana];

        }

        return obterMisterio(pMisterio);
    }

    private void obterOracoes(final int pDiaSemana) {

        switch (MISTERIOS[pDiaSemana]) {
            case DOLOROSO:
                this.misterios = resources.getStringArray(R.array.dolorosos);
                break;
            case GLORIOSO:
                this.misterios = resources.getStringArray(R.array.gloriosos);
                break;
            case GOZOSO:
                this.misterios = resources.getStringArray(R.array.gozosos);
                break;
            case LUMINOSO:
                this.misterios = resources.getStringArray(R.array.luminosos);
                break;
            default:
                break;
        }

    }

    private boolean isNewMistery(int pDiaSemana) {
        return tipoMisterioActual == null || tipoMisterioActual != MISTERIOS[pDiaSemana];
    }

    private String obterMisterio(final int pMisterio) {
        return this.misterios[pMisterio];
    }

    private String paiNosso() {
        return this.resources.getString(R.string.pai_nosso);
    }

    private String aveMaria() {
        return this.resources.getString(R.string.ave_maria);
    }

    private String gloria() {
        return this.resources.getString(R.string.gloria);
    }

    private String jaculatoria() {
        return this.resources.getString(R.string.jaculatoria);
    }

    private String salveRainha() {
        return this.resources.getString(R.string.salve_rainha);
    }

    private String oracaoFinal() {
        return this.resources.getString(R.string.oracoes_finais);
    }

    private String consagracao() {
//        return this.resources.getString(R.string.jaculatoria);
        return "Consagração a Nossa Senhora";
    }
}
