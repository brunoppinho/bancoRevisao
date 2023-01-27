package tech.ada.revisao;

import java.math.BigDecimal;
import java.util.Random;

public class Conta {

    protected BigDecimal saldo;
    private int numero;
    private String senha;

    public Conta() {
        this.saldo = BigDecimal.ZERO;
        setNumero();
    }

    private void setNumero() {
        this.numero = new Random().nextInt(10000);
        System.out.println("Conta de numero " + numero + " criada com sucesso!");
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void depositar(BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Não é possível depositar um valor negativo.");
        }
        saldo = valor.add(saldo);
        System.out.println("O saldo resultante da conta " + numero + " é de R$" + saldo);
    }

    public void sacar(BigDecimal valor) {
        if (valor.compareTo(saldo) > 0) {
            throw new RuntimeException("Saldo insuficiente.");
        }
        saldo = saldo.subtract(valor);
        System.out.println("O saldo resultante da conta " + numero + " é de R$" + saldo);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public boolean autenticar(String senhaDigitada) {
        return senhaDigitada.equals(senha);
    }

    public int getNumero() {
        return numero;
    }
}
