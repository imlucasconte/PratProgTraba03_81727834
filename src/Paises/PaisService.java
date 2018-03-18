package Paises;

public class PaisService {
		PaisDAO dao;
		public PaisService() { dao = new PaisDAO();}	
	public void incluir(Pais to) {
		dao.incluir(to);
	}
	public void atualizar(Pais to) {
		dao.atualizar(to);
	}
	public void excluir(Pais to) {
		dao.excluir(to);
	}
	public void maiorPopulacao(Pais to) {
		dao.maiorPopulacao(to);
	}
	public void menorArea(Pais to) {
		dao.menorArea(to);
	}
	public String[] vetorTresPaises() {
		return dao.vetorTresPaises();
	}
}
