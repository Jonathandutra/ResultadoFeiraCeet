
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Turma;
import modelos.Convidado;
import modelos.Resultado;

/**
 *
 * @author jonathan
 */
public class ConvidadoBD extends ConectarBanco {

    public void cadastrarConvidado(Turma turma, Convidado convidado) {
        try {
            conectarBanco();
            String sql = "insert into convidado (codCurso,nome,cpf,email,escolaridade,telefone) values (?,?,"
                    + "?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, turma.getCodCurso());
            stm.setString(2, convidado.getNome());
            stm.setString(3, convidado.getCpf());
            stm.setString(4, convidado.getEmail());
            stm.setString(5, convidado.getEscolaridade());
            stm.setString(6, convidado.getTelefone());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Convidado: " + convidado.getNome() + "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
        }
    }

    public ArrayList<Convidado> listarConvidadosAlunos() {
        ArrayList<Convidado> listaAlunos = new ArrayList();
        Convidado convidado;

        try {
            conectarBanco();
            String sql = "select * from aluno order by codAluno;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next()) {
                convidado = new Convidado();
                convidado.setNome(lista.getString("nome"));
                convidado.setCpf(lista.getString("cpf"));
                convidado.setEmail(lista.getString("email"));
                convidado.setEscolaridade(lista.getString("escolarida"));
                convidado.setTelefone(lista.getString("telefone"));
                convidado.setCelular(lista.getString("celular"));
                listaAlunos.add(convidado);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
            return listaAlunos;
        }

    }
    
   public ArrayList<Resultado> listarResultado()
   {
        ArrayList<Resultado> listaConvidadosResultados = new ArrayList();
        Resultado resultado;

        try {
            conectarBanco();
            String sql = " select  cu.nome, cu.turno, count(co.cpf) cpf from  feira_de_curso.curso cu,feira_de_curso.convidado co\n" +
" where cu.codCurso = co.codCurso group by cu.nome,cu.turno;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next()) {
                resultado = new Resultado();
                
                resultado.setNomeCurso(lista.getString("nome"));
                resultado.setTurno(lista.getString("turno"));
                resultado.setNumeroConviado(lista.getInt("cpf"));
               
                
                listaConvidadosResultados.add(resultado);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
            return listaConvidadosResultados;
        }

       
   }
}
