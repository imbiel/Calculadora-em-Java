package Calculadora_Pilha;

public class PilhaDeSinais{
	
	public Elemento topo;
	
	public PilhaDeSinais(){
		topo = new Elemento(null);	
	}
	
	public void adicionar(String novoValor, FilaPosFixa fila) {	
		Elemento novoElemento = new Elemento(novoValor);
		
		if(vazia()){
			novoElemento.proximo = this.topo.proximo;
			this.topo.proximo = novoElemento;
		}else{
			
			int Prior_topo = prioridade(topo.proximo.meuValor);
			int Prior_novo = prioridade(novoValor);
			
			if(novoElemento.meuValor.equals("(")){
				
				novoElemento.proximo = this.topo.proximo;
				this.topo.proximo = novoElemento;
				
				
			}else if (novoElemento.meuValor.equals(")")){
				
					do{
						
					if(topo.proximo.meuValor.equals("(")){
						retirar();
					}else {
						fila.inserir(topo.proximo.meuValor);
						retirar();	
					}
					
					}while(!topo.proximo.meuValor.equals("("));
					retirar();
					
			}else if(Prior_topo >= Prior_novo){
				
				fila.inserir(topo.proximo.meuValor);
				retirar();
				adicionar(novoElemento.meuValor, fila);	
				
			}else{
				novoElemento.proximo = this.topo.proximo;
				this.topo.proximo = novoElemento;
			}
			
		}
		
	}

	public int prioridade(String sinal){
		
			  switch(sinal){
			      case "+": return 1;
			      case "-": return 1;
			      case "*": return 2;
			      case "/": return 2;
			   }
			return 0;
			}

	public String retirar(){
		Elemento aux = this.topo.proximo;
		this.topo.proximo = aux.proximo;
		aux.proximo = null;
		return aux.meuValor;
		
	}
	
	public boolean vazia() {
		return(this.topo.proximo == null);
	}
	
	public void imprimir() {
		Elemento aux = topo.proximo;
		
		System.out.println();
		while(aux!=null) {				
			System.out.println(aux.meuValor+" ");
			aux = aux.proximo;
		}
	}
	

}

