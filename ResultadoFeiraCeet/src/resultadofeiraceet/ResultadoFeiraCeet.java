
package resultadofeiraceet;

import arquivo.ManipularArquivo;
import bancoDeDados.ConectarBanco;
import interfaces.CaminhoServidor;
import interfaces.TelaClassificacao;


public class ResultadoFeiraCeet {

      public static void main(String args[]) {
  
           ConectarBanco conexaoBanco = new ConectarBanco();
        ManipularArquivo arquivo = new ManipularArquivo();
        arquivo.moverAquivo();
        String caminho = "";
        
        
        

        if (arquivo.TestarArquivo("CaminhoServidor.txt")) 
        {
            caminho = arquivo.lerArquivo();
               
            conexaoBanco.criarBase(caminho);
            conexaoBanco.criarTabelas(caminho);
            }else
        {
            
            CaminhoServidor tela = new CaminhoServidor(null, true);
            tela.setVisible(true);
            caminho = tela.CaminhoServidor();
            arquivo.gravarArquivoServidor(caminho);
            
            conexaoBanco.criarBase();
            conexaoBanco.criarTabelas();
         
        }

          
          
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaClassificacao dialog = new TelaClassificacao(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
  
                  });
                dialog.setVisible(true);
            }
        });
    }
    
}
