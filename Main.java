//Projeto final básico de java de ingressos de filmes (bem arcaico, porque não tive tempo de organizar no minicurso)
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
//principal
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Filmes[] filmes = {
        new Filmes("Jhon Wick - Parabellum", 131, 2.11),
        new Filmes("Adao Negro", 125, 2.5),
        new Filmes("Sonic 2", 122, 2.2),
        new Filmes("Interestelar", 169, 2.49),
        new Filmes("Resgate do Soldado Ryan", 170, 2.50)

    };

    Lista[] lista = {
        new Lista(filmes, "Lista de filmes em cartaz", null),

    };

    int op = 0;

    while (true) {
      System.out.println("----  Bem vindo ao Cinema  ----\n");
      System.out.println("1) Selecionar Filme\n2) sair\n");
      op = sc.nextInt();
      switch (op) {
        case 1:
          selecionarFilme(sc, filmes);
          break;
        case 2:
          return;
      }
    }

  }

  /*
   * private static void selecionarFilme(Scanner sc, Filmes[] filmes) {
   * 
   * int op = -1;
   * while (true) {
   * for (int i = 0; i < filmes.length; i++) {
   * System.out.println((i + 1) + ")" + filmes[i].Nome);
   * }
   * System.out.println("\nDigite 0 para encerrar o sistema");
   * op = sc.nextInt();
   * if (op != 0) {
   * exibirFilmes(sc, filmes[op - 1]);
   * } else {
   * break;
   * }
   * }
   * }
   */
  
  private static void selecionarFilme(Scanner sc, Filmes[] filmes) {

    int op = -1;
    while (true) {
      for (int i = 0; i < filmes.length; i++) {
        System.out.println((i + 1) + ")" + filmes[i].Nome);
      }
      System.out.println("\nDigite 0 para encerrar o sistema");
      op = sc.nextInt();
      if (op != 0) {
        exibirFilme(sc, filmes[op - 1]);
      } else {
        break;
      }
    }
  }

  public static void exibirFilme(Scanner sc, Filmes filme) {
    int op = -1;
    while (true) {
      filme.ExibirInfos();
      System.out.print("Deseja fazer o pedido? \n");
      System.out.println("1) Finalizar pedido\n2) sair\n");
      op = sc.nextInt();
      if (op == 1) {
        PedidoIngresso finalizar = new PedidoIngresso(filme);
        finalizar.pedido();
        System.out.println("_______________________________________");
        break;
      } else {
        break;
      }

    }
  }

}

class Lista {
  Filmes[] filmes;
  String lista;
  String nome;

  public Lista(Filmes[] filmes, String lista, String nome) {
    this.filmes = filmes;
    this.lista = lista;
    this.nome = nome;
  }

  public Filmes[] ExibirFilmes() {
    return filmes;
  }

}

class Filmes {
  String Nome;
  int Minutos;
  double Horas;

  public Filmes(String nome, int minutos) {
    Nome = nome;
    Minutos = minutos;
    double horas;
  }

  public Filmes(String nome, int minutos, double d) {
    Nome = nome;
    Minutos = minutos;
    Horas = d;
  }

  public void ExibirInfos() {
    System.out.printf("Nome: %s\nMinutos: %d\nDuração em Horas: %.2f\n", Nome, Minutos, Horas);
  }

}

class PedidoIngresso {
  LocalDateTime time;
  LocalDate data;
  Filmes filme;

  public PedidoIngresso(Filmes filme) {
    this.filme = filme;
  }

  public void pedido() {
    data = LocalDate.now();
    System.out.println("");
    time = LocalDateTime.now();
    // filme = filme.ExibirInfos();
    System.out.println(data);
    System.out.println("Obrigado, aqui esta o seu pedido.");
    System.out.println("Divirta-se!");

  }

}
