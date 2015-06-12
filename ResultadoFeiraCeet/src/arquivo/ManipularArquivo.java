package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    
 File servidor = new File("CaminhoServidor.txt");
 File arquivoGeral = new File("d:\\banco.txt");
// metodo usado para gravar Texto no arquivo 
 

    public void moverAquivo()
    {
        try
        {
            File arqIn = new File("banco.txt");  
            File arqOut = new File("d:\\banco.txt");  
            if(arqIn.renameTo(arqOut))
                   System.out.println("SUCESSO");
            else
                   System.err.println("FALHOU");
        }catch(Exception e)
        {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public boolean TestarArquivo(String nome)
    {
        File arq = new File (nome);
        if(arq.exists())
        {
          return true;  
        }else
        {
             return false; 
        }
      
    }


   public void gravarArquivoServidor(String tex) {
          
        try {
            
            if (servidor.exists()) {
                servidor.createNewFile();
            }
            
            PrintWriter guardar = new PrintWriter(servidor);

            guardar.println(tex);
            guardar.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  public String lerArquivo() {
        String texto = "";

        try {
          
            Scanner leitor = new Scanner(new FileReader(servidor)).useDelimiter("\\n");
         
            while (leitor.hasNext()) {
                texto += leitor.next();
            }
      
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            return texto;
        }
    }


}
