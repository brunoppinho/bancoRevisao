package tech.ada.revisao;

import java.math.BigDecimal;

public class Pix<E extends Conta> {


    public void transferirDinheiro(E contaOrigem, BigDecimal valor, E contaDestino) {
        if (valor.compareTo(contaOrigem.getSaldo()) < 0) {
            contaDestino.depositar(valor);
            contaOrigem.sacar(valor);
        }
    }
}
