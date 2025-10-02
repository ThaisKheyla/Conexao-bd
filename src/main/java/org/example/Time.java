package org.example;

public class Time {
    private Integer id;
    private Integer qtdJogadores;
    private String Time;

    public Time(Integer id, Integer qtdJogadores, String time) {
        this.id = id;
        this.qtdJogadores = qtdJogadores;
        Time = time;
    }

    public Time() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQtdJogadores() {
        return qtdJogadores;
    }

    public void setQtdJogadores(Integer qtdJogadores) {
        this.qtdJogadores = qtdJogadores;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }


}

