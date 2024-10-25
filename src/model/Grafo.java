package model;

import java.util.ArrayList;
import model.Grafo;
import java.util.Arrays;
 
public class Grafo<T> {
	private int [] [] matriz;
	private String[] labels;
	public Grafo (String [] labels) {
		this.labels = labels;
		this.matriz = new int [labels.length] [labels.length];
	}
	public void link (String label1, String label2) {
		int index_label1 = Arrays.asList(this.labels).indexOf(label1);
		int index_label2 = Arrays.asList(this.labels).indexOf(label2);
		this.matriz[index_label1] [index_label2] = 1;
		this.matriz[index_label2] [index_label1] = 1;
	}
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < this.labels.length; i++) {
			builder.append(this.labels[i]+": ");
			for(int j = 0; j < this.labels.length; j++) {
				if(this.matriz[i][j] == 1) {
					builder.append(this.labels[j]+" ");
				}
			}
			builder.append("\r\n");
		}
		return builder.toString();
	}

	public ArrayList<String> ligacao(String index, ArrayList<String> pais) {
		ArrayList<String> lista = new ArrayList<>();
		for(int i = 0; i < this.labels.length; i++) {
			if (this.labels[i] == index) {
				for(int j = 0; j < this.labels.length; j++) {
					if(this.matriz[i][j] == 1 && !pais.contains(this.labels[j])) {
						lista.add(this.labels[j]);
					}
				}
			}
		}
		return lista;
	}
}
