import dao.CarrosDao;
import dao.LoginDao;
import modelo.Login;

import java.util.Scanner;

public class Main {

    static LoginDao loginDao = new LoginDao();
    static CarrosDao carrosDao = new CarrosDao();

    public static void main(String[] args) {

        //TelaPrincipalMenu telaMenu = new TelaPrincipalMenu();
        //telaMenu.setVisible(true);

        TelaPrincipalBotoes tpb = new TelaPrincipalBotoes();
        tpb.setVisible(true);

        //FormCadastroLogin formCadastroLogin = new FormCadastroLogin();
        //formCadastroLogin.setVisible(true);

        //FormCadastroCarro formCadastroCarro = new FormCadastroCarro();
        //formCadastroCarro.setVisible(true);

        //Scanner scan = new Scanner(System.in);

        /*loginDao.inserirLogin(new Login("Rafael", "rafael@teste.com", "senha123", "2025-10-10", "2025-10-10"));
        loginDao.inserirLogin(new Login("Rafael Silva", "rafael.silva@gmail.com", "Raf@12345", "2025-07-01", ""));
        loginDao.inserirLogin(new Login("Camila Pereira", "camila.pereira@hotmail.com", "Camila!2025", "2025-07-02", ""));
        loginDao.inserirLogin(new Login("Lucas Oliveira", "lucas.oliveira@yahoo.com", "Luca$9876", "2025-07-03", ""));
        loginDao.inserirLogin(new Login("Fernanda Costa", "fernanda.costa@gmail.com", "Fernanda#321", "2025-07-04", ""));
        loginDao.inserirLogin(new Login("Thiago Martins", "thiago.martins@outlook.com", "Thiago@654", "2025-07-05", ""));
        loginDao.inserirLogin(new Login("Aline Rocha", "aline.rocha@gmail.com", "Aline*8520", "2025-07-06", ""));
        loginDao.inserirLogin(new Login("Pedro Almeida", "pedro.almeida@yahoo.com", "Pedro!753", "2025-07-07", ""));
        loginDao.inserirLogin(new Login("Mariana Gomes", "mariana.gomes@hotmail.com", "Mariana#159", "2025-07-08", ""));
        loginDao.inserirLogin(new Login("Felipe Santos", "felipe.santos@gmail.com", "Felipe@456", "2025-07-09", ""));
        loginDao.inserirLogin(new Login("Juliana Ferreira", "juliana.ferreira@outlook.com", "Juliana*789", "2025-07-10", ""));
        loginDao.inserirLogin(new Login("Ricardo Dias", "ricardo.dias@yahoo.com", "Ricardo#963", "2025-07-11", ""));
        loginDao.inserirLogin(new Login("Patrícia Melo", "patricia.melo@gmail.com", "Patricia!852", "2025-07-12", ""));
        loginDao.inserirLogin(new Login("Gustavo Lima", "gustavo.lima@hotmail.com", "Gustavo@147", "2025-07-13", ""));
        loginDao.inserirLogin(new Login("Vanessa Ribeiro", "vanessa.ribeiro@yahoo.com", "Vanessa*258", "2025-07-14", ""));
        loginDao.inserirLogin(new Login("Bruno Castro", "bruno.castro@gmail.com", "Bruno#369", "2025-07-15", ""));
        loginDao.inserirLogin(new Login("Aline Nunes", "aline.nunes@outlook.com", "Aline!741", "2025-07-16", ""));
        loginDao.inserirLogin(new Login("Eduardo Moreira", "eduardo.moreira@yahoo.com", "Eduardo@852", "2025-07-17", ""));
        loginDao.inserirLogin(new Login("Larissa Fernandes", "larissa.fernandes@gmail.com", "Larissa*963", "2025-07-18", ""));
        loginDao.inserirLogin(new Login("Caio Souza", "caio.souza@hotmail.com", "Caio#159", "2025-07-19", ""));
        loginDao.inserirLogin(new Login("Sofia Barbosa", "sofia.barbosa@yahoo.com", "Sofia!357", "2025-07-20", ""));*/

        /*int opcao;
        do {
            System.out.println("---------------------------");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Listar Usuario");
            System.out.println("3 - Buscar Usuario");
            System.out.println("0 - Sair");
            System.out.println("Informe uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    Login login = new Login();

                    System.out.println("Informe o nome do usuario: ");
                    login.setNome(scan.nextLine());

                    System.out.println("Informe o e-mail: ");
                    login.setEmail(scan.nextLine());

                    System.out.println("Informe a senha: ");
                    login.setSenha(scan.nextLine());

                    System.out.println("Informe [false] para inativo e [true] para ativo: ");
                    login.setAtivo(scan.nextBoolean());

                    login.setDataCadastro("2025-10-10");
                    loginDao.inserirLogin(login);
                    break;
                case 2: {
                    int quantidadedeUsuarios = loginDao.getLista().size();

                    if (!loginDao.getLista().isEmpty()) {
                        System.out.println("Lista de Usuarios");
                        for (Login l : loginDao.getLista()) {
                            System.out.println("-------------------------------");
                            System.out.println("Nome: " + l.getNome());
                            System.out.println("Email: " + l.getEmail());
                            System.out.println("Senha: " + l.getSenha());
                            System.out.println("Ativo: " + l.isAtivo());
                            System.out.println("Data Cadastro: " + l.getDataCadastro());
                            System.out.println("Dara da ultima atualização: " + l.getDataAtualizacao());
                        }
                        System.out.println("--------------------------------------");
                        System.out.println("há " + quantidadedeUsuarios + " usuarios cadastrados no sistema!");
                    } else {
                        System.out.println("--------------------------------------");
                        System.out.println("não há usuarios cadastrados no sistema");
                    }
                    break;
                }
                case 3:
                    System.out.println("Buscar por ID:");
                    break;
                case 0:
                    System.out.println("saindo. . .");
                    break;
                default:
                    System.out.println("Erro, tente novamente!");
                    break;
            }
        } while (opcao != 0);*/
    }
}