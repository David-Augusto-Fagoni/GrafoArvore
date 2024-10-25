package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Grafo;
 
public class GrafoController {
	
	public void acharCaminho(Grafo<?> g,ArrayList<String> pais, HashMap<String, ArrayList<String>> mapa) {
		ArrayList<String> caminho = new ArrayList<String>();
		for(int k=0; k<pais.size();k++) {
			caminho.add(pais.get(k));
		}
		String letra = caminho.getLast();
			for(int j=0; j<g.getLigacao(letra, caminho).size();j++) {
				caminho.add(g.getLigacao(letra, caminho).get(j));
				acharCaminho(g,caminho, mapa);
			}
			pais.removeLast();
			caminho.removeLast();
			mapSort(mapa,letra,caminho);
			//System.out.println(pais + "letra: "+letra);
	}
	private void mapSort(HashMap<String, ArrayList<String>> mapa,String letra,ArrayList<String> pais){
		if(mapa.containsKey(letra)) {
			if(mapa.get(letra).size() >= pais.size()) {
				mapa.put(letra, pais);
			}
		}else {
			mapa.put(letra, pais);
		}
	}
}
