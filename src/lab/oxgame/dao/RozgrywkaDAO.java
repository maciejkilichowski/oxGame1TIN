package lab.oxgame.dao;

import java.util.List;

import lab.oxgame.model.Rozgrywka;

public interface RozgrywkaDAO {
	int save(Rozgrywka rozgrywka);
	List<Rozgrywka> findAll();
	int deleteAll();
}
