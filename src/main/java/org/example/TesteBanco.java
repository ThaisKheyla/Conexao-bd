package org.example;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import java.util.List;

public class TesteBanco {

    static void main(String[] args) {
        Connection connection = new Connection();
        JdbcTemplate con = new JdbcTemplate(
                connection.getDataSource());


        con.execute("CREATE TABLE IF NOT EXISTS Time (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "qtdJogadores INT" +
                ");");

        //Outra forma de fazer
//        con.execute("""
//                CREATE TABLE IF NOT EXISTS Time(
//                id int primary key auto_increment,
//                nome VARCHAR(50) NOT NULL,
//                qtdJogadores INT
//                );
//
//                """);

        con.update("INSERT INTO Time (nome, qtdJogadores) VALUES ('vasco da gama ', 20);");
        con.update("INSERT INTO Time (nome, qtdJogadores) VALUES ('Santos ', 40);");
        con.update("INSERT INTO Time (nome, qtdJogadores) VALUES ('Paysandu ', 100);");

        String sqlInsert = "INSERT INTO Time (nome, qtdJogadores) VALUES (?, ?);";
        con.update(sqlInsert, "Palmeiras", 20);



        List times = con.queryForList("SELECT * FROM Time;");
        System.out.println("Exibindo o resultado!");
        System.out.println(times);

        List<Time> listaTimes = con.query("SELECT * FROM Time;",
        new BeanPropertyRowMapper<>(Time.class));


        System.out.println("exibindo objeto de times");
        for (int i = 0; i < listaTimes.size(); i++) {
            System.out.println(listaTimes.get(i));

        }

    }

}
