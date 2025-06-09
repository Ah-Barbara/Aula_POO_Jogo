import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PedraTesouraPapel extends JFrame {
    
    private TelaPTP tela = new TelaPTP();
    private RegraPTP regra = new RegraPTP();
    
    public PedraTesouraPapel() {
        this.setTitle("Jogo Pedra, Tesoura e Papel");
        this.setSize(400, 200);
        this.add(tela);
        
        tela.btnSelecionar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                acaoSelecionar();
            }
        });
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void acaoSelecionar() {
        if (!tela.opcao1.isSelected() && !tela.opcao2.isSelected() && !tela.opcao3.isSelected()) {
            tela.setStatus("Informe uma opçao antes de continuar...");
            return;
        }
        this.showResultado(regra.processarRegra(tela.opcao1.isSelected(),
            tela.opcao2.isSelected(), tela.opcao3.isSelected()));
        tela.setPlacar(regra.msgPlacar());
        tela.setStatus("Vamos novamente... Selecione uma opcao!");
    }

    private void showResultado(byte resultado) {
        if (resultado == 0) {
            JOptionPane.showMessageDialog(this, "Parabens voce ganhou!");
        } else if (resultado == 1) {
            JOptionPane.showMessageDialog(this, "Sou mais esperto, voce perdeu!");
        } else {
            JOptionPane.showMessageDialog(this, "Empatamos!");
        }
    }
    
    
    public static void main(String [] args) {
        SwingUtilities.invokeLater(PedraTesouraPapel::new);
    }
    
}
