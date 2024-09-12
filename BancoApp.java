import javax.swing.JOptionPane;

public class BancoApp{

    private static Double saldo = 0.0;

    public static String getSaldo(){
        String aux = String.format("R$ %.2f", saldo);
        return aux;
    }

    public static void setDeposito(double value){
        BancoApp.saldo += value;
    }

    public static void setWithdraw(double value){
        BancoApp.saldo -= value;
    }


    public static void main(String[] args) {
        boolean status = true;

        String[] opcoes = {"Ver Saldo", "Depositar", "Sacar", "Transferir", "Sair"};

        while (status) { 
            int option = JOptionPane.showOptionDialog(  null,
                                                        "Escolha uma opção:",
                                                        "Banco",
                                                        JOptionPane.DEFAULT_OPTION,
                                                        JOptionPane.INFORMATION_MESSAGE,
                                                        null,
                                                        opcoes,
                                                        opcoes[0]
                                                    );





                //opcoes------------------------------------

            switch (option) {
                //Mostrar saldo -----------------------------
                case 0:
                    JOptionPane.showMessageDialog(null, "Seu saldo: "+ getSaldo());
                    break;

                //Depositar valor -----------------------------
                case 1:
                    String sValue = JOptionPane.showInputDialog(null, "Digite a quantia desejada em R$");
                    if(sValue == null){
                        JOptionPane.showMessageDialog(null, "Depósito cancelado");
                        break;
                    }

                    try {
                        Double value = Double.parseDouble(sValue);
                        setDeposito(value);
                        JOptionPane.showMessageDialog(null, "Valor adicionado!");
                    } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Valor inválido. Por favor insira um número.");
                    }
                    break;

                //Sacar Valor -----------------------------------
                case 2:
                    if(BancoApp.saldo > 0.0){
                        String wValue = JOptionPane.showInputDialog(null, "Digite a quantia que deseja sacar em R$");
                        if(wValue == null){
                        JOptionPane.showMessageDialog(null, "Saque cancelado");
                        break;
                        }
                        try {
                            Double withdrawValue = Double.parseDouble(wValue);
                            setWithdraw(withdrawValue);
                            JOptionPane.showMessageDialog(null, "O valor foi sacado com sucesso");
                        } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Por favor insira um número.");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Você atualmente não tem saldo para resgatar");
                    }
                    break;

                // Transferir Valor------------------------------
                case 3:
                    

                    break;

                // Botao Sair------------------------------------
                case 4:
                    JOptionPane.showMessageDialog(null, "Programa Encerrado");
                    status = false;
                    break;   
            }
        }
    }
}