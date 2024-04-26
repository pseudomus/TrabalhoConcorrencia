package Entidades;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Conta {
    public Banco banco;
    private String titular;
    private Double saldo;
    private final Lock lock = new ReentrantLock();

    //Inicializador da classe
    public Conta(String titular, double saldoInicial, Banco banco) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.banco = banco;
    }

    //getters and setters
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    //Adicionar e retirar valor da conta
    public void addSaldo(Double valor) {
        lock.lock();
        try {
            this.saldo = this.saldo + valor;
        }finally {
            lock.unlock();
        }
    }

    public void debitarSaldo(Double valor) {
        lock.lock();
        try {
            this.saldo = this.saldo - valor;
        }finally {
            lock.unlock();
        }
    }
}
