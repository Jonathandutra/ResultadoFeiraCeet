
package modelos;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Turma 
{
    private int codCurso;
    private String nomeCurso;
    private String turno;
    private ArrayList<Convidado> convidado= new ArrayList();

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public ArrayList<Convidado> getConvidado() {
        return convidado;
    }
    
    
    public void setConvidado(ArrayList<Convidado> convidado) {
        this.convidado = convidado;
    }
    public void setConvidado(Convidado convidado) {
        this.convidado.add(convidado);
    }

    /**
     * @return the turno
     */
    public String getTurno() {
        return turno;
    }

    /**
     * @param turno the turno to set
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }
    

    
    
    
}
