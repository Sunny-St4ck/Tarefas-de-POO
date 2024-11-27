package Estudos2;

import java.util.Scanner;

class banco {
	int limite = 100, i = 0;
	double Saldo = 0.00;
	double[] Extrato = new double[10];
	Scanner Uinput = new Scanner(System.in);
	
	
	banco(){
		System.out.println("Informe qual o saldo atual de sua conta.\n");
		this.Saldo += Uinput.nextDouble();
		
	}
	
	void ver_saldo() {
		if (this.Saldo == 0.00) {
			System.out.println ("Você não possui Saldo. Tente novamente após depositar em sua conta.\n");
			return;
		} else {
			System.out.println("O seu saldo é " + (this.Saldo + limite) + " Reais.\n");
			
		}
	}
	
	void sacar() {
		double saque;
		System.out.println("Informe quantos reais você deseja sacar\n");
		saque = Uinput.nextDouble();
		
		if (saque < 0.00 || saque == 0.00) {
			while (saque < 0.00 || saque == 0.00) {
				saque = 0.00;
				System.out.println("Você não pode sacar um valor negativo ou igual à zero, por favor, tente novamente com um número maior que zero.\n");
				saque = Uinput.nextDouble();
			}
		}
		if (saque > Saldo) {
			System.out.println("Você não tem saldo o suficiente");
			return;
		}
		this.Saldo -= saque;
		System.out.println("Você sacou " + saque + " Reais, seu saldo restante é " + this.Saldo + '\n');
		
		if (Extrato[i] == 0.00) {
			Extrato[i] = (saque * -1);
			i++;
		} else {
			Extrato[i+1] = (saque * -1);
			i++;
		}
	}
	
	
	void depositar () {
		double deposito;
		System.out.println ("Informe quantos reais você deseja depositar\n");
		deposito = Uinput.nextDouble();
		
		if (deposito <= 0) {
			while (deposito <= 0) {
			System.out.println("Você não pode depositar nada ou um valor negativo.\n");
			deposito = 0;
			deposito = Uinput.nextDouble();	
			}
		}
		
		System.out.println("Você depositou " + deposito + " Reais\n");
		this.Saldo = deposito;
		
		if (Extrato[i] == 0.00) {
			Extrato[i] = deposito;
			i++;
		} else {
			Extrato[i+1] = deposito;
			i++;
		}
	}
	
	void transferir () {
		
		double transfer;
		String pessoa;
		
		System.out.println("Informe o nome da pessoa que deseja transferir\n");
		pessoa = Uinput.nextLine();		
		
		System.out.println("Agora informe o valor a ser transferido.\n");
		transfer = Uinput.nextDouble();
		
		this.Saldo -= transfer;
		
		System.out.println("Você transferiu " + transfer + "Reais para " + pessoa + "\n");
		
		if (Extrato[i] == 0.00) {
			Extrato[i] = (transfer * -1);
			i++;
		} else {
			Extrato[i+1] = (transfer * -1);
			i++;
		}

	}
	
	void extrato () {
		
		for (int j=0; j<i; j++) {
			if (Extrato[j] > 0){
				System.out.println ("+" + Extrato[j]);
			} else if (Extrato[j] < 0) {
				System.out.println (Extrato[j]);
			}
		}
	}
}
