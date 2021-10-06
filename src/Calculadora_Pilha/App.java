package Calculadora_Pilha;

import java.util.StringTokenizer;
import java.util.Scanner;
import java.util.Stack;

public class App {
	 private static Scanner ler = new Scanner(System.in);
	    
	    private static Stack<Integer> guardavalor = new Stack<>();
	public static void main(String[] args) {

		
		String expressao;
		System.out.println("Digite uma expressão:");		
		expressao=ler.nextLine();
		
		token(expressao);		
		
		}

		public static void token(String expressao) {
			
			int resultFinal = 0;
			StringTokenizer tokens = new StringTokenizer(expressao, " +-*/()", true);
			PilhaDeSinais listaPilha = new PilhaDeSinais();
			FilaPosFixa fila = new FilaPosFixa();
			
			while(tokens.hasMoreTokens()) {
				String auxiliar = tokens.nextToken();
				
				if(auxiliar.equals(" ")){
					}else{
					
						if(auxiliar.equals("*") || auxiliar.equals("+") || auxiliar.equals("-")){
							
							listaPilha.adicionar(auxiliar,fila);
							
						}else if(auxiliar.equals("/") || auxiliar.equals("(")|| auxiliar.equals(")")){
							
							listaPilha.adicionar(auxiliar,fila);
							
						}else{
							fila.inserir(auxiliar);
							 }	
						}
				}
				
			while(!listaPilha.vazia()) {
				fila.inserir(listaPilha.topo.proximo.meuValor);
				listaPilha.retirar();
			}
			
			System.out.println("");
			System.out.print("Pos Fixa:  ");
			fila.imprimir();	
			System.out.println("");
			System.out.println("");
	
			
	       String expressaoposfixa = "";
	       
	       while (!fila.vazia()){
	        	expressaoposfixa = fila.retirar();
	        	
	            if (ValorforInteiro(expressaoposfixa)) {
	                guardavalor.push(Integer.parseInt(expressaoposfixa));
	            } else if (ValorforOperador(expressaoposfixa)) {
	                int resultado = verificaOperacao(expressaoposfixa, guardavalor);
	                if (guardavalor.size() == 0) {} else {}
	                guardavalor.push(resultado);
	                resultFinal = resultado;
	            }
	            
	        }
	        System.out.println("Resposta da operação: " +resultFinal);
		}
	
	  	public static int verificaOperacao(String operador, Stack<Integer> guardavalor) {
	        int result = (guardavalor.empty()) ? 0 : guardavalor.pop();

	        if (!guardavalor.empty()) {
	            result = OperacaoPosFixa(operador, guardavalor.pop(), result);
	        }

	        return result;
	    }

	  	public static int OperacaoPosFixa(String operador, int n1, int n2) {
	        switch (operador) {
	            case "+": return n1 + n2;
	            case "-": return n1 - n2;
	            case "*": return n1 * n2;
	            case "/": {
	                if (n2 == 0) {
	                    System.out.println("Não é possivel dividir por 0");
	                    return n1;
	                }
	                return n1 / n2;
	            }
	            default: return n1;
	        }
	    }

	    public static boolean ValorforInteiro(String expressaoposfixa) {
	        if (expressaoposfixa == null) return false;

	        try {
	            Integer.parseInt(expressaoposfixa);
	        } catch (NumberFormatException ex) {
	            return false;
	        }
	        return true;
	    }

	    public static boolean ValorforOperador(String expressaoposfixa) {
	        if (expressaoposfixa == null) return false;

	        return expressaoposfixa.equals("+") || expressaoposfixa.equals("-") || expressaoposfixa.equals("*") || expressaoposfixa.equals("/");
	    }


}
	
	
	
	
	
	
	

