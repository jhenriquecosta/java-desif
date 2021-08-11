/*
 * Decompiled with CFR 0_125.
 */
package br.gov.pbh.desif.model.pojo.base;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractGuiaEstaticaVO
implements Serializable {
    private String nomeInstituicao;
    private Date dataInicioCompetencia;
    private String cnpjInstituicao;
    private Short opcaoInscricaoMunicipal;
    private String codigoDependencia;
    private Short tipoDeclaracao;

    public AbstractGuiaEstaticaVO() {
    }

    public AbstractGuiaEstaticaVO(String nomeInstituicao, Date dataInicioCompetencia, String cnpjInstituicao, Short opcaoInscricaoMunicipal, String codigoDependencia, Short tipoDeclaracao) {
        this.nomeInstituicao = nomeInstituicao;
        this.dataInicioCompetencia = dataInicioCompetencia;
        this.cnpjInstituicao = cnpjInstituicao;
        this.opcaoInscricaoMunicipal = opcaoInscricaoMunicipal;
        this.codigoDependencia = codigoDependencia;
        this.tipoDeclaracao = tipoDeclaracao;
    }

    public String getCnpjInstituicao() {
        return this.cnpjInstituicao;
    }

    public void setCnpjInstituicao(String cnpjInstituicao) {
        this.cnpjInstituicao = cnpjInstituicao;
    }

    public String getCodigoDependencia() {
        return this.codigoDependencia;
    }

    public void setCodigoDependencia(String codigoDependencia) {
        this.codigoDependencia = codigoDependencia;
    }

    public Date getDataInicioCompetencia() {
        return this.dataInicioCompetencia;
    }

    public void setDataInicioCompetencia(Date dataInicioCompetencia) {
        this.dataInicioCompetencia = dataInicioCompetencia;
    }

    public String getNomeInstituicao() {
        return this.nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public Short getOpcaoInscricaoMunicipal() {
        return this.opcaoInscricaoMunicipal;
    }

    public void setOpcaoInscricaoMunicipal(Short opcaoInscricaoMunicipal) {
        this.opcaoInscricaoMunicipal = opcaoInscricaoMunicipal;
    }

    public Short getTipoDeclaracao() {
        return this.tipoDeclaracao;
    }

    public void setTipoDeclaracao(Short tipoDeclaracao) {
        this.tipoDeclaracao = tipoDeclaracao;
    }
}

