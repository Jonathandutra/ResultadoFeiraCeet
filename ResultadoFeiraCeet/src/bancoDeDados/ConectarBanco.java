package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class ConectarBanco {

    String driver = "com.mysql.jdbc.Driver";
    String caminho = "jdbc:mysql://localhost:3306/feira_de_curso";
    String usuario = "root";
    String senha = "root";
    Connection con;
    Statement stm;

    public void conectarBanco() {
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     public void conectarBanco(String cami) {
        try {
            con = DriverManager.getConnection("jdbc:mysql://"+cami+":3306/feira_de_curso", usuario, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void desconetarBanco() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void criarBase(String cami)
    {
        try
        {
         con = DriverManager.getConnection("jdbc:mysql://"+cami+":3306/feira_de_curso", "admin", "admin");
            
            System.out.println("Conexao criada "+con);
            
            String sql = "create database if not exists feira_de_curso;";
            String sql2=" CREATE USER 'aluno'@'localhost' IDENTIFIED BY 'aluno';";
            String sql3= "GRANT ALL PRIVILEGES ON * . * TO 'aluno'@'localhost';";
            
            stm = con.createStatement();
            
            stm.execute(sql);
            stm.execute(sql2);
            stm.execute(sql3);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }
    
     public void criarBase()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",  "admin", "admin");
            
            System.out.println("Conexao criada "+con);
            
            String sql = "create database if not exists feira_de_curso;";
           String sql2=" CREATE USER 'aluno'@'localhost' IDENTIFIED BY 'aluno';";
            String sql3= "GRANT ALL PRIVILEGES ON * . * TO 'aluno'@'localhost';";
            
            stm = con.createStatement();
            
            stm.execute(sql);
            stm.execute(sql2);
            stm.execute(sql3);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }
    
    public void criarTabelas(String cami)
    {
        try
        {
         con = DriverManager.getConnection("jdbc:mysql://"+cami+":3306/feira_de_curso", usuario, senha);
            
            System.out.println("Conexao criada "+con);
            
            String sql ="create table if not exists feira_de_curso.curso (" +
                        "codCurso int unsigned not null auto_increment," +
                        "nome varchar(80),"
                    + " turno varchar(15)," +
                        "primary key (codCurso)" +
                        ");" ;
                
            String sql2 =  "create table if not exists feira_de_curso.convidado (\n" +
                        "codCurso int unsigned not null,\n" +
                        "nome varchar(80) not null,\n" +
                        "cpf varchar (15) not null,\n" +
                        "email varchar(150),\n" +
                        "escolaridade varchar(50),\n" +
                        "telefone varchar(15),\n"
                    + "celular varchar(16)," +
                        "foreign key (codCurso) references feira_de_curso.curso (codCurso),\n" +
                        "primary key (cpf)\n" +
                        ");";
            String sql3= "load data local infile 'd:\\\\banco.txt' into table feira_de_curso.curso;";
            stm = con.createStatement();
            
            stm.execute(sql);
            stm.execute(sql2);
            stm.executeUpdate(sql3);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }
       public void criarTabelas()
    {
        try
        {
            con = DriverManager.getConnection(caminho, usuario, senha);
            
            System.out.println("Conexao criada "+con);
            
            String sql =  "create table if not exists feira_de_curso.curso (" +
                        "codCurso int unsigned not null auto_increment," +
                        "nome varchar(80),"
                    + " turno varchar(15)," +
                        "primary key (codCurso)" +
                        ");" ;
                
            String sql2 =  "create table if not exists feira_de_curso.convidado (\n" +
                        "codCurso int unsigned not null,\n" +
                        "nome varchar(80) not null,\n" +
                        "cpf varchar (15) not null,\n" +
                        "email varchar(90),\n" +
                        "escolaridade varchar(20),\n" +
                        "telefone varchar(15),\n"
                    + "celular varchar(16)," +
                        "foreign key (codCurso) references feira_de_curso.curso (codCurso),\n" +
                        "primary key (cpf)\n" +
                        ");";
            String sql3= "load data local infile 'd:\\\\banco.txt' into table feira_de_curso.curso;";
            stm = con.createStatement();
            
            stm.execute(sql);
            stm.execute(sql2);
            stm.executeUpdate(sql3);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }

}
