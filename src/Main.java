import dao.LoginDao;
import model.Login;
import java.util.Scanner;

public class Main {

     static LoginDao loginDao = new LoginDao();

    public static void main(String[] args) {
        /*FormCadastroLogin formCadastroLogin = new FormCadastroLogin();
        formCadastroLogin.setVisible(true);*/

        Scanner scan = new Scanner(System.in);

        loginDao.inserirLogin(new Login("Rafael", "rafael@teste.com", "senha123", "2025-10-10", "2025-10-10"));

        int opcao;

        do {
            System.out.println("---------------------------");
            System.out.println("1 - Cadastrar Usuario");
            System.out.println("2 - Listar Usuario");
            System.out.println("3 - Sair");
            System.out.println("Informe uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao){
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
                case 2:
                    System.out.println("Lista de Usuarios");

                    for (Login l : loginDao.getLista()){
                        System.out.println("-------------------------------");
                        System.out.println("Nome: "+l.getNome());
                        System.out.println("Email: "+l.getEmail());
                        System.out.println("Senha: "+l.getSenha());
                        System.out.println("Ativo: "+l.isAtivo());
                        System.out.println("Data Cadastro: "+l.getDataCadastro());
                        System.out.println("Dara da ultima atualização: "+l.getDataAtualizacao());
                    }
                    break;
                case 3:
                    System.out.println("saindo. . .");
                    break;
                default:
                    System.out.println("Erro, tente novamente!");
                    break;
            }
        }while (opcao != 3);
    }
}