
package Calculadora_Pilha;
public class FilaPosFixa {
	
	public static final String ExPosfixa = null;
	public Elemento primeiro;
	public Elemento ultimo;
	public String imprimir;
	
	public FilaPosFixa() {
		primeiro = new Elemento(null);
		ultimo = primeiro;
	}
	
	public void inserir(String novoValor) {
		Elemento novoElemento = new Elemento(novoValor);
		ultimo.proximo = novoElemento;
		ultimo = novoElemento;
		}
	
	public void imprimir() {
		Elemento aux = primeiro.proximo;
		
		while(aux!=null) {
			String ExPosfixa=aux.meuValor;
			System.out.print(ExPosfixa+" ");
			aux = aux.proximo;
		}
	}

	
	public boolean vazia() {
		return(this.primeiro.proximo == null);
	}
	
	
	public String retirar(){
		Elemento aux = this.primeiro.proximo;
		this.primeiro.proximo = aux.proximo;
		aux.proximo = null;
		return aux.meuValor;
		
	}
}
