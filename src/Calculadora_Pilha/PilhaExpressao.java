package Calculadora_Pilha;


public class PilhaExpressao{
	
	public Elemento topo;
	PilhaDeSinais listaPilha = new PilhaDeSinais();
	FilaPosFixa fila = new FilaPosFixa();
	double num;
	public PilhaExpressao(){
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
			
			if(!novoElemento.meuValor.equals("(")){
				
				novoElemento.proximo = this.topo.proximo;
				this.topo.proximo = novoElemento;
				
				
			}else if (!novoElemento.meuValor.equals(")")){
				
					do{
						
					if(!topo.proximo.meuValor.equals("(")){
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

	
		
		
			
	
	
	private static boolean isPrecedente( char A, char B ) {
		return ordemcalculooperador(A) >= ordemcalculooperador(B);
	}
	public static int ordemcalculooperador( char operador ) {
		int p = 0;
	    
		switch(operador)
		{
		case '(' : p = 1; break;
    	case '+' :
		case '-' : p = 2; break;
    	case '*' : 
		case '/' : p = 3; break;
		default  : p = 0;
		}
		
		return p;
	}
	
	
	 public static boolean Inteiro(String expressao) {
	        if (expressao == null) return false;

	        try {
	            Integer.parseInt(expressao);
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	        return true;
	    }

	    public static boolean Operador(String expressao) {
	        if (expressao == null) return false;

	        return expressao.equals("+") || expressao.equals("-") || expressao.equals("*") || expressao.equals("/");
	    }
	
	  
	    public static int calculaOperacao(String operador, int n1, int n2) {
	        switch (operador) {
	            case "+": return n1 + n2;
	            case "-": return n1 - n2;
	            case "*": return n1 * n2;
	            case "/": {
	                if (n2 == 0) {
	                    System.out.println("ERRO: Não pode dividir por 0");
	                    return n1;
	                }
	                return n1 / n2;
	            }
	            default: return n1;
	        }
	    }

	
	

	public String retirar(){ //pop
		Elemento aux = this.topo.proximo;
		this.topo.proximo = aux.proximo;
		aux.proximo = null;
		return aux.meuValor;
		//converter para parseint
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

