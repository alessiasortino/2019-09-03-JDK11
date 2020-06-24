package it.polito.tdp.food.model;

import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	private Graph <String , DefaultWeightedEdge> grafo;
	private FoodDao dao;
	private List <Coppia> coppie;
	
	
	public Model() {
		dao= new FoodDao();
		coppie= dao.getCoppie();
		
	}
	
	public void creaGrafo(Integer c) {
		grafo= new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		//vertici
		List <String> vertici = dao.getPortionDisplayName(c);
		
		Graphs.addAllVertices(grafo, vertici);
		
		
		//archi
		List <Coppia> coppie= dao.getCoppie();
		for(Coppia d: coppie) {
			if(d!=null) {
			if(grafo.containsVertex(d.getA1())&& grafo.containsVertex(d.getA2())) {
				Graphs.addEdgeWithVertices(grafo,d.getA1(), d.getA2(), d.getPeso());
				
			}
		}
		}
		
		
	}
	public List<String> getVertici(Integer c){
		return dao.getPortionDisplayName(c);
		
	}
	 public int vertexNumber() {
			return this.grafo.vertexSet().size();
		}
		
		public int edgeNumber() {
			return this.grafo.edgeSet().size();
		}
		

	
	public String  getVicini(String sorgente){
		String s= "Connessioni a "+sorgente+" : ";
		List <String > vicini= Graphs.neighborListOf(grafo, sorgente);
		for(String v: vicini) {
			s+="\n"+v+ " peso: "+ grafo.getEdgeWeight(grafo.getEdge(v, sorgente));
		}
		
		return s;
	}
}
