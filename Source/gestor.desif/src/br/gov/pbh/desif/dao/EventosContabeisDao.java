/*
 * Decompiled with CFR 0_125.
 */
package br.gov.pbh.desif.dao;

import br.gov.pbh.desif.base.dao.BaseDao;
import java.util.List;

public interface EventosContabeisDao
extends BaseDao {
    public List findField(String var1, String var2);

    public boolean verificaExistenciaCodigoEvento(int var1);
}

