package Paises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings("unused")
public class PaisDAO {
										/********* AQUI COMEÇA O CRUD *********/
										/* AQUI INCLUI */
	/* int id, String nome, long populacao, double area*/
	public void incluir(Pais to) {
	String sqlInsert = "INSERT INTO pais(id, nome, populacao, area) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
       PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt   (1, to.id);
			stm.setString(2, to.nome);
			stm.setLong  (3, to.populacao);
			stm.setDouble(4, to.area);
			stm.execute();
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
										/* AQUI ATUALIZA */
	public void atualizar(Pais to) {
				String sqlUpdate = "UPDATE pais SET nome=?, area=?, populacao=? WHERE id=?";
			    try (Connection conn = ConnectionFactory.obtemConexao();
		PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt   (1, to.id);
			stm.setString(2, to.nome);
			stm.setLong  (3, to.populacao);
			stm.setDouble(4, to.area);
			stm.execute();
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
										/* AQUI DELETA */
	public void excluir(int id) {
			String sqlDelete = "DELETE FROM cliente WHERE id = ?";
			try (Connection conn = ConnectionFactory.obtemConexao();
					PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
										/* AQUI maiorPopulacao */
	/*e. Crie um método que retorna o país com maior número de habitantes.*/
	public void maiorPopulacao(Pais to) {
		String sqlMaxPop = "SELECT * FROM paises WHERE populacao = (SELECT MAX(populacao) FROM pais)";
		try (Connection conn = ConnectionFactory.obtemConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlMaxPop);	
			ResultSet rs = stm.executeQuery();
			if(rs.next()) {
				to.setNome		(rs.getString    ("nome"));
				to.setPopulacao (rs.getLong 	 ("populacao"));
				to.setId		(rs.getInt	     ("id"));
				to.setArea      (rs.getDouble    ("area"));
			}else {
				System.out.println("ERROR RESULT SET");
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
										/* AQUI menorArea */
	/*f. Crie um método que retorna o país com menor área.*/
	public void menorArea(Pais to) {
			String sqlMinPo = "SELECT * FROM pais WHERE area = (SELECT MIN(area) FROM pais)";
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(sqlMinPo);	
				ResultSet rs = stm.executeQuery();
				if(rs.next()) {
					to.setNome		(rs.getString    ("nome"));
					to.setPopulacao (rs.getLong 	 ("populacao"));
					to.setId		(rs.getInt	     ("id"));
					to.setArea      (rs.getDouble    ("area"));
				}else {
					System.out.println("ERROR RESULT SET");
				}
				
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
										/* AQUI vetorTresPaises */
	/*g. Crie um método que retorne um vetor de 3 países.*/
	public String[] vetorTresPaises() {	
			String sqlGet = "SELECT nome FROM paises ORDER BY nome";
			String[] array = new String[3];
			int cont = 0 ;
			try (Connection conn = ConnectionFactory.obtemConexao()){
				PreparedStatement stm = conn.prepareStatement(sqlGet);
				ResultSet rs = stm.executeQuery();
				while(rs.next() && cont < 3 ) {
					array[cont] = rs.getString("nome");
					cont ++;
				}
			}catch (SQLException e) {
				System.out.println(e);
			}	
			return array;
	
		}

	public Pais carregar(int id) {
			Pais to = new Pais();
			String sqlSelect = "SELECT nome, fone FROM cliente WHERE cliente.id = ?";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (Connection conn = ConnectionFactory.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
			if (rs.next()) {
				to.setNome(rs.getString    ("nome"));
				to.setPopulacao(rs.getLong ("populacao"));
				to.setId(rs.getInt			("id"));
				to.setArea(rs.getDouble    ("area"));
				}
			} catch (SQLException e) {
			e.printStackTrace();
				}
			} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
				}
			return to;
		}

}
