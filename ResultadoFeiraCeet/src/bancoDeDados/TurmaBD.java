
package bancoDeDados;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelos.Turma;

public class TurmaBD extends ConectarBanco 
{
    public ArrayList <Turma> listadeTurma()
    {
         ArrayList<Turma> listaTurma= new ArrayList();

        try {
            Turma novoTurma;
            conectarBanco();
            String sql = "select * from feira_de_curso.curso;";
            stm = con.createStatement();
            ResultSet listasTurmaCadastradas = stm.executeQuery(sql);
            while (listasTurmaCadastradas.next()) {
                novoTurma = new Turma();

                novoTurma.setCodCurso(listasTurmaCadastradas.getInt("codCurso"));
                novoTurma.setNomeCurso(listasTurmaCadastradas.getString("nome"));
                novoTurma.setTurno(listasTurmaCadastradas.getString("turno"));

                listaTurma.add(novoTurma);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();

            //    novoPessoa.setEnderecos(listarEnderecoPessoa(novoPessoa));
            return listaTurma;
        }
    }
    
}
