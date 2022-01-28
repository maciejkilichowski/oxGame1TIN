package lab.oxgame.engine;
import lab.oxgame.model.OXEnum;
public interface OXGame {
	//Plansze mo�na odwzorowa� za pomoc� tablicy
	//Jednowymiarowej 0,1,2 3,4,5 6,7,8
	
	//Losowanie kolejno�ci tj. X lub o i resetowanie gry
	void inicjalizuj();
	
	//Ustwaienie pola i aktualizacja stanu gry
	//(Zmiana kolejno�ci, sprawdzanie czy jest zwyci�zca)

	//zamiast int indeks zrobi� typ wyliczeniowy 
	OXEnum getPole(int indeks);
	OXEnum setPole(int indeks);
	
	//OXEnum.O lub OXEnum.X - wskazuje czyja kolej,
	//po zako�czeniu gry OXEnum.brak
	OXEnum getKolej();

	OXEnum getZwyciezca();
	int getKrok();
}
