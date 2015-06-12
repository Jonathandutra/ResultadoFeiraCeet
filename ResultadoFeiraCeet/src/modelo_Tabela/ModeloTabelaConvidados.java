
package modelo_Tabela;

import java.util.ArrayList;
import modelos.Convidado;
import modelos.Resultado;


public class ModeloTabelaConvidados extends  javax.swing.table.AbstractTableModel
{
    ArrayList<Resultado> listaResultado = new ArrayList(); 
    Resultado resultado;

    @Override
    public int getRowCount() {
       return this.listaResultado.size();
    }

    @Override
    public int getColumnCount() {
       return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
            resultado = listaResultado.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0: return resultado.getNomeCurso();
            case 1: return resultado.getTurno();
            case 2: return resultado.getNumeroConviado();
            default: return null;
        }
    }
    
   @Override
    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0: return "Turma";
            case 1: return "Turno";
            case 2: return "Numero de Convidado";
            default: return null;
        }
    }
    
      public void inserirListaResultado(ArrayList<Resultado> listaResultado)
    {
        this.listaResultado = listaResultado;
    }
    
    public ArrayList<Resultado> retornarListaResultado()
    {
        return this.listaResultado;
    }
    
}
