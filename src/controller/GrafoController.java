
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

//	METODO COM RETORNO
//	public HashMap<String, ArrayList<String>> acharCaminho(Grafo<?> g,ArrayList<String> pais) {
//		HashMap<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
//		String letra = pais.getLast();
//		int vizinhos = g.getLigacao(letra, pais).size();
//		for(int j=0; j<vizinhos;j++) {
//			pais.add(g.getLigacao(letra, pais).get(j));
//			mapSort(mapa,acharCaminho(g, pais));
//		}
//		pais.removeLast();
//		mapSort(mapa, letra, pais);
//		//System.out.println(mapa.toString());
//		return mapa;
//		
//	}
//
//	
//	private HashMap<String, ArrayList<String>> mapSort (HashMap<String, ArrayList<String>> mapa1, HashMap<String, ArrayList<String>> mapa2) {
//		for(String j : mapa2.keySet()) {
//			if(mapa1.containsKey(j)) {
//				mapSort(mapa1, j, mapa2.get(j));
//			}else {
//				mapa1.put(j, mapa2.get(j));
//			}
//		}
//		
//		return mapa1;
//		
//	}
}
