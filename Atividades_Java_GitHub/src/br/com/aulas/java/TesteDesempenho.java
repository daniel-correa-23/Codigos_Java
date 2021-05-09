package br.com.aulas.java;

import java.util.Arrays;
import java.util.Random;

/*
Resultado:
Metodo 1 (comando for)-> tempo de processamento -> 13
Metodo 2 (clone) -> tempo de processamento -> 37
Metodo 3 (System.arraycopy) -> tempo de processamento -> 11
Metodo 4 (Arrays.copyOf) -> tempo de processamento -> 35

*/

public class TesteDesempenho {
	public static void main(String[] args) {
		// (0) declara de variáveis e preenche o array "a"
		long startTime;
		long endTime;

		int[] a = new int[9999999];
		int[] b = new int[a.length];

		Random numeros = new Random();
		for (int i = 0; i < a.length; i++)
			a[i] = numeros.nextInt();

		// - cópia com a abordagem 1 (comando for)
		startTime = System.currentTimeMillis();

		for (int i = 0; i < a.length; i++)
			b[i] = a[i];

		endTime = System.currentTimeMillis();
		System.out.println("Metodo 1 (comando for)-> tempo de processamento -> " + (endTime - startTime));

		// - cópia com a abordagem 2 (método clone)
		startTime = System.currentTimeMillis();
		b = a.clone();
		endTime = System.currentTimeMillis();
		System.out.println("Metodo 2 (clone) -> tempo de processamento -> " + (endTime - startTime));

		// - cópia com a abordagem 3 (método System.arraycopy)
		startTime = System.currentTimeMillis();
		System.arraycopy(a, 0, b, 0, a.length);
		endTime = System.currentTimeMillis();
		System.out.println("Metodo 3 (System.arraycopy) -> tempo de processamento -> " + (endTime - startTime));

		// - cópia com a abordagem 4 (método Arrays.copyOf)
		startTime = System.currentTimeMillis();
		b = Arrays.copyOf(a, a.length);
		endTime = System.currentTimeMillis();
		System.out.println("Metodo 4 (Arrays.copyOf) -> tempo de processamento -> " + (endTime - startTime));
	}
}
