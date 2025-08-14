package calendar;
import java.time.*;

public class Library {


	public static int diasTotaisdeUmAno(int ano) //Verificando pelo ano se ele tem 365 ou 366 dias
	{
		return (ano%4==0 && ano %100!=0) || ano%400==0? 366:365; 
	}
	public static boolean verificacaoDeAnoBissexto(int ano) //Verificação booleana se é ou não bissexto
	{
		return (ano%4==0 && ano %100!=0) || ano%400==0;
	}
	
	public static int diasTotaisdoMes(int mesAtual,int ano) //verificando pelo index se o mês em questão tem 28,29,30 ou 31 dias
	{
		int diasMes[]= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		
		if(verificacaoDeAnoBissexto(ano) && mesAtual==2) //Se for bissexto, e for o mês 2 (fevereiro), vai ter acrescimo de 1 dia
		{
			return diasMes[mesAtual]+1;
		}
		else {
			return diasMes[mesAtual];
		}
		
		
	}
	
	public static int diasRestantesAteFimdoAno(int dia ,int mes,int ano) //Método pra saber quantos dias até o fim do ano
	{
		int diasAno = diasTotaisdeUmAno(ano); //365 ou 366
		
		int diasRestantes= diasTotaisdoMes(mes,ano)-dia; //dias restantes do mês baseado no dia atual, exemplo: dia 2, faltam 28 para 30
		
		
		
		//System.out.println(diasRestantes);
		for(int i=mes+1;i<=12;i++) //Começa próximo mês, vai até dezembro e soma todos dias do ano
		{	
			diasRestantes+=diasTotaisdoMes(i,ano);
			//System.out.println(i);
			//System.out.println(diasRestantes);
			
		}
		return diasRestantes; // retorna os dias totais até o final do ano
	}
	

	public static int diferencaDentroAno(int dia1 ,int mes1,int ano1,int dia2 ,int mes2,int ano2)//usar apenas para a diferença dentro de um mesmo ano
	{
		int diasrestantesDia1 = diasRestantesAteFimdoAno(dia1, mes1, ano1);
		int diasrestantesDia2 = diasRestantesAteFimdoAno(dia2, mes2, ano2);
		int resultado=0;
		
		
		resultado= diasrestantesDia1 - diasrestantesDia2;
		
		//System.out.println(resultado);
		
		return resultado;
		
	}
	

	public static void diferenceBetwenDays(int targetDay,int targetMonth, int targetYear)
	{
		LocalDate dateUser = LocalDate.now(); //pega a data do pc do usuario no formato yyyy/mm/dd
		
		int diaBase= dateUser.getDayOfMonth(); int diaMeta=targetDay;
		int mesBase= dateUser.getMonthValue(); int mesMeta=targetMonth;
		int anoBase= dateUser.getYear(); int anoMeta= targetYear;
		
		int diasRestantes=0;
	
		if(anoBase<=anoMeta) 
		{
			diasRestantes += diasRestantesAteFimdoAno(diaBase, mesBase, anoBase);
			
			if(anoBase!=anoMeta)
			{
				//System.out.println("Debug");
				//System.out.println(diasRestantes);
				
				for(int i=anoBase+1;i<anoMeta;i++)
				{
					
					diasRestantes+= diasTotaisdeUmAno(i);
					
				}
				
				diasRestantes+= (diasTotaisdeUmAno(anoMeta)-diasRestantesAteFimdoAno(diaMeta, mesMeta, anoMeta));
			}
			else
			{
				//System.out.println("Debug 2");
				diasRestantes = diferencaDentroAno(diaBase, mesBase, anoBase, diaMeta, mesMeta, anoMeta);
			}
			
		}else //ano base>ano meta
		{
			diasRestantes += (diasTotaisdeUmAno(anoBase)-diasRestantesAteFimdoAno(diaBase, mesBase, anoBase)); //percorrido
			
			for(int i=anoBase-1;i>anoMeta;i--)
			{
				
				diasRestantes+= diasTotaisdeUmAno(i);
				
			}
			
			diasRestantes += diasRestantesAteFimdoAno(diaMeta, mesMeta, anoMeta);
			
			diasRestantes=diasRestantes*-1;
			
			//System.out.println(diasRestantes);
		}
		
		
		
		
		
		guessWeek(diasRestantes, diaBase, mesBase, anoBase, diaMeta, mesMeta, anoMeta);
		
	}
	
	public static void guessWeek(int diference,int diaAtual,int mesAtual,int anoAtual, int diaMeta,int mesMeta,int anoMeta)
	{
		LocalDate dateUser = LocalDate.now();
		String semanaDiaUser = " ";
		String semanaDiaTarget = " ";
		DayOfWeek weekDayUser = dateUser.getDayOfWeek();

		//System.out.println(diference);
		int resto = diference%7;
		
		DayOfWeek weekDayTarget = weekDayUser.plus(resto);
		
		switch (weekDayUser)
		{
		case MONDAY:
			semanaDiaUser = "Segunda feira";
			break;
			
		case TUESDAY:
			semanaDiaUser = "Terça feira";
			break;
			
		case WEDNESDAY:
			semanaDiaUser = "Quarta feira";
			break;
			
		case THURSDAY:
			semanaDiaUser = "Quinta feira";
			break;
			
		case FRIDAY:
			semanaDiaUser = "Sexta feira";
			break;
			
		case SATURDAY:
			semanaDiaUser = "Sábado";
			break;
			
		case SUNDAY:
			semanaDiaUser = "Domingo";
			break;
			default:
				semanaDiaUser="erro";
				break;
		}
		
		switch (weekDayTarget)
		{
		case MONDAY:
			semanaDiaTarget = "Segunda feira";
			break;
			
		case TUESDAY:
			semanaDiaTarget = "Terça feira";
			break;
			
		case WEDNESDAY:
			semanaDiaTarget = "Quarta feira";
			break;
			
		case THURSDAY:
			semanaDiaTarget = "Quinta feira";
			break;
			
		case FRIDAY:
			semanaDiaTarget = "Sexta feira";
			break;
			
		case SATURDAY:
			semanaDiaTarget= "Sábado";
			break;
			
		case SUNDAY:
			semanaDiaTarget = "Domingo";
			break;
			default:
				semanaDiaTarget="erro";
				break;
		}
		
		
		
		if(diference<0) //saída texto
		{
			System.out.printf("%d/%d/%d - %s\n",diaMeta,mesMeta,anoMeta,semanaDiaTarget);
		}
		else
		{
			System.out.printf("%d/%d/%d - %s\n",diaMeta,mesMeta,anoMeta,semanaDiaTarget);
		}
			
			
	}
	
}

