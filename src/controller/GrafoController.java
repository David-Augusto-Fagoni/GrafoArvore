
package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Grafo;
 
public class GrafoController {
	
	public void acharCaminho(Grafo<String> g,ArrayList<String> pais, HashMap<String, ArrayList<String>> mapa) {
		String letra = pais.getLast();
			for(int j=0; j<g.getLigacao(letra, pais).size();j++) {
				pais.add(g.getLigacao(letra, pais).get(j));
				acharCaminho(g,pais, mapa);
			}
			pais.removeLast();
			mapSort(mapa,letra,pais);
			//System.out.println(pais + "letra: "+letra);
	}
	
	private void mapSort(HashMap<String, ArrayList<String>> mapa,String letra,ArrayList<String> pais){
		ArrayList<String> caminho = new ArrayList<String>();
		for(int k=0; k<pais.size();k++) {
			caminho.add(pais.get(k));
		}
		if(mapa.containsKey(letra)) {
			if(mapa.get(letra).size() >= caminho.size()) {
				mapa.put(letra, caminho);
			}
		}else {
			mapa.put(letra, caminho);
		}
	}

}
