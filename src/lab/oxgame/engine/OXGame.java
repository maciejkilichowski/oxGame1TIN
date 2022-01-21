package lab.oxgame.engine;
import lab.oxgame.model.OXEnum;
public interface OXGame {
	//Plansze mo¿na odwzorowaæ za pomoc¹ tablicy
	//Jednowymiarowej 0,1,2 3,4,5 6,7,8
	
	//Losowanie kolejnoœci tj. X lub o i resetowanie gry
	void inicjalizuj();
	
	//Ustwaienie pola i aktualizacja stanu gry
	//(Zmiana kolejnoœci, sprawdzanie czy jest zwyciêzca)
	void set(int indeks);
	//zamiast int indeks zrobiæ typ wyliczeniowy 
	OXEnum getPole(int indeks);
	OXEnum setPole(int indeks);
	
	//OXEnum.O lub OXEnum.X - wskazuje czyja kolej,
	//po zakoñczeniu gry OXEnum.brak
	OXEnum getKolej();
	
	OXEnum getZwyciezca();
}
