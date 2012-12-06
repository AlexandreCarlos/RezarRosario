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

/**
 * TIPOS DE MISTÉRIOS
 */
public enum Misterio {
    GLORIOSO("Mistérios Gloriosos"),
    DOLOROSO("Mistérios Dolorosos"),
    GOZOSO("Mistérios Gozosos"),
    LUMINOSO("Mistérios Luminosos");

    private final String tipo;

    Misterio (String tipo) {
        this.tipo = tipo;
    }

    public String tipo() {return tipo;}
}
