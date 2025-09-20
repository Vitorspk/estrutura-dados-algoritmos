package com.vitor.estruturadados.vetor;

/**
 * @deprecated use a classe {@link com.vitor.estruturadados.vetor.Lista} em vez desta.
 */
@Deprecated
public class VetorObject {

	private Object[] elementos;
	private int tamanho;

	// construtor
	public VetorObject(int capacidade) {
		this.elementos = new Object[capacidade];
		this.tamanho = 0;
	}


	//adiciona dados no array.
	public boolean adiciona(Object elemento) {
		this.aumentaCapacidade();
		if (tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	
	public boolean adiciona(int posicao, Object elemento){
		
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
			Object[] elementosNovos = new Object[this.elementos.length * 2];
			for(int i = 0; i<this.elementos.length; i++){
				elementosNovos[i] = this.elementos[i];
			}
			this.elementos = elementosNovos;
		}
	}
	
	
	//verifica se o elemento existe e a posi��o.
	public Object busca(int posicao) {
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		return this.elementos[posicao];
	}

	// verifica se o elemento existe no vetor;
	public int busca(Object elemento) {
		// algoritmo de ( Busca sequencial ) olha posi��o por posi��o se � o elemento que procuramos.
		for (int i = 0; i < this.tamanho; i++) {
			if (this.elementos[i].equals(elemento)) {
				return i;
			}
		}
		return -1;
	}
	
	
	public void remove(int posicao){
		if (!(posicao >= 0 && posicao < tamanho)) {
			throw new IllegalArgumentException("Posicao invalida");
		}
		for(int i= posicao; i < this.tamanho-1; i++){
			this.elementos[i] = this.elementos[i+1];
		}
		this.tamanho--;
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
