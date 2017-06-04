package com.vitor.estruturadados.vetor;

public class Lista<T> {
	
	private T[] elementos;
	private int tamanho;

	// construtor
	@SuppressWarnings("unchecked")
	public Lista(int capacidade) {
		this.elementos = (T[]) new Object[capacidade];
		this.tamanho = 0;
	}

//	public Lista(int capacidade, Class<T> tipoClasse) {
//		this.elementos = (T[]) Array.newInstance(tipoClasse, capacidade);
//		this.tamanho = 0;
//	}
	
	//adiciona dados no array.
	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	public boolean adiciona(int posicao, T elemento){
		
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		this.aumentaCapacidade();
		
		
		//mover todos os elementos.
		for(int i=this.tamanho-1; i>= posicao; i--){
			this.elementos[i+1] = this.elementos[i];
		}
		this.elementos[posicao] = elemento;
		this.tamanho++;
		
		return true;
	}
	
	
	//aumentando a capacidade do vetor.
	private void aumentaCapacidade(){
		if(this.tamanho == this.elementos.length){
			T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
			for(int i = 0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	
	//verifica se o elemento existe e a posição.
	public T busca(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.elementos[posicao];
	}

	// verifica se o elemento existe no vetor;
	public int busca(T elemento) {
		// algoritmo de ( Busca sequencial ) olha posição por posição se é o elemento que procuramos.
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public void remove(T elemento){
		int pos = this.busca(elemento);
		if(pos > -1){
			this.remove(elemento);
		}
	}
	
	//verifico o tamanho real do vetor.
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");

		for (int i = 0; i < this.tamanho - 1; i++) {
			s.append(this.elementos[i]);
			s.append(", ");
		}

		if (this.tamanho > 0) {
			s.append(this.elementos[this.tamanho - 1]);
		}
		s.append("]");

		return s.toString();
	}

}

