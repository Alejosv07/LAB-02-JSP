package Clases;

import java.util.ArrayList;
import java.util.Random;

public class numeroAleatorio {

    Random r = new Random();
    public int numeroMenor = 0;
    public int numeroMayor = 1000;
    public int c = -1;
    public String pista;
    public int numeroSecreto = r.nextInt((numeroMayor + 1) - numeroMenor) + numeroMenor;
    public String alerta = "warning";
    public ArrayList<Integer> numeroElegido;
    public ArrayList<String> mensajes;
    public boolean exito = false;
    public int numeroMayorProximo = this.numeroMayor;
    public int numeroMenorProximo = this.numeroMenor;
    
    public numeroAleatorio(ArrayList<Integer> numeroElegido) {
        this.numeroElegido = numeroElegido;
    }

    public void setPista(int numero) {
        if (numero > getSecreto()) {
            this.pista = "menor";
        } else {
            this.pista = "mayor";
        }
    }

    public String getPista() {
        return this.pista;
    }

    public int getSecreto() {
        return this.numeroSecreto;
    }
    
    public void setNumerosProximos(int numero){
        if (numero > getSecreto()){
            this.numeroMayorProximo = numero;
        } else if (numero < getSecreto()) {
            this.numeroMenorProximo = numero;
        }
    }
    
    public int getNumeroProximoMenor(){
        return this.numeroMenorProximo;
    }
    public int getNumeroProximoMayor(){
        return this.numeroMayorProximo;
    }

    public int ingresarNumero(int numero) {
        if (numero == getSecreto()) {
            return 2; //Exito
        } else {
            if (numero > getSecreto()) {
                return 0; //Necesita un numero menor
            } else {
                return 1; //Necesita un numero mayor
            }
        }
    }

    public void setNumeroElegido(int numero) {
        if (this.exito == false) {
            this.numeroElegido.add(numero);
            this.c++;
        }
    }

    public ArrayList<Integer> getNumeroElegido() {
        return this.numeroElegido;
    }

    public void setMensaje(String mensaje) {
        if (this.exito == false) {
            System.out.println(mensaje);
            this.mensajes.add(mensaje);
        }

    }

    public ArrayList<String> getMensaje() {
        return this.mensajes;
    }

    public void setAlerta(int numero) {
        if (this.exito == false) {
            if (getSecreto() == numero) {
                this.alerta = "success";
                this.exito = true;
            } else if (getNumeroElegido().size() < 9) {
                this.alerta = "warning";
            } else {
                this.alerta = "danger";
            }
        }
    }

    public String getAlerta() {
        return this.alerta;
    }
}
