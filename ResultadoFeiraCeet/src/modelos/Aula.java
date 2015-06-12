package modelos;

import java.util.Calendar;

public class Aula {

    private int codAula;
    private int codProfessor;
    private int codTurma;
    private int codDisciplina;
    private int codLab;
    private int codDiaHora;
    private Calendar dataAula;

    public int getCodAula() {
        return codAula;
    }

    public void setCodAula(int codAula) {
        this.codAula = codAula;
    }

    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }

    public int getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(int codTurma) {
        this.codTurma = codTurma;
    }

    public int getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(int codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public int getCodLab() {
        return codLab;
    }

    public void setCodLab(int codLab) {
        this.codLab = codLab;
    }

    public int getCodDiaHora() {
        return codDiaHora;
    }

    public void setCodDiaHora(int codDiaHora) {
        this.codDiaHora = codDiaHora;
    }

    public Calendar getDataAula() {
        return dataAula;
    }

    public void setDataAula(Calendar dataAula) {
        this.dataAula = dataAula;
    }

}
