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

	/**
	 * Adiciona um elemento ao final do vetor.
	 * @param elemento a ser adicionado
	 * @return true se o elemento foi adicionado com sucesso
	 */
	public boolean adiciona(T elemento) {
		this.aumentaCapacidade();
		if (tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	/**
	 * Adiciona um elemento em uma determinada posição do vetor.
	 * @param posicao em que o elemento será adicionado
	 * @param elemento a ser adicionado
	 * @return true se o elemento foi adicionado com sucesso
	 */
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
	
	
	/**
	 * Busca um elemento pela posição no vetor.
	 * @param posicao do elemento a ser buscado
	 * @return o elemento da posição
	 */
	public T busca(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.elementos[posicao];
	}

	/**
	 * Busca a posição de um elemento no vetor.
	 * @param elemento a ser buscado
	 * @return a posição do elemento no vetor, ou -1 se não existir
	 */
	public int indexOf(T elemento) {
		// algoritmo de ( Busca sequencial ) olha posição por posição se é o elemento que procuramos.
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Remove um elemento do vetor.
	 * @param elemento a ser removido
	 */
	public void remove(T elemento){
		int pos = this.indexOf(elemento);
		if(pos > -1){
			this.remove(pos);
		}
	}
	
	/**
	 * Remove um elemento de uma determinada posição do vetor.
	 * @param posicao do elemento a ser removido
	 */
	public void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		for(int i=posicao; i<this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
	}
	
	/**
	 * Retorna o tamanho do vetor.
	 * @return o tamanho do vetor
	 */
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