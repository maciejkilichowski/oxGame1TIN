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
		kolej = Math.random() < 0.5 ? OXEnum.X : OXEnum.O; //?OXEnum.X : OXEnum.O; wbudowany if
		plansza = new OXEnum[] {OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, 
								OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, 
								OXEnum.BRAK, OXEnum.BRAK, OXEnum.BRAK, };	
	}
	@Override
	public OXEnum getPole(int indeks) {
		OXEnum pole = plansza[indeks];
		return pole;
	}

	@Override
	public OXEnum getKolej() {
		
		return kolej;
	}
	@Override
	public OXEnum getZwyciezca() {
		
		return zwyciezca;
	}

	@Override
	public OXEnum setPole(int indeks) {
		plansza[indeks] = kolej;
		this.krok +=1;		
		if(kolej.equals(plansza[0]) && kolej.equals(plansza[4]) && kolej.equals(plansza[8])) {
			if(plansza[0].equals(plansza[4]) && plansza[8].equals(plansza[4])) {
				zwyciezca = getPole(4);
				System.out.println("w1");
			}
		}else if((kolej.equals(plansza[2]) && kolej.equals(plansza[4]) && kolej.equals(plansza[6]))){
			if(plansza[2].equals(plansza[4]) && plansza[6].equals(plansza[4])) {
				zwyciezca = getPole(4);
				System.out.println("w2");
			}
		}else if((kolej.equals(plansza[0]) && kolej.equals(plansza[1]) && kolej.equals(plansza[2]))) {
			if(plansza[0].equals(plansza[1]) && plansza[2].equals(plansza[1])) {
				zwyciezca = getPole(1);
				System.out.println("w3");
			}
		}else if((kolej.equals(plansza[3]) && kolej.equals(plansza[4]) && kolej.equals(plansza[5]))) {
			if(plansza[3].equals(plansza[4]) && plansza[5].equals(plansza[4])) {
				zwyciezca = getPole(4);
				System.out.println("w4");
			}
		}else if((kolej.equals(plansza[6]) && kolej.equals(plansza[7]) && kolej.equals(plansza[8]))) {
			if(plansza[6].equals(plansza[7]) && plansza[8].equals(plansza[7])) {
				zwyciezca = getPole(7);
				System.out.println("w5");
			}
		}else if((kolej.equals(plansza[0]) && kolej.equals(plansza[3]) && kolej.equals(plansza[6]))) {
			if(plansza[0].equals(plansza[3]) && plansza[6].equals(plansza[3])) {
				zwyciezca = getPole(3);
				System.out.println("w6");
			}
		}else if((kolej.equals(plansza[1]) && kolej.equals(plansza[4]) && kolej.equals(plansza[7]))) {
			if(plansza[1].equals(plansza[4]) && plansza[7].equals(plansza[4])) {
				zwyciezca = getPole(4);
				System.out.println("w7");
			}
		}else if((kolej.equals(plansza[2]) && kolej.equals(plansza[5]) && kolej.equals(plansza[8]))) {
			if(plansza[2].equals(plansza[5]) && plansza[8].equals(plansza[5])) {
				zwyciezca = getPole(5);
				System.out.println("w8");
			}
		}else {
			zwyciezca = OXEnum.BRAK;
		}
		
		if(kolej==OXEnum.O)
		{
			kolej=OXEnum.X;
		}else if(kolej == OXEnum.X)
		{
			kolej=OXEnum.O;
		}
		return null;
	}

	@Override
	public int getKrok() {
		return this.krok;
	}



	
}
