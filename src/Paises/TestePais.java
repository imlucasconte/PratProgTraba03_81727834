package Paises;
import static org.junit.jupiter.api.Assertions.assertEquals;
import service.PaisService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestePais {
	Pais to,copia;
	PaisService service;
	static int id = 0;
	
	@Before
	public void setUp() throws Exception {
		System.out.println	("Setup");
		to    = new Pais	();
		to.setId(id);
		to.setNome("Lucas Conte");
		to.setPopulacao(111);
		to.setArea(44545.45);
		copia = new Pais	();
		to.setId(id);
		to.setNome("Lucas Conte");
		to.setPopulacao(111);
		to.setArea(44545.45);
		service = new PaisService();
		System.out.println	(to);
		System.out.println	(copia);
		System.out.println	(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("\nCarregar");
		//para funcionar o cliente 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais();
		fixture.setId(id);
		fixture.setNome("Lucas Conte");
		fixture.setPopulacao(111);
		fixture.setArea(44545.45);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals(novo, fixture, "TESTE CARREGAR");
	}
	@Test
	public void test01Incluir() {
		System.out.println	("\nIncluir");
		id = to.getId();
		System.out.println 	(id);
		copia.setId(id);
		assertEquals(to.getId(),copia.getId(),"TESTE INCLUIR");
	}
	@Test
	public void test02Atualizar() {
		System.out.println	("\nAtualizar");
		to.setNome			("NOME");
		copia.setNome		("NOME");
		service.atualizar	(to);
		to = service.carregar(to.getId());
		assertEquals(to.getNome(),copia.getNome(),"TESTE ATUALIZAR");
	}
	@Test
	public void test03Excluir() {
		System.out.println	("\nExcluir");
		copia.setId			(-1);
		service.excluir		(id	);
		to = service.carregar(id);
		assertEquals(to.getId(),copia.getId(),"TESTE EXCLUIR");
	}
	@Test
	public void test04MaiorPopulacao() {
		System.out.println	("\nMaior Populacao");
		service.maiorPopulacao(to);
		long populacao = to.getPopulacao();
		copia.setPopulacao(populacao);
		assertEquals(to.getPopulacao(),copia.getPopulacao(),"TESTE MAIOR POPULACAO");
	}	
	@Test
	public void test05MenorArea() {
		System.out.println	("\nMenor Area");
		service.menorArea	(to);
		double area = to.getArea();
		copia.setArea(area);
		assertEquals(to.getArea(),copia.getArea(),"TESTE MENOR AREA");
	}
	public void test06vetorTresPaises() {
		System.out.println	("\nVetor de 3 Paises");
		service.vetorTresPaises	(to);
		String [] array = service.vetorTresPaises(to);
		assertEquals(array.length,3,"TESTE VETOR");
	}
}