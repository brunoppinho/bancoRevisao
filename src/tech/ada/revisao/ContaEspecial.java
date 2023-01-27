package tech.ada.revisao;

import java.math.BigDecimal;

public class ContaEspecial extends Conta {

    private BigDecimal limite;

    public BigDecimal getLimite() {
        return limite;
    }

    public ContaEspecial(BigDecimal limite) {
        super();
        this.limite = limite;
    }

    public ContaEspecial() {
        this(BigDecimal.TEN);
    }

    @Override
    public void sacar(BigDecimal valor) {
        if (valor.compareTo(getSaldo().add(limite)) > 0) {
            throw new RuntimeException("Saldo insuficiente.");
        }
        saldo = getSaldo().subtract(valor);
        System.out.println("O saldo resultante da conta " + getNumero() + " é de R$" + getSaldo());
    }
}
