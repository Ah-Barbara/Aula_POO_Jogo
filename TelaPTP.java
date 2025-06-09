import javax.swing.*;
import java.awt.*;

public class TelaPTP extends JPanel {

    private JLabel lblPlacar, lblStatus;
    public JRadioButton opcao1, opcao2, opcao3;
    public JButton btnSelecionar;
    
    public TelaPTP() {
        this.setLayout(new BorderLayout());
        
        // 1 Parte
        JPanel pnlPlacar = new JPanel();
        lblPlacar = new JLabel("PLACAR");
        pnlPlacar.add(lblPlacar);
        this.add(pnlPlacar, BorderLayout.NORTH);
        
        // Centro
        JPanel pnlOpcoes = new JPanel();
        pnlOpcoes.setLayout(new GridLayout(5,1));
        
        opcao1 = new JRadioButton("Pedra");
        opcao2 = new JRadioButton("Tesoura");
        opcao3 = new JRadioButton("Papel");

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(opcao1);
        grupo.add(opcao2);
        grupo.add(opcao3);

        JPanel pnlBotao = new JPanel();
        btnSelecionar = new JButton("Selecionar");
        pnlBotao.add(btnSelecionar);
        
        pnlOpcoes.add(new JLabel("Faça sua escolha:"));
        pnlOpcoes.add(opcao1);
        pnlOpcoes.add(opcao2);
        pnlOpcoes.add(opcao3);
        pnlOpcoes.add(pnlBotao);
        
        this.add(pnlOpcoes, BorderLayout.CENTER);
        
        // Barra de Status
        JPanel pnlStatus = new JPanel();
        lblStatus = new JLabel("Escolha uma opçao...");
        pnlStatus.add(lblStatus);
        this.add(pnlStatus, BorderLayout.SOUTH);
    }

    public void setPlacar(String msg) {
        this.lblPlacar.setText(msg);
    }
    
    public void setStatus(String msg) {
        this.lblStatus.setText(msg);
    }
}
