package controller;

import java.util.ArrayList;
import java.util.HashMap;

import model.Arvore;


public class ArvoreController {
	public void criarArvore(HashMap<String, ArrayList<String>> mapa, String raiz) {
		Arvore<String> arvore = new Arvore<String>(raiz);
		boolean troca = true;
		while(troca) {
			troca = false;
			for(String chave : mapa.keySet()) {
				if(chave != raiz) {
					String pai = mapa.get(chave).getLast();
					String filho = chave;
					if(arvore.addLeaf(pai,filho)) {
						troca = true;
					}
				}
			}
		}
		System.out.println("""
B
  A
    D
      G
    F
      H
      K
        L
  C
    I
    J
      N
        O
        M
      E
-------------------------------------------------
				""");
		System.out.println(arvore.toString());
	}
}