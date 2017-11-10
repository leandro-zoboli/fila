package fila;

import java.util.Scanner;

class Pessoa {

    String nome;
    Pessoa proxima;
}

public class Fila {

    static Pessoa primeira = null;
    static Pessoa ultima = null;

    public static int pedeInt(String msg, int min, int max) {
        int ret = min - 1;
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.nextInt();
                if (ret < min || ret > max) {
                    menu();
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret < min || ret > max || erro);
        return ret;
    }

    public static String pedeString(String msg, int min, int max) {
        String ret = "";
        boolean erro;
        do {
            erro = false;
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println(msg);
                ret = scan.next();
                if (ret.length() < min || ret.length() > max) {
                    System.out.println("Informe um nome de " + min + " a " + max + " caracteres");
                }
            } catch (Exception e) {
                erro = true;
            }
        } while (ret.length() < min || ret.length() > max || erro);
        return ret;
    }

    public static void menu() {
        int resp = 0;
        do {
            System.out.println("----------------------------------");
            System.out.println("1- Incluir uma pessoa na fila");
            System.out.println("2- Remover uma pessoa da fila");
            System.out.println("3- Mostrar fila");
            resp = pedeInt("Informe a opção desejada", 1, 100);
            switch (resp) {
                case 1:
                    incluiPessoa();
                    break;
                case 2:
                    removePessoa();
                    break;
                case 3:
                    mostraFila();
                    break;
            }
        } while (resp < 1 && resp > 3);
    }

    public static void incluiPessoa() {
        Pessoa novo = new Pessoa();
        novo.nome = pedeString("informe o nome da pessoa a ser adicionada", 1, 100);
        if (primeira == null) {
            primeira = novo;
            ultima = novo;
            primeira.proxima = ultima;
            ultima.proxima = null;
        } else {
            ultima.proxima = novo;
            ultima = novo;
            ultima.proxima = null;
        }
        menu();
    }

    public static void removePessoa() {
        if (primeira == null) {
            System.out.println("Não têm pessoas na fila");
        } else {
            if (primeira == ultima) {
                primeira = null;
                ultima = null;
            } else {
                primeira = primeira.proxima;
            }
        }
        menu();
    }

    public static void mostraFila() {
        if (primeira == null) {
            System.out.println("Não têm pessoas na fila");
        } else {
            Pessoa atual = primeira;
            while (atual != null) {
                System.out.println("- " + atual.nome);
                atual = atual.proxima;
            }
        }
        menu();
    }

    public static void main(String[] args) {
        menu();
    }

}
