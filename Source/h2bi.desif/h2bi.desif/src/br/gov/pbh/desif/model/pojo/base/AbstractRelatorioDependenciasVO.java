
package br.gov.pbh.desif.model.pojo.base;

import java.io.Serializable;
import java.util.Date;

public abstract class AbstractRelatorioDependenciasVO
    implements Serializable
{

    private String cnpjInstituicao;
    private String cnpjProprio;
    private String codigoDependencia;
    private String cnpjUnificado;
    private String tipoDependencia;
    private int possuiContabilidade;
    private String nomeMunicipio;
    private String Endereco;
    private Date dataInicioParalizacao;
    private Date dataFimParalizacao;

    public AbstractRelatorioDependenciasVO()
    {
    }

    public AbstractRelatorioDependenciasVO(String cnpjInstituicao, String cnpjProprio, String codigoDependencia, String cnpjUnificado, String tipoDependencia, int possuiContabilidade, String nomeMunicipio, 
            String Endereco, Date dataInicioParalizacao, Date dataFimParalizacao)
    {
        this.cnpjInstituicao = cnpjInstituicao;
        this.cnpjProprio = cnpjProprio;
        this.codigoDependencia = codigoDependencia;
        this.cnpjUnificado = cnpjUnificado;
        this.tipoDependencia = tipoDependencia;
        this.possuiContabilidade = possuiContabilidade;
        this.nomeMunicipio = nomeMunicipio;
        this.Endereco = Endereco;
        this.dataInicioParalizacao = dataInicioParalizacao;
        this.dataFimParalizacao = dataFimParalizacao;
    }

    public String getEndereco()
    {
        return Endereco;
    }

    public void setEndereco(String Endereco)
    {
        this.Endereco = Endereco;
    }

    public String getCnpjInstituicao()
    {
        return cnpjInstituicao;
    }

    public void setCnpjInstituicao(String cnpjInstituicao)
    {
        this.cnpjInstituicao = cnpjInstituicao;
    }

    public String getCnpjProprio()
    {
        return cnpjProprio;
    }

    public void setCnpjProprio(String cnpjProprio)
    {
        this.cnpjProprio = cnpjProprio;
    }

    public String getCnpjUnificado()
    {
        return cnpjUnificado;
    }

    public void setCnpjUnificado(String cnpjUnificado)
    {
        this.cnpjUnificado = cnpjUnificado;
    }

    public String getCodigoDependencia()
    {
        return codigoDependencia;
    }

    public void setCodigoDependencia(String codigoDependencia)
    {
        this.codigoDependencia = codigoDependencia;
    }

    public Date getDataFimParalizacao()
    {
        return dataFimParalizacao;
    }

    public void setDataFimParalizacao(Date dataFimParalizacao)
    {
        this.dataFimParalizacao = dataFimParalizacao;
    }

    public Date getDataInicioParalizacao()
    {
        return dataInicioParalizacao;
    }

    public void setDataInicioParalizacao(Date dataInicioParalizacao)
    {
        this.dataInicioParalizacao = dataInicioParalizacao;
    }

    public String getNomeMunicipio()
    {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio)
    {
        this.nomeMunicipio = nomeMunicipio;
    }

    public int getPossuiContabilidade()
    {
        return possuiContabilidade;
    }

    public void setPossuiContabilidade(int possuiContabilidade)
    {
        this.possuiContabilidade = possuiContabilidade;
    }

    public String getTipoDependencia()
    {
        return tipoDependencia;
    }

    public void setTipoDependencia(String tipoDependencia)
    {
        this.tipoDependencia = tipoDependencia;
    }
}