import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o tipo de conta: ");
        String tipoDeConta = scanner.nextLine();
        System.out.print("Digite o saldo inicial da conta: ");
        double accountBalance = scanner.nextDouble();
        int operation = 0;

        String customerData = """
                    ***********************************************
                    Dados iniciais do cliente:
                    
                    Nome:              %s
                    Tipo de conta:     %s
                    Saldo atual:       %.2f
                    ***********************************************""".formatted(nomeCliente, tipoDeConta, accountBalance);
        System.out.println(customerData);

        while (operation != 4){
            System.out.println("""
                     
                     Operações:
                 
                    1- Consultar saldos
                    2- Receber valor
                    3- Transferir valor
                    4- Sair
                    
                    Digite a opção desejada:""");
            operation = scanner.nextInt();
            if (operation == 1){
                System.out.printf("O saldo atual é R$ %.2f%n", accountBalance);
            } else if (operation == 2) {
                System.out.println("Informe o valor a receber: ");
                double receiveTransfer = scanner.nextDouble();
                accountBalance += receiveTransfer;
                System.out.printf("Saldo atualizado R$ %.2f%n", accountBalance);
            } else if (operation == 3) {
                System.out.println("Informe o valor que deseja transferir: ");
                double transferValue = scanner.nextDouble();
                if (transferValue > accountBalance) {
                    System.out.println("Não há saldo suficiente para fazer essa transferência");
                } else {
                    accountBalance -= transferValue;
                    System.out.printf("Saldo atualizado R$ %.2f%n", accountBalance);
                }
            } else if (operation > 4){
                System.out.println("Opção inválida");
            }
        }
    }
}
