public class RegraPTP {
    
    private int [] escolhaUsuario = {0, 0, 0};
    private int totGanho, totPerdido, totEmpatado;
    
    public byte processarRegra(boolean opc1, boolean opc2, boolean opc3) {
        byte escolhaComp = this.compEscolher();
        byte escolhaUsu;
        if (opc1) {
            this.addPedra();
            escolhaUsu = 0;
        } else if (opc2) {
            this.addTesoura();
            escolhaUsu = 1;
        } else {
            this.addPapel();
            escolhaUsu = 2;
        }
        
        byte resultado = this.julgar(escolhaComp, escolhaUsu);
        this.setVencedor(resultado);
        
        return resultado;
    }
    
    public String msgPlacar() {
        return "PLACAR -- Ganhou: " + totGanho + " Perdi: " + totPerdido + 
            " Empatou: " + totEmpatado;
    }
    
    private byte compEscolher() {
        byte escolha = (byte)(Math.random()*3);
        
        int usuario = 0;
        for (int i = 0; i < escolhaUsuario.length; i++){
           if (escolhaUsuario[i] > escolhaUsuario[usuario]) {
               usuario = i;
           }
        }
        
        // Usuario escolhe PEDRA: Retorno PAPEL ou Escolha
        if (usuario == 0) {
            return ((byte)(Math.random()*2)) == 1?2:escolha;
        }
        // Usuario escolhe TESOURA: Retorno PEDRA ou Escolha
        if (usuario == 1) {
            return ((byte)(Math.random()*2)) == 1?0:escolha;
        }
        // Usuario escolhe PAPEL: Retorno TESOURA ou Escolha
        return ((byte)(Math.random()*2)) == 1?1:escolha;
    }
    
    private byte julgar(byte comp, byte usuario) {
        if (comp == 0) { // PEDRA
            if (usuario == 0) return 2; // Empatou
            else if (usuario == 1) return 1; // Perdeu
            else return 0; // Ganhou
        } else if (comp == 1) { // TESOURA
            if (usuario == 0) return 0; // Ganhou
            else if (usuario == 1) return 2; // Empatou
            else return 1; // Perdeu
        } else { // PAPEL
            if (usuario == 0) return 1; // Perdeu
            else if (usuario == 1) return 0; // Ganhei
            else return 2; // Empatou
        }
    }

    private void setVencedor(byte quem) {
        if (quem == 0) {
            totGanho += 1;
        } else if (quem == 1) {
            totPerdido += 1;
        } else {
            totEmpatado += 1;
        }
    }
    
    
    private void addPedra() {
        escolhaUsuario[0] += 1;
    }
    private void addTesoura() {
        escolhaUsuario[1] += 1;
    }
    private void addPapel() {
        escolhaUsuario[2] += 1;
    }

}
