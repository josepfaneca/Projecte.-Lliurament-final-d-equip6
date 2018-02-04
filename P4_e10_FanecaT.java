
import java.util.Scanner;

public class P4_e10_FanecaT {
// Declaració de constants

    public static final int CONTINUA = 1, NO_CONTINUA = 0;
    public static final int ORDENAR = 1, NO_ORDENAR = 0;
    public static final int INTENTS = 3, ID_MIN = 1, ID_MAX = 2000;
    public static final int ANY_MIN = 1999, ANY_MAX = 2009;
    public static final int GEN_MIN = 1, GEN_MAX = 2;
    public static final int CAT_MIN = 1, CAT_MAX = 4;
    public static final int CLUB_MIN = 1, CLUB_MAX = 6;
    public static final int PUNTS_MIN = 10, PUNTS_MAX = 50;
    public static final int COLUMNS = 6, MAX_INSCRITS = 10;
    private static final String CLUB_BAR = "Barcelona ";
    private static final String CLUB_SAB = "Sabadell  ";
    private static final String CLUB_HOSP = "Hospitalet";
    private static final String CLUB_CORN = "Cornellà  ";
    private static final String CLUB_VIC = "Vic       ";
    private static final String CLUB_AME = "America   ";
    private static final String CAT_BEN = "Benjamí ";
    private static final String CAT_ALE = "Aleví   ";
    private static final String CAT_INF = "Infantil";
    private static final String CAT_JUV = "Juvenil ";
    private static final String GEN_FEM = "Noia";
    private static final String GEN_MASC = "Noi ";
    private static final String TOTAL_INSCRITS = "\nEl nombre total d'inscrits és: ",
            CATEGORIES = "\nCategories: \n\t (1) Benjamí \n\t (2) Aleví \n\t (3) Infantil \n\t (4) Juvenil \nIntrodueix una categoria: ",
            CLUBS = "\nClubs: \n\t (1) Barcelona \n\t (2) Sabadell \n\t (3) Hospitalet \n\t (4) Cornella\n\t (5) Vic \n\t (6) America \nClub: ",
            TAULA = "\nid. \tAny n. \tGènere\tCategoria\tClub    \tPuntuació",
            INSCRITS_CLUB = "\n\nVols veure els inscrits per club? [0:No - 1:Si]: ",
            NOU_PARTICIPANT = "\n\nVols Continuar introduint participants? [0:No - 1:Si]: ",
            ORDENA_DADES = "\n\nVols les dades endreçades per puntuació? [0:No - 1:Si]: ";

    public static void main(String[] args) {
        //Iniciem i declarem variables
        int[] arrayClubs = new int[MAX_INSCRITS];
        int[][] clubNatacio = new int[MAX_INSCRITS][COLUMNS];
        int llistaInscrits = 0, control = 0, nouParticipant = 0, inscrit = 0, columna = 0, mostraClub = 0;
        String categ = "", nomClub = "", genereText = "";
        boolean dadaCorrecte, ordenaArray = false;

        // Iniciem el lector de dades per pantalla i/o teclat
        Scanner lector = new Scanner(System.in);

        // Es presenten i demanen les primeres dades.
        System.out.println("Entrada de dades del participant. \n");

        do {                                 //Bucle de control de participants.

            do {                              //Bucle de control de dades (intents).

                System.out.print("Identificació: ");
                // Asignem valor boolea per verificar que la dade entrada es correcte.
                dadaCorrecte = lector.hasNextInt();
                /* Identifiquem que el valor entrat es troba dins el rang admisible (3 intents),
		si l'identificació es correcte demana mes dades, si no, surt i acaba.*/
                if (dadaCorrecte) {
                    clubNatacio[inscrit][columna] = lector.nextInt();	//"inscrit" no només reflecteix la posició del valor entrat
                    //sino el nombre de participants introduits.
                    if ((clubNatacio[inscrit][columna] < ID_MIN) || (clubNatacio[inscrit][columna] > ID_MAX)) {
                        dadaCorrecte = false;			//Si la dada es troba fora del rang permés es incorrecte.
                    }
                } else {
                    lector.next();					// Es controla l'itroducció d'espais en blanc a les dades.
                }
                if (!dadaCorrecte) {				//Si la dada es incorrecte: alfanumèric o fora de rang, avisem amb control d'error.
                    control++;
                    System.out.print("\nERROR: Identificacio incorrecte!!!.\nEt resten " + (INTENTS - control) + " intents. ");
                }
                lector.nextLine();				//Es buida el buffer i es prepara per tornar a usar.
                /* Mentre la dada sigui incorrecte i els intents siguin dins el rang, es repeteix el bucle.*/
            } while (!dadaCorrecte && control < INTENTS);

            control = 0;
            /* Torna a zero el comptador, d'aquesta manera es prepara per una possible continuació del programa*/
 /* Si la darrere dada entrada es correcte, es pot continuar amb l'execcució del programa */
            if (dadaCorrecte) {
                columna++;						//Canvi de columna o columna.
                //S'inicia un nou cicle de tres intents.
                do {

                    System.out.print("Any de naixement: ");
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        clubNatacio[inscrit][columna] = lector.nextInt();
                        if ((clubNatacio[inscrit][columna] < ANY_MIN) || (clubNatacio[inscrit][columna] > ANY_MAX)) {
                            dadaCorrecte = false;
                        }
                    } else {
                        lector.next();
                    }
                    if (!dadaCorrecte) {
                        control++;
                        System.out.println("\nERROR: Any incorrecte!!!. \nEt resten " + (INTENTS - control) + " intents.\n");
                    }
                    lector.nextLine();
                } while (!dadaCorrecte && control < INTENTS);
                control = 0;
            }

            if (dadaCorrecte) {
                columna++;
                do {
                    control++;
                    System.out.print("Selecció de génere:  Noia (1) - Noi (2): ");
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        clubNatacio[inscrit][columna] = lector.nextInt();
                        //Selecció d'opció segons el valor de la dada introduïda.
                        if ((clubNatacio[inscrit][columna] < GEN_MIN) || (clubNatacio[inscrit][columna] > GEN_MAX)) {
                            dadaCorrecte = false;
                        }

                    } else {
                        lector.next();
                    }
                    if (!dadaCorrecte) {
                        System.out.println("\nERROR: Genere incorrecte!!!. \nEt resten " + (INTENTS - control) + " intents.\n");
                    }
                    lector.nextLine();
                } while (!dadaCorrecte && control < INTENTS);
                control = 0;
            }

            if (dadaCorrecte) {
                columna++;
                // Presentem el menu per triar dins les categories.
                do {
                    control++;
                    System.out.print(CATEGORIES);
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        clubNatacio[inscrit][columna] = lector.nextInt();
                        /* Tria de totes las opcions la correcte i guarda en una variable, la correspondent a la categoria introduida en tipo text */
                        if ((clubNatacio[inscrit][columna] < CAT_MIN) || (clubNatacio[inscrit][columna] > CAT_MAX)) {
                            dadaCorrecte = false;
                        }

                    } else {
                        lector.next();
                    }

                    if (!dadaCorrecte) {
                        System.out.println("\nERROR: Categoria incorrecte!!!. \nEt resten " + (INTENTS - control) + " intents.");
                    }

                    lector.nextLine();
                } while (!dadaCorrecte && control < INTENTS);
                control = 0;
            }

            if (dadaCorrecte) {
                columna++;
                // Presentem el menu per triar el club pertinent dins la categoria.
                do {
                    control++;
                    System.out.print(CLUBS);
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        clubNatacio[inscrit][columna] = lector.nextInt();
                        if ((clubNatacio[inscrit][columna] < CLUB_MIN) || (clubNatacio[inscrit][columna] > CLUB_MAX)) {
                            dadaCorrecte = false;
                        }

                    } else {
                        lector.next();
                    }
                    if (!dadaCorrecte) {
                        System.out.println("\nERROR: Club incorrecte!!!. \nEt resten " + (INTENTS - control) + " intents.");
                    }
                    lector.nextLine();
                } while (!dadaCorrecte && control < INTENTS);
                control = 0;
            }

            if (dadaCorrecte) {
                columna++;
                do {
                    control++;
                    System.out.print("\nPuntuació: ");
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        clubNatacio[inscrit][columna] = lector.nextInt();
                        if ((clubNatacio[inscrit][columna] < PUNTS_MIN) || (clubNatacio[inscrit][columna] > PUNTS_MAX)) {
                            dadaCorrecte = false;			// Si la dada es de tipus sencer i no está dins el rang, no es correcta.
                        }
                    } else {
                        lector.next();
                    }
                    if (!dadaCorrecte) {
                        System.out.println("\nERROR: Puntuació incorrecte!!!. \nEt resten " + (INTENTS - control) + " intents.");
                    }
                    lector.nextLine();
                } while (!dadaCorrecte && control < INTENTS);
                control = 0;
            }
            columna = 0;
            if (dadaCorrecte) {					//Si totes les dades entrades son correctes, es pot comptar 
                inscrit++;						//el participant, per tant s'incrementa el comptador de participants.
            }

            if (inscrit < MAX_INSCRITS) {			//Control d'array: es vigila que no es superi la llargaria de l'array.

                do {							//Es demana si es vol introduir un altre participant.
                    System.out.print(NOU_PARTICIPANT);
                    dadaCorrecte = lector.hasNextInt();
                    if (dadaCorrecte) {
                        /* Si el valor entrat es correspon amb els valors permesos, es valida i s'assigna a una varable */
                        nouParticipant = lector.nextInt();
                        if ((nouParticipant < NO_CONTINUA) || (nouParticipant > CONTINUA)) {
                            dadaCorrecte = false;		// Si la dada no ès correcte, no es pot sortir del bucle.
                        }
                    }
                    if (!dadaCorrecte) {
                        System.out.println("Has entrat un valor no vàlid!!!.\n");
                        lector.nextLine();
                    }
                } while (!dadaCorrecte);

            } else {							//Si s'introdueixen 10 participants s'atura l'execució.
                nouParticipant = NO_CONTINUA;
            }

        } while (nouParticipant == CONTINUA);
        /* Si s'ha decidit no continuar, es mostra per pantalla el total d'inscrits, en cas contrari s'inicia un nou bucle. */

        //A partir de aqui inscrit ès tambè variable control, això permet controlar missatges per pantalla.
        if (inscrit > 0) {					//Si cap entrada d'inscrit ha estat bona no es mostra la taula. 
            //Es mostren per pantalla els participants.
            System.out.println("\n********* Participants inscrits *********");
            //Es tria el text acord a la selecció numèrica (casos: Genere, Categoria i Club).
            do {							//Aquest bucle garanteix l'execució com a màxim dues vegades.
                System.out.println(TAULA);

                for (int i = 0; i < inscrit; i++) {		//Zona algorisme bombolla. És l'usuari qui activa l'execució del algorisme.
                    if (ordenaArray) {				//"ordenaArray" comença amb false per garantir que la primera execució no modifica l'array.
                        llistaInscrits = NO_ORDENAR;		//Modifica la condició del bucle do-while per garantir-ne la sortida.
                        for (int j = i + 1; j < inscrit; j++) {
                            if (clubNatacio[i][5] > clubNatacio[j][5]) {	//S'inicia la comparació de jerarquia per punts.
                                int[] auxArray = clubNatacio[i]; //Si el valor actual es major que el guardat, es modifica l'índex del array.
                                clubNatacio[i] = clubNatacio[j];
                                clubNatacio[j] = auxArray;
                            }
                        }
                    }
                    //Per poder mostrar per pantalla les dades, primer s'ha de seleccionar el text adient.

                    switch (clubNatacio[i][2]) {
                        case 1:
                            genereText = GEN_FEM;
                            break;

                        case 2:
                            genereText = GEN_MASC;
                            break;
                        default:
                    }

                    switch (clubNatacio[i][3]) {
                        case 1:
                            categ = CAT_BEN;
                            break;

                        case 2:
                            categ = CAT_ALE;
                            break;

                        case 3:
                            categ = CAT_INF;
                            break;

                        case 4:
                            categ = CAT_JUV;
                            break;
                        default:
                    }

                    switch (clubNatacio[i][4]) { //aprofito la primera passada per emmagatzemar 
                        //quants participants té cada equip.
                        case 1:
                            nomClub = CLUB_BAR;
                            if (!ordenaArray) {
                                arrayClubs[1]++;
                            }
                            break;
                        case 2:
                            nomClub = CLUB_SAB;
                            if (!ordenaArray) {
                                arrayClubs[2]++;
                            }
                            break;
                        case 3:
                            nomClub = CLUB_HOSP;
                            if (!ordenaArray) {
                                arrayClubs[3]++;
                            }
                            break;
                        case 4:
                            nomClub = CLUB_CORN;
                            if (!ordenaArray) {
                                arrayClubs[4]++;
                            }
                            break;
                        case 5:
                            nomClub = CLUB_VIC;
                            if (!ordenaArray) {
                                arrayClubs[5]++;
                            }
                            break;
                        case 6:
                            nomClub = CLUB_AME;
                            if (!ordenaArray) {
                                arrayClubs[6]++;
                            }
                            break;
                        default:
                    }
                    System.out.println();

                    for (int k = 0; k < clubNatacio[i].length; k++) {   //Selecció de text i impresió de taula.
                        if (k >= 2 && k <= 4) {
                            switch (k) {
                                case 2:
                                    System.out.print(genereText + "\t");
                                    break;
                                case 3:
                                    System.out.print(categ + "\t");
                                    break;
                                case 4:
                                    System.out.print(nomClub + "\t");
                                    break;
                                default:
                            }
                        } else {
                            System.out.print(clubNatacio[i][k] + " \t");
                        }
                    }
                }
                if (!ordenaArray) {
                    System.out.println("\n" + TOTAL_INSCRITS + inscrit);
                    if (inscrit >= MAX_INSCRITS) {
                        System.out.println("S'ha arribat al màxim permès d'inscrits!!!");
                    }

                    //Es pregunta si es vol endreçar les dades entrades.
                    do {
                        System.out.print(ORDENA_DADES);
                        dadaCorrecte = lector.hasNextInt();
                        if (dadaCorrecte) {
                            llistaInscrits = lector.nextInt();
                            if ((llistaInscrits < NO_ORDENAR) || (llistaInscrits > ORDENAR)) {
                                dadaCorrecte = false;		// Si la dada no ès correcta, no es pot sortir del bucle.
                            }
                        }
                        if (!dadaCorrecte) {
                            System.out.println("Has entrat un valor no vàlid!!!.\n");
                            lector.nextLine();
                        }
                    } while (!dadaCorrecte);

                }
                if (ordenaArray || llistaInscrits == NO_ORDENAR) {	//Només si s'ha executat el segon bucle o si l'usuari ha triat no ordenar
                    do {							// per punts, es demana si es vol introduir un altre participant.
                        System.out.print(INSCRITS_CLUB);
                        dadaCorrecte = lector.hasNextInt();
                        if (dadaCorrecte) {
                            mostraClub = lector.nextInt();
                            if ((mostraClub < NO_CONTINUA) || (mostraClub > CONTINUA)) {
                                dadaCorrecte = false;			// Si la dada no ès correcte, no es pot sortir del bucle.
                            }
                        }
                        if (!dadaCorrecte) {
                            System.out.println("Has entrat un valor no vàlid!!!.\n");
                            lector.nextLine();
                        }
                    } while (!dadaCorrecte);
                }

                ordenaArray = true;				//Instrucció tipus semàfor, obre la resta del algorisme bombolla només a la segona execució.

            } while (llistaInscrits == ORDENAR);		//Aquesta condició es valida al primer bucle, el segon bucle la modifica i surt.

            if (mostraClub == CONTINUA) {
                System.out.print("\n\n********* Participants per cicle *********");
                for (int n = 0; n < arrayClubs.length; n++) {
                    switch (n) {
                        case 1:
                            System.out.print("\n\nBarcelona:  " + arrayClubs[n]);
                            break;
                        case 2:
                            System.out.print("\nSabadell:   " + arrayClubs[n]);
                            break;
                        case 3:
                            System.out.print("\nHospitalet: " + arrayClubs[n]);
                            break;
                        case 4:
                            System.out.print("\nCornella:   " + arrayClubs[n]);
                            break;
                        case 5:
                            System.out.print("\nVic:        " + arrayClubs[n]);
                            break;
                        case 6:
                            System.out.print("\nAmerica:    " + arrayClubs[n]);
                            break;
                        default:
                    }
                }
            }
            System.out.println();
        }
    }
}
