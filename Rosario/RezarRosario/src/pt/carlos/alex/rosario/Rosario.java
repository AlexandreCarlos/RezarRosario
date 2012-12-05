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

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alexandre
 * Date: 18-11-2012
 * Time: 21:22
 *
 * Interface do Rosário a rezar
 */
public interface Rosario {
    /**
     * Obter a lista das orações da Dezena do Mistério selecionado para o dia da
     * semana.
     *
     * @param pDiaSemana
     *            int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *            4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @param pMisterio
     *            int com o mistério selecionado (Base de Referência 0)
     * @return String List com as Orações (Dezena) do Mistério selecionado para
     *         o dia da semana
     */
    public List<String> obterDezena  (final int pDiaSemana, final int pMisterio);

    /**
     * Obter a lista das cores das contas da Dezena do Mistério selecionado
     *
     * @param pMisterio
     *            int com o mistério selecionado (Base de Referência 0)
     * @return String List com as cores das contas de cada Oração do Mistério selecionado
     *
     */
    public List<Integer> obterContas (final int pMisterio);

    /**
     * Obter a designação dos Mistérios do dia da semana.
     *
     * @param pDiaSemana
     *            int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *            4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @return String Array com os Mistérios associados ao dia da semana
     */
    public String[] obterDesignacaoMisterios (final int  pDiaSemana);

    /**
     * Obter a designação do tipo de Mistério do dia da semana.
     *
     * @param pDiaSemana
     *            int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *            4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @return String com a designação do tipo de Mistério do dia da semana
     */
    public String obterTipoMisterio (final int pDiaSemana);

    /**
     * Obter a identificação do Mistério selecionado para o dia da semana.
     *
     *
     * @param pMisterio
     *            int com o mistério selecionado (Base de Referência 0)
     * @return String com a identificação do Mistério selecionado para o dia da
     *         semana
     */
    public String obterIdMisterio (final int pMisterio);

    /**
     * Obter o texto bíblico referente ao Mistério selecionado para o dia da
     * semana.
     *
     * @param pDiaSemana
     *            int com o dia da semana 1 - Domingo 2 - 2ª Feira 3 - 3ª Feira
     *            4 - 4ª Feira 5 - 5ª Feira 6 - 6ª Feira 7 - Sábado
     * @param pMisterio
     *            int com o mistério selecionado (Base de Referência 0)
     * @return String com o texto bíblico referente ao Mistério selecionado para
     *         o dia da semana
     */
    public String obterTextoMisterio (final int pDiaSemana, final int pMisterio);
}
