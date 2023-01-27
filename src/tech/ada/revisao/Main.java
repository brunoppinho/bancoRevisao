package tech.ada.revisao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<Integer, Conta> contas = new HashMap();

    public static void main(String[] args) {
        Pix<Conta> pix = new Pix();
        Scanner entrada = new Scanner(System.in);
        Conta conta1 = new Conta();
        Conta conta2 = new Conta();
        ContaEspecial conta3 = new ContaEspecial(BigDecimal.TEN);

        contas.put(conta1.getNumero(), conta1);
        contas.put(conta2.getNumero(), conta2);
        contas.put(conta3.getNumero(), conta3);

        conta1.depositar(BigDecimal.TEN);
        conta3.getLimite();

        System.out.println("Digite o numero da conta de origem: ");
        var numeroEntrada = entrada.nextInt();

        System.out.println("Digite o numero da conta de origem: ");
        int numeroSaida = entrada.nextInt();
        pix.transferirDinheiro(conta3, BigDecimal.TEN, conta1);
        transferirDinheiro(numeroEntrada, BigDecimal.ONE, numeroSaida);
    }

    public static void transferirDinheiro(Conta contaOrigem, BigDecimal valor, Conta contaDestino) {
        if (valor.compareTo(contaOrigem.getSaldo()) < 0) {
            contaDestino.depositar(valor);
            contaOrigem.sacar(valor);
        }
    }

    public static void transferirDinheiro(int contaOrigem, BigDecimal valor, int contaDestino) {
        Conta origem = (Conta) contas.get(contaOrigem);
        Conta destino = (Conta) contas.get(contaDestino);

        transferirDinheiro(origem, valor, destino);
    }
}