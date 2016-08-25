package src.main.java.mx.iteso.ut_practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public String edad(String ddmmyyyy) {
		
		
		
		int dia = Integer.parseInt(ddmmyyyy.substring(0, 1));
		int mes = Integer.parseInt(ddmmyyyy.substring(3, 4));
		int anyo = Integer.parseInt(ddmmyyyy.substring(6, 9));
		
		//DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		//Date date = formatter.parse(ddmmyyyy);
		
		
		
		SimpleDateFormat hoyStr = new SimpleDateFormat("dd/mm/yyyy");
		hoyStr.format(new Date());
		
		int dias = Integer.parseInt(hoyStr.toString().substring(0, 1));
		int meses = Integer.parseInt(hoyStr.toString().substring(3, 4));
		int anyos = Integer.parseInt(hoyStr.toString().substring(6, 9)) - anyo;
		
		int mesAct = meses;
		
		if (meses < mes) {
			anyos--;
			meses = 12 - mes + meses;
			if (dias < dia) {
				meses--;
				switch (mesAct) {
				case 1:
					dias = 31 - dias + dia;
					break;
				case 2:
					dias = 31 - dias + dia;
					break;
				case 3:
					dias = 28 - dias + dia;
					if ((anyos+1+anyo%4==0 && anyos+1+anyo%100!=0) || anyos+1+anyo%400==0)
						dias++;
					break;
				case 4:
					dias = 31 - dias + dia;
					break;
				case 5:
					dias = 30 - dias + dia;
					break;
				case 6:
					dias = 31 - dias + dia;
					break;
				case 7:
					dias = 30 - dias + dia;
					break;
				case 8:
					dias = 31 - dias + dia;
					break;
				case 9:
					dias = 31 - dias + dia;
					break;
				case 10:
					dias = 30 - dias + dia;
					break;
				case 11:
					dias = 31 - dias + dia;
					break;
				case 12:
					dias = 30 - dias + dia;
					break;
				}
			} else if (dias > dia) {
				dias = dias - dia;
			} else if (dias == dia)
				dias = 0;
		} else if (meses == mes && dias < dia)
			anyos--;
		
		String retorno = anyos + " años, " + meses + " meses y " + dias + " dias";
		return retorno;
	}
}
