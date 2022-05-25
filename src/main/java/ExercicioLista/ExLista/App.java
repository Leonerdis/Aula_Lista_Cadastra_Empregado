package ExercicioLista.ExLista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidade.Empregado;

public class App {
    
    public static void main(String[] args) {
    	Locale.setDefault(Locale.US);
    	Scanner sc = new Scanner(System.in);
    	
    	List<Empregado> list = new ArrayList<>();
    	System.out.println("Quantos funcionários serão cadastrados? ");
    	int N = sc.nextInt();
    	for(int i=0; i<N; i++) {
    		System.out.println();
    		System.out.println("Entre com os dados do empregado #" + (i + 1)  + ":");
    		System.out.print("Id: ");
    		Integer id = sc.nextInt();
   
    		//valida que o id já foi digitado
    		while(idJaDigitado(list, id)) {
    			System.out.println("Você digitou um id já existente! Digite novamente:");
    			id = sc.nextInt();
    		}
    		System.out.print("Nome: ");
    		sc.nextLine();
    		String nome = sc.nextLine();
    		System.out.print("Salario: ");
    		Double salario = sc.nextDouble();
    		Empregado emp = new Empregado(id, nome, salario);
    		list.add(emp);
    	}
  
    	System.out.println("Entre com o id empregado que terá aumento de salário: ");
    	int idsalario = sc.nextInt();
    	Integer posicao = hasId(list, idsalario);
    	
    	//valida que o id não existe	
    	while(posicao == null) {
    		System.out.println("Este id não existe! Digite novamente: ");
    		idsalario = sc.nextInt();
    		posicao = hasId(list, idsalario);
    	} {
    		System.out.println("Entre com a porcentagem:");
    		double porcentagem = sc.nextDouble();
    		list.get(posicao).incrementoSalario(porcentagem);
    	}
    	
    	System.out.println();
    	System.out.println("# Lista de Empregados Cadastrados: #");
    	for(Empregado emp: list) {
    		System.out.println(emp);
    	}
    	
    	sc.close();
    	
    }
    
     public static Integer hasId(List<Empregado> list, int id ) {
    	 for(int i=0; i<list.size(); i++) {
    		 if(list.get(i).getId() == id) {
    			 return i;
    		 }
    	 }
    	 return null;
     }
     
     public static boolean idJaDigitado(List<Empregado> list, int id) {
    	 Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    	 return emp !=null;
     }
    
    
}
