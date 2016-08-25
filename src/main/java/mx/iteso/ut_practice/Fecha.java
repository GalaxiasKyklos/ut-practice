package src.main.java.mx.iteso.ut_practice;

import junit.framework.ComparisonFailure;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	public String edad(String ddmmyyyy) {

		int dia, mes, anyo;

		if (ddmmyyyy.charAt(2) != '/' || ddmmyyyy.charAt(5) != '/')
			return "Formato Inválido";

		try {
			dia = Integer.parseInt(ddmmyyyy.substring(0, 2));
		} catch(Exception e) {
			return "Día Inválido";
		}
		try {
			mes = Integer.parseInt(ddmmyyyy.substring(3, 5));
		} catch(Exception e) {
			return "Mes Inválido";
		}
		try {
			anyo = Integer.parseInt(ddmmyyyy.substring(6, 10));
		} catch(Exception e) {
			return "Año Inválido";
		}

		//DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		//Date date = formatter.parse(ddmmyyyy);
		
		
		
		SimpleDateFormat hoyStr = new SimpleDateFormat("dd/MM/yyyy");
		int dias = Integer.parseInt(hoyStr.format(new Date()).substring(0, 2));
		int meses = Integer.parseInt(hoyStr.format(new Date()).substring(3, 5));
		int anyos = Integer.parseInt(hoyStr.format(new Date()).substring(6, 10)) - anyo;

		if (anyos + anyo < anyo)
			return "Esa es una Fecha Futura";
		else if (anyos + anyo == anyo && mes > meses)
			return "Esa es una Fecha Futura";
		else if (anyos + anyo == anyo && mes == meses && dias < dia)
			return "Esa es una Fecha Futura";

		if (dia < 0 || dia > 30) {
			if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12 && dia != 31)
				return "Día Inválido";
		}
		if (mes < 0 || mes > 12)
			return "Mes Inválido";

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
		
		String retorno = anyos + " años, " + meses + " meses y " + dias + " días";
		return retorno;
	}
}
