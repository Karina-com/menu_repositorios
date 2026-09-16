Proceso SistemaDeSalarios
	
	Definir opcion, contador Como Entero;
	Definir acumulador, mayor, menor, salario, consulta, promedio Como Real;
	
	contador <- 0;
	acumulador <- 0;
	mayor <- 0;
	menor <- 0;
	
	Repetir
		
		Escribir "";
		Escribir "===== SISTEMA DE SALARIOS =====";
		Escribir "1. Registrar salarios";
		Escribir "2. Mostrar resumen";
		Escribir "3. Comparar un salario con el promedio";
		Escribir "4. Reiniciar informacion";
		Escribir "0. Salir";
		Escribir "Elija una opcion: ";
		Leer opcion;
		
		Segun opcion Hacer
			
			1:
				Escribir "Ingrese los salarios. Un valor negativo termina el registro.";
				Escribir "Salario: ";
				Leer salario;
				Mientras salario >= 0 Hacer
					Si contador = 0 Entonces
						mayor <- salario;
						menor <- salario;
					SiNo
						Si salario > mayor Entonces
							mayor <- salario;
						FinSi
						Si salario < menor Entonces
							menor <- salario;
						FinSi
					FinSi
					acumulador <- acumulador + salario;
					contador <- contador + 1;
					Escribir "Salario: ";
					Leer salario;
				FinMientras
				Escribir "Salarios registrados: ", contador;
				
			2:
				Si contador = 0 Entonces
					Escribir "Todavia no hay salarios registrados.";
				SiNo
					promedio <- acumulador / contador;
					Escribir "Cantidad de salarios : ", contador;
					Escribir "Suma total           : ", acumulador;
					Escribir "Promedio              : ", promedio;
					Escribir "Salario mayor         : ", mayor;
					Escribir "Salario menor         : ", menor;
				FinSi
				
			3:
				Si contador = 0 Entonces
					Escribir "No se puede comparar: no hay salarios registrados.";
				SiNo
					promedio <- acumulador / contador;
					Escribir "Escriba el salario a comparar: ";
					Leer consulta;
					Si consulta > promedio Entonces
						Escribir "El salario esta por encima del promedio.";
					SiNo
						Si consulta < promedio Entonces
							Escribir "El salario esta por debajo del promedio.";
						SiNo
							Escribir "El salario es igual al promedio.";
						FinSi
					FinSi
				FinSi
				
			4:
				contador <- 0;
				acumulador <- 0;
				mayor <- 0;
				menor <- 0;
				Escribir "La informacion fue reiniciada.";
				
			0:
				Escribir "Saliendo del sistema...";
				
			De Otro Modo:
				Escribir "Opcion no valida, intente de nuevo.";
				
		FinSegun
		
	Hasta Que opcion = 0
	
FinProceso
