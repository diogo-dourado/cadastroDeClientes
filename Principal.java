import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();                 //Inicializando o arrayList lista
        Scanner ler = new Scanner(System.in);                   //Inicializando variável para entrada de dados do usuário
        abrirMenu(ler, lista);                                  //Executa a função abrirMenu no começo do programa
        
    }

    public static void cadastrar(Scanner leitura, List<String> lista){
        
        String clienteNome;

        System.out.println("***Cadastrando clientes***");
        System.out.println("Digite o nome do cliente ou 0 para cancelar:");
        clienteNome = leitura.nextLine();
        if (clienteNome.matches("[0-9]*")) {                        //Ver se a entrada tem somente números
            switch (clienteNome) {
                case "0": abrirMenu(leitura, lista);
                        break;
                default:  digitarIdade(leitura, clienteNome, lista);
                        break;
            }
        }else{
            digitarIdade(leitura, clienteNome, lista);
        }
        
    }

    public static void digitarIdade(Scanner leitura, String clienteNome, List<String> lista){
        String clienteIdade;
        
        System.out.println("Digite a idade do cliente ou 0 para cancelar:");
        clienteIdade = leitura.nextLine();
        if (clienteIdade.matches("[0-9]*")) {
            switch (clienteIdade) {
                case "0": abrirMenu(leitura, lista);
                        break;
                default:
                lista.add(" Nome: " + clienteNome + " Idade: " + clienteIdade);         //Adicionar valor em um índice da lista
                System.out.println(lista.toString());
                System.out.println("Cliente adicionado com sucesso!");
                abrirMenu(leitura, lista);
                        break;
            }
        }else{
            System.out.println("Essa idade não é válida.");
            digitarIdade(leitura, clienteNome, lista);
        }
    }

    public static void apagar(Scanner leitura, List<String> lista){
        String indice;

        System.out.println("***Apagando cliente***");
        System.out.println("Clientes cadastrados");
        System.out.println(lista.toString());
        System.out.println("digite o índice do cliente que você quer apagar ou digite CANCELAR para voltar: ");
        System.out.println("Obs: A ordem é da esquerda para direita, sempre começando com 0");
        indice = leitura.nextLine();
        if (indice.matches("[0-9]*")){                                                          //Checar se a entrada só tem números
            int numeroDigitado = Integer.parseInt(indice);                                      //Converte o valor de entrada para inteiro
            if (numeroDigitado >= 0 && numeroDigitado < lista.size()){                        //Checar se existe a id digitada pelo usuário. O número da id é igual ao número de índices do arraylist
                lista.remove(numeroDigitado);
                System.out.println("O Cliente foi apagado com sucesso!");
                apagar(leitura, lista);
            }else{
                System.out.println("Índice não encontrada.");
                apagar(leitura, lista);
            }
        }else{
            switch (indice) {
                case "CANCELAR": abrirMenu(leitura, lista);
                    break;
                case "Cancelar": abrirMenu(leitura, lista);
                    break;
                case "cancelar": abrirMenu(leitura, lista);
                    break;
                default: System.out.println("Comando inválido.");
                apagar(leitura, lista);
                    break;
            }
                
        }

    }

    public static void modificar(Scanner leitura, List<String> lista){
        String indice, novoNome, novaIdade;

        System.out.println("***Modificando dados dos clientes***");
        System.out.println("Clientes cadastrados");
        System.out.println(lista.toString());
        System.out.println("digite o índice do cliente que você quer modificar ou digite CANCELAR para voltar: ");
        System.out.println("Obs: A ordem é da esquerda para direita, sempre começando com 0");
        indice = leitura.nextLine();
        if (indice.matches("[0-9]*")){                                                          //Checar se a entrada só tem números
            int numeroDigitado = Integer.parseInt(indice);                                      //Converte o valor de entrada para inteiro
            if (numeroDigitado >= 0 && numeroDigitado < lista.size()){                        //Checar se existe o índice digitada pelo usuário
                System.out.println("Cliente selecionado: ");
                System.out.println(lista.get(numeroDigitado));                                  //imprime o índice digitado
                System.out.println("Digite um novo nome: ");
                novoNome = leitura.nextLine();
                System.out.println("Digite a nova idade: ");
                novaIdade = leitura.nextLine();
                lista.set(numeroDigitado, " Nome: " + novoNome + " Idade: " + novaIdade);       //pegar o índice digitado e atualizar para o novo nome e idade
                System.out.println("O índice de cadastro foi atualizado com sucesso!");
                modificar(leitura, lista);
            }else{
                System.out.println("Índice não encontrada.");
                modificar(leitura, lista);
            }
        }else{
            switch (indice) {
                case "CANCELAR": abrirMenu(leitura, lista);
                    break;
                case "Cancelar": abrirMenu(leitura, lista);
                    break;
                case "cancelar": abrirMenu(leitura, lista);
                    break;
                default: System.out.println("Comando inválido.");
                modificar(leitura, lista);
                    break;
            }
                
        }

    }

    public static void listar(Scanner leitura, List<String> lista){
            String entrada;
            System.out.println("***Lista de clientes***");  
            System.out.println(lista.toString());
            System.out.println("Digite 0 para voltar");
            entrada = leitura.nextLine();
            if (entrada.matches("[0-9]*")) {
                switch (entrada) {
                    case "0": abrirMenu(leitura, lista);
                            break;
                    default:  System.out.println("Comando inválido.");
                              listar(leitura, lista);
                            break;
                }
            }else{
                System.out.println("Comando inválido.");
                listar(leitura, lista);
            }
            
    }

    public static void abrirMenu(Scanner leitura, List<String> lista){
        String entrada;
        
        System.out.println("*****Bem vindo ao Sistema de cadastro de Clientes********");
        System.out.println("1- Cadastrar cliente");
        System.out.println("2- Apagar cliente");
        System.out.println("3- Modificar cliente");
        System.out.println("4- Listar clientes");
        System.out.println("5- Sair");
        System.out.println("Digite uma opção:");
        entrada = leitura.nextLine();
        if (entrada.matches("[0-9]*")){         //Checar se a entrada tem somente números. Se verdadeiro, executa o switch
            switch (entrada) {
                case "1": cadastrar(leitura, lista);
                        break;
                case "2": apagar(leitura, lista);
                        break;
                case "3": modificar(leitura, lista);
                        break;
                case "4": listar(leitura, lista);
                        break;
                case "5": sair();                                             
                        break;
                default: System.out.println("Digite uma opção válida!");
                         System.out.println(" ");
                        abrirMenu(leitura, lista);
                        break;
            }
        }else{
            System.out.println("Digite um número válido para as opções abaixo.");
            abrirMenu(leitura, lista);
        }

    }

    public static void sair(){
        System.exit(0);                     //Fecha o programa
    }

}