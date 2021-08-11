/*
 * Decompiled with CFR 0_125.
 * 
 * Could not load the following classes:
 *  br.gov.pbh.des.componentes.utils.DesLookandFeel
 */
package br.gov.pbh.desif.view.telas;

import br.gov.pbh.des.componentes.utils.DesLookandFeel;
import br.gov.pbh.desif.control.Controle;
import br.gov.pbh.desif.dao.PgccsPaiFilhoDao;
import br.gov.pbh.desif.model.pojo.PlanoGeralContaComentado;
import br.gov.pbh.desif.model.registros.RegUtil;
import br.gov.pbh.desif.service.contexto.Contexto;
import br.gov.pbh.desif.view.telas.FrmPrincipal;
import br.gov.pbh.desif.view.util.SwingUtils;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

public class PanFiltroPGCC2
extends JPanel {
    private JButton btnGerarRelatorio;
    private JButton btnVoltar;
    private JComboBox jCBCodTributacao;
    private JComboBox jCBCodigoPGCC;
    private JLabel jLabel1;
    private JLabel jLabel6;
    private JLabel jLabel7;

    public PanFiltroPGCC2() {
        this.initComponents();
        DesLookandFeel.getInstance().formatarJButtons(new JButton[]{this.btnGerarRelatorio, this.btnVoltar});
    }

    public void initValoresComboBoxCodTributacao(List elementosComboBox) {
        this.jCBCodTributacao = this.inicializarComboBox(this.jCBCodTributacao);
        Iterator it = elementosComboBox.iterator();
        while (it.hasNext()) {
            this.jCBCodTributacao.addItem(it.next().toString());
        }
    }

    public void initValoresComboBoxContas(List elementosComboBox) {
        this.jCBCodigoPGCC = this.inicializarComboBox(this.jCBCodigoPGCC);
        PgccsPaiFilhoDao pgccsPFIdDao = (PgccsPaiFilhoDao)Contexto.getObject("pgccsPFIdDao");
        ArrayList listaContasAnalit = new ArrayList();
        for (Object item : elementosComboBox) {
            PlanoGeralContaComentado pgcc =(PlanoGeralContaComentado)item;
            if (pgccsPFIdDao.identificarPossuiFilhos(pgcc)) continue;
            this.jCBCodigoPGCC.addItem(pgcc.getConta());
        }
    }

    public JComboBox inicializarComboBox(JComboBox jCBEntrada) {
        JComboBox jCBZerado = new JComboBox();
        jCBZerado = jCBEntrada;
        jCBZerado.removeAllItems();
        jCBZerado.setModel(new DefaultComboBoxModel<String>(new String[]{" "}));
        jCBZerado.setSelectedIndex(-1);
        jCBZerado.setSelectedItem(null);
        return jCBZerado;
    }

    public void gerarRelatorioPGCC2() {
        String codTributacao = new String();
        String conta = new String();
        if (this.jCBCodTributacao.getSelectedIndex() != -1) {
            codTributacao = this.jCBCodTributacao.getSelectedItem().toString().trim();
        }
        if (this.jCBCodigoPGCC.getSelectedIndex() != -1) {
            conta = this.jCBCodigoPGCC.getSelectedItem().toString().trim();
        }
        Controle controle = (Controle)Contexto.getObject("controle");
        List<PlanoGeralContaComentado> dados = controle.buscaFiltrosDadosGeraisPGCC2(codTributacao, conta);
        PgccsPaiFilhoDao pgccsPFIdDao = (PgccsPaiFilhoDao)Contexto.getObject("pgccsPFIdDao");
        ArrayList<PlanoGeralContaComentado> listaContasAnalit = new ArrayList<PlanoGeralContaComentado>();
        for (PlanoGeralContaComentado pgcc : dados)
        {
            if (pgccsPFIdDao.identificarPossuiFilhos(pgcc)) continue;
            listaContasAnalit.add(pgcc);
        }
        List dadosDecl = controle.buscaFiltrosDadosDeclaracao();
        if (dados.isEmpty()) {
            SwingUtils.msgGenerica(this, "N\u00e3o h\u00e1 dados para gerar o relat\u00f3rio!", "Relat\u00f3rio Vazio");
            return;
        }
        controle.gerarRelatorioPGCC2(listaContasAnalit, dadosDecl);
    }

    private void initComponents() {
        this.btnGerarRelatorio = new JButton();
        this.btnVoltar = new JButton();
        this.jLabel6 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jCBCodigoPGCC = new JComboBox();
        this.jCBCodTributacao = new JComboBox();
        this.jLabel1 = new JLabel();
        this.btnGerarRelatorio.setIcon(new ImageIcon(this.getClass().getResource("/br/gov/pbh/desif/view/icons/bt_gerar_relatorio.png")));
        this.btnGerarRelatorio.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                PanFiltroPGCC2.this.btnGerarRelatorioActionPerformed(evt);
            }
        });
        this.btnVoltar.setIcon(new ImageIcon(this.getClass().getResource("/br/gov/pbh/desif/view/icons/voltar.gif")));
        this.btnVoltar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                PanFiltroPGCC2.this.btnVoltarActionPerformed(evt);
            }
        });
        this.jLabel6.setFont(new Font("Tahoma", 1, 11));
        this.jLabel6.setText("C\u00f3digo Tributa\u00e7\u00e3o DES-IF");
        this.jLabel7.setFont(new Font("Tahoma", 1, 11));
        this.jLabel7.setText("Conta (C\u00f3digo PGCC)");
        this.jCBCodigoPGCC.setModel(new DefaultComboBoxModel<String>(new String[]{" "}));
        this.jCBCodigoPGCC.setName("jCBCodigoPGCC");
        this.jCBCodTributacao.setModel(new DefaultComboBoxModel<String>(new String[]{" "}));
        this.jCBCodTributacao.setName("jCBCodTributacao");
        this.jCBCodTributacao.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                PanFiltroPGCC2.this.jCBCodTributacaoActionPerformed(evt);
            }
        });
        this.jLabel1.setFont(new Font("Tahoma", 1, 14));
        this.jLabel1.setHorizontalAlignment(0);
        this.jLabel1.setText("Contas Anal\u00edticas PGCC");
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(61, 61, 61).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.btnGerarRelatorio, -2, 185, -2).addGap(61, 61, 61).addComponent(this.btnVoltar)).addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addComponent(this.jLabel1, GroupLayout.Alignment.LEADING, -1, -1, 32767).addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup().addComponent(this.jLabel7).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 233, -2)).addComponent(this.jLabel6, GroupLayout.Alignment.LEADING).addComponent(this.jCBCodTributacao, GroupLayout.Alignment.LEADING, 0, -1, 32767).addComponent(this.jCBCodigoPGCC, GroupLayout.Alignment.LEADING, 0, -1, 32767))).addGap(76, 76, 76)));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1, -2, 26, -2).addGap(18, 18, 18).addComponent(this.jLabel6).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jCBCodTributacao, -2, 22, -2).addGap(18, 18, 18).addComponent(this.jLabel7).addGap(3, 3, 3).addComponent(this.jCBCodigoPGCC, -2, -1, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 88, 32767).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.btnGerarRelatorio).addComponent(this.btnVoltar)).addGap(41, 41, 41)));
    }

    private void btnGerarRelatorioActionPerformed(ActionEvent evt) {
        ((FrmPrincipal)Contexto.getObject("frmPrincipal")).setCursorAmpulheta(this.btnGerarRelatorio);
        this.gerarRelatorioPGCC2();
        ((FrmPrincipal)Contexto.getObject("frmPrincipal")).setCursorPadrao(this.btnGerarRelatorio);
    }

    private void btnVoltarActionPerformed(ActionEvent evt) {
        if (RegUtil.exErro) {
            ((FrmPrincipal)Contexto.getObject("frmPrincipal")).abrirTela((JPanel)Contexto.getObject("panErro"));
        } else {
            ((FrmPrincipal)Contexto.getObject("frmPrincipal")).abrirTela((JPanel)Contexto.getObject("panSucesso"));
        }
    }

    private void jCBCodTributacaoActionPerformed(ActionEvent evt) {
    }

}

