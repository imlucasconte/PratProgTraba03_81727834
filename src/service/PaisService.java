package service;

import Paises.Pais;
import Paises.PaisDAO;

public class PaisService {
		PaisDAO dao;
		public PaisService() { dao = new PaisDAO();}	
	public void incluir(Pais to) {
		dao.incluir(to);
	}
	public void atualizar(Pais to) {
		dao.atualizar(to);
	}
	public void excluir(int id){
		dao.excluir(id);
	}
	public void maiorPopulacao(Pais populacao) {
		dao.maiorPopulacao(populacao);
	}
	public void menorArea(Pais to) {
		dao.menorArea(to);
	}
	public String[] vetorTresPaises(Pais to) {
		return dao.vetorTresPaises();
	}
	public Pais carregar(int id) {
		return dao.carregar(id);
	}
}
