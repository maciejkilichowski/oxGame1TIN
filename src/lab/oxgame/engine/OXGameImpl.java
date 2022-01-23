package lab.oxgame.engine;

import java.util.ArrayList;
import java.util.List;

import lab.oxgame.model.OXEnum;
import lab.oxgame.model.Rozgrywka;

public class OXGameImpl implements OXGame {
	private OXEnum kolej;
	private OXEnum zwyciezca;
	private OXEnum[] plansza;
	private int krok;
	
	
	@Override
	public void inicjalizuj() {
		krok = 0;
		zwyciezca = OXEnum.BRAK;
		kolej = getKolej();
		plansza = new OXEnum[] {OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, 
								OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, 
								OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, };
		
	}

	@Override
	public void set(int indeks) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OXEnum getPole(int indeks) {
		OXEnum pole = plansza[indeks];
		return pole;
	}

	@Override
	public OXEnum getKolej() {
		kolej = Math.random() < 0.5 ? OXEnum.X : OXEnum.O; //?OXEnum.X : OXEnum.O; wbudowany if
		return kolej;
	}

	@Override
	public OXEnum getZwyciezca() {
		boolean wygrana;
//		boolean wygrana = (kolej.equals(plansza[0]) && kolej.equals(plansza[4]) && kolej.equals(plansza[8]))
//				||(kolej.equals(plansza[2]) && kolej.equals(plansza[4]) && kolej.equals(plansza[6]))
//				
//				||(kolej.equals(plansza[0]) && kolej.equals(plansza[1]) && kolej.equals(plansza[2]))
//				||(kolej.equals(plansza[3]) && kolej.equals(plansza[4]) && kolej.equals(plansza[5]))
//				||(kolej.equals(plansza[6]) && kolej.equals(plansza[7]) && kolej.equals(plansza[8]));
		
		if(kolej.equals(plansza[0]) && kolej.equals(plansza[4]) && kolej.equals(plansza[8])) {
			wygrana = true;
			
			zwyciezca = getPole(4);
			System.out.println("w1");
		}else if((kolej.equals(plansza[2]) && kolej.equals(plansza[4]) && kolej.equals(plansza[6]))){
			wygrana = true;
			zwyciezca = getPole(4);
			System.out.println("w2");
		}else if((kolej.equals(plansza[0]) && kolej.equals(plansza[1]) && kolej.equals(plansza[2]))) {
			wygrana = true;
			zwyciezca = getPole(1);
			System.out.println("w3");
		}else if((kolej.equals(plansza[3]) && kolej.equals(plansza[4]) && kolej.equals(plansza[5]))) {
			wygrana = true;
			zwyciezca = getPole(4);
			System.out.println("w4");
		}else if((kolej.equals(plansza[6]) && kolej.equals(plansza[7]) && kolej.equals(plansza[8]))) {
			wygrana = true;
			zwyciezca = getPole(7);
			System.out.println("w5");
		}else if((kolej.equals(plansza[0]) && kolej.equals(plansza[3]) && kolej.equals(plansza[6]))) {
			wygrana = true;
			zwyciezca = getPole(3);
			System.out.println("w6");
		}else if((kolej.equals(plansza[1]) && kolej.equals(plansza[4]) && kolej.equals(plansza[7]))) {
			wygrana = true;
			zwyciezca = getPole(4);
			System.out.println("w7");
		}else if((kolej.equals(plansza[2]) && kolej.equals(plansza[5]) && kolej.equals(plansza[8]))) {
			wygrana = true;
			zwyciezca = getPole(5);
			System.out.println("w8");
		}
		
		
		return zwyciezca;
	}

	@Override
	public OXEnum setPole(int indeks) {
		plansza[indeks] = kolej;
		krok +=1;
		boolean koniec = krok > 8;
		
		
		return null;
	}
	
}
