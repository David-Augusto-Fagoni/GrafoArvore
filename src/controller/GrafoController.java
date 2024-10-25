package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Grafo;
 
public class GrafoController {
	
 
	public void acharCaminho(Grafo<?> g,ArrayList<String> pais, HashMap<String, ArrayList<String>> mapa) {
		// a letra atual é pega
		String letra = pais.getLast();
		// a letra fala "quem ta aqui ?"
		while(!g.ligacao(letra, pais).isEmpty()) {
			// as respostas viram o novo caminho"
			for(int j=0; j<g.ligacao(letra, pais).size();j++) {
				// o novo caminho é tomado
				pais.add(g.ligacao(letra, pais).get(j));
				acharCaminho(g,pais, mapa);
			}
			break;
		}
		pais.removeLast();
		mapa.put(letra, pais);
		System.out.println(pais + "letra: "+letra);
		
		// Como o grafo tem que achar todos os caminhos então, contar os passos e escoar o grafo para virar arvore
	}

}

// [1],[1,2,3,4,5]
// [1],[[1],[2],[3]]