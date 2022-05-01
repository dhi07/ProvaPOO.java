import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private final static int CAPACIDADE_LISTAS = 5;
    private static final Piloto Piloto = null;
    private static Scanner scanner = new Scanner(System.in);
    private static Piloto[] _pilotos = new Piloto[CAPACIDADE_LISTAS];
    private static int _numeroPilotos = 0;
    
    public static void main(String[] args) throws Exception {
        boolean continuarExecutando = true;
        do {
            try {
                imprimirMenu();
                int opcao = lerOpcao();
                continuarExecutando = executarOpcao(opcao);
            } catch (Exception e) {
                System.out.println("Ocorreu um erro durante a operação: " + e.getMessage());
                continuarExecutando = true;              
            }
        } while (continuarExecutando);
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        App.scanner = scanner;
    }

    public static int get_numeroPilotos() {
        return _numeroPilotos;
    }

    public static void set_numeroPilotos(int _numeroPilotos) {
        App._numeroPilotos = _numeroPilotos;
    }

    public static Piloto[] get_nome() {
        return _pilotos;
    }

    public static void set_nome(Piloto[] _nome) {
        App._pilotos = _nome;
    }


    private static boolean validarOpcaoMenu(int opcao) {
        return (opcao >= 1 && opcao <= 4);
    }

    private static int lerOpcao() {
        int opcao = 0;
        do {
            System.out.println("Selecione a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                if (!validarOpcaoMenu(opcao)) {
                    System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
            }
        } while (!validarOpcaoMenu(opcao));

        return opcao;
    }
    
    
    private static void imprimirMenu() {
        System.out.println("Cadastro de Pilotos!");
        System.out.println("1 - Cadastrar Piloto");
        System.out.println("2 - Listar Piloto");
        System.out.println("3 - Localizar Piloto");
        System.out.println("4 - Aumentar Espaço do Armazenamento");
        System.out.println("0 - Sair");
    }
    
    private static boolean executarOpcao(int opcao) throws Exception {
        switch (opcao) {
            case 1: {
                cadastrarPiloto();
                break;
            }
            case 2: {
                listarPiloto();
                break;
            }
            case 3: {
                localizarPiloto(null);
                break;
            }
            case 4 : {
                aumentarArmazenamento();
                break;
            } 
            case 0 : {
                System.out.println("Saindo do sistema...");
                return false;
            }
        }
        return true;
    }
    

    private static void cadastrarPiloto() throws InputMismatchException {
        System.out.println("Cadastro de Pilotos");
        System.out.println("Nome: ");
        String nome = scanner.nextLine();
        System.out.println("Matricula: ");
        int matricula = Integer.parseInt(scanner.nextLine());
        System.out.println("CNH: ");
        String cnh = scanner.nextLine();
        System.out.println("CPF: ");
        String cpf = scanner.nextLine();

        Piloto piloto = new Piloto(nome, matricula, cnh, cpf);
        adicionarPilotoNaLista(piloto);
    }   

    private static void adicionarPilotoNaLista(Piloto piloto) {
        if (_numeroPilotos != Piloto.length) {
            Piloto[] novaLista  = new Piloto[_pilotos.length];
            
            for (int i = 0; i < _pilotos.length; i++) {
                novaLista[i] = _pilotos[i];
            }

            
            _pilotos = novaLista;

        
        _pilotos[_numeroPilotos] = Piloto;  
        _numeroPilotos++;
        }
    }

    private static void listarPiloto() {
        System.out.println("Lista de pilotos cadastrados:");
        for (int i = 0; i < _numeroPilotos; i++) {
            System.out.println(_pilotos[i]);
        }
    }

    private static void localizarPiloto(String cpf) throws PilotoNaoEncontradoException {
        for (Piloto piloto: _pilotos) {
            if (piloto != null && piloto.get_cpf().equals(cpf)) {
                return;
            }
        }
    }
    
    private static void aumentarArmazenamento(){
        System.out.println("Insira o tamanho desejável ");
    }
}



