
package view;

import java.util.ArrayList;
import java.util.HashMap;

import controller.ArvoreController;
import controller.GrafoController;
import model.Grafo;

public class Principal {

	public static void main(String[] args) {
		String[] router = new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};
		Grafo<String> g = new Grafo<>(router);
		g.link("B", "A");
		g.link("B", "C");
		g.link("A", "D");
		g.link("D", "G");
		g.link("D", "H");
		g.link("A", "F");
		g.link("F", "H");
		g.link("F", "K");
		g.link("C", "I");
		g.link("C", "J");
		g.link("J", "E");
		g.link("J", "I");
		g.link("J", "N");
		g.link("N", "O");	
		g.link("N", "M");
		g.link("I", "D");	
		g.link("E", "H");
		g.link("G", "L");
		g.link("H", "O");
		g.link("K", "L");
		g.link("L", "M");
		GrafoController c = new GrafoController();
		ArvoreController a = new ArvoreController();
		String raiz = "B";
		HashMap<String, ArrayList<String>> mapa = new HashMap<>();
		ArrayList<String> pais = new ArrayList<>();
		pais.add(raiz);
		c.acharCaminho(g, pais, mapa);
		System.out.println("{A=[B], B=[], C=[B], D=[B, A], E=[B, C, J], F=[B, A], G=[B, A, D], H=[B, A, F], I=[B, C], J=[B, C], K=[B, A, F], L=[B, A, F, K], M=[B, C, J, N], N=[B, C, J], O=[B, C, J, N]} - esperado");
		System.out.println(mapa+" - saida");
		a.criarArvore(mapa,raiz);
	}

}
