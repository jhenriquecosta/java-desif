/*
 * Decompiled with CFR 0_125.
 */
package br.gov.pbh.desif.dao;

import br.gov.pbh.desif.base.dao.BaseDao;
import br.gov.pbh.desif.model.pojo.PlanoGeralContaComentado;

public interface PgccsPaiFilhoDao
extends BaseDao {
    public boolean identificarPossuiFilhos(PlanoGeralContaComentado var1);
}

