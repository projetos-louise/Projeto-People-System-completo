package apps;

import composicoes.Endereco;
import composicoes.Cargo;
import contas.Conta;
import contas.ContaEspecial;
import contas.ContaInvestimento;
import estruturasdedados.ListaDeTelefonesNaoOrdenados;
import pessoas.Cliente;
import pessoas.Dependente;
import pessoas.Funcionario;

import java.time.LocalDate;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
////		Conta conta1 = new Conta(1, 1);
//		ContaEspecial contaesp1 = new ContaEspecial(02, 02, 02);
//		ContaInvestimento contaInv1 = new ContaInvestimento(03, 03, 03, 03);
//
////		conta1.numero = 1;
////		conta1.saldo = 10000;
////		conta1.depositar(10000);
////		conta2.numero = 2;
////		conta2.saldo = 20000;
////
////		contaesp1.numero = 01;
////		contaesp1.saldo = 12000;
////		contaInv1.numero = 02;
////		contaInv1.saldo = 13000;
//
//		Conta conta1 = null;
//		System.out.println("Número da conta 1: " + conta1.getNumero());
//		System.out.println("Número da saldo 1: " + conta1.getSaldo());
//
//
//
//			Cliente cli1 = new Cliente();
////        Endereco end1 = new Endereco();
//			Dependente dep1 = new Dependente();
//			dep1.setClienteParente(cli1);
////        cli1.setEndereco(end1);
//			Scanner input = new Scanner(System.in);
//
		Funcionario funcionario = new Funcionario("Louise",
				LocalDate.of(2024, 5, 15), // Data de nascimento
				new Endereco("Rua das Flores", "123", "Centro", "João Pessoa", "PB"),
				new ListaDeTelefonesNaoOrdenados(),
				1001, // Matrícula
				Cargo.ESTAGIARIO, // Cargo
				5000.0, // Salário
				LocalDate.of(2021, 3, 10) // Data de admissão
		);

	}

}
