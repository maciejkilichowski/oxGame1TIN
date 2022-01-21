package lab.oxgame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lab.oxgame.datasource.DataSource;
import lab.oxgame.model.OXEnum;
import lab.oxgame.model.Rozgrywka;

public class RozgrywkaDAOImpl implements RozgrywkaDAO {

	@Override
	public int save(Rozgrywka rozgrywka) {
        int zapisanychWierszy = 0;
        String query = "INSERT INTO rozgrywka(gracz_o,gracz_x,zwyciezca, dataczas_rozgrywki) VALUES(?,?,?,?)";
        
        try(Connection connect = DataSource.getConnection();
                        PreparedStatement preparedStmt = connect.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
                preparedStmt.setString(1, rozgrywka.getGraczO());
                preparedStmt.setString(2, rozgrywka.getGraczX());
                preparedStmt.setString(3, rozgrywka.getZwyciezca().toString());
                preparedStmt.setObject(4, rozgrywka.getDataczasRozgrywki());
                
                zapisanychWierszy = preparedStmt.executeUpdate();
                
                ResultSet rs =  preparedStmt.getGeneratedKeys();
                
                if(rs.next()) {
                        rozgrywka.setRozgrywkaId(rs.getInt(1));
                        rs.close();
                }
        }catch(SQLException e) {
                throw new RuntimeException("B³¹d podczas zapisywania rozgrywki w bazie danych!", e);
        }
        
        return zapisanychWierszy;
}

	@Override
	public List<Rozgrywka> findAll() {
		List<Rozgrywka> rozgrywki = new ArrayList<>();
		String query = "SELECT * FROM rozgrywka ORDER BY dataczas_rozgrywki DESC";
		
		try(Connection connect = DataSource.getConnection();
				Statement stmt = connect.createStatement();
				ResultSet rs = stmt.executeQuery(query)){
			while(rs.next()) {
				Integer rozgrywkaId = rs.getInt("rozgrywka_id");
				String graczO = rs.getString("gracz_o");
				String graczX = rs.getString("gracz_x");
				OXEnum zwyciezca = OXEnum.fromString(rs.getString("Zwyciezca"));
				LocalDateTime dataczasRozgrywki = rs.getObject("dataczas_rozgrywki", LocalDateTime.class);
				Rozgrywka rozgrywka = new Rozgrywka(rozgrywkaId, graczX, graczO, zwyciezca, dataczasRozgrywki);
				rozgrywki.add(rozgrywka);
			}
		}catch(SQLException e) {
			throw new RuntimeException("B³¹d podczas pobierania rozgrywek z bazy danych!", e);
		}
		
		return rozgrywki;
	}

	@Override
	public int deleteAll() {
		int usunietychWierszy = 0;
		String query = "DELETE FROM rozgrywka";
		try(Connection connect = DataSource.getConnection();
				Statement stmt = connect.createStatement()){
			usunietychWierszy = stmt.executeUpdate(query);
		}catch(SQLException e) {
			throw new RuntimeException("B³¹d podczas usuwania historii rozgrywek!", e);
		}
		return usunietychWierszy;
	}

}
