/*
 * Implementação de algoritmos apresentados no capítulo 8 do
 * livro Projeto de Algoritmos com implementacoes em Java e C++ - Nivio Ziviani
 */
package processamentocadeias;


public class ProcessamentoCadeias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Casamento de cadeias exato");
        System.out.println("T = Exemplo de casamento de cadeia, P = casamento");
        System.out.println("\nForça bruta:");
        CasamentoCadeias.forcaBruta("Exemplo de casamento de cadeia", 30, "casamento", 7);
        System.out.println("\nShiftAnd:");
        CasamentoCadeias.shiftAndExato("Exemplo de casamento de cadeia", 30, "casamento", 7);
        System.out.println("\nBMHS:");
        CasamentoCadeias.forcaBruta("Exemplo de casamento de cadeia", 30, "casamento", 7);
        System.out.println("\n\nCasamento de cadeias aproximado\nT = Exemplo de casamento de cadeia, P = cazamento");
        System.out.println("\nshiftAnd Aproximado:");
        CasamentoCadeias.shiftAndAproximado("Exemplo de casamento de cadeia", 30, "cazamento", 7, 1);
        
    }
 
}
