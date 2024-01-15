/**
 * Classe principale de la SAÉ
 * @author Étienne André Sergueï Lenglet
 * @since 2021-11-04
 *
 */


public class Principale{

    private static final String[] ELEMENTS_DE_DEBUT
	= {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
	"BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN
	= {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
	"TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};
    
    // NOTE: pour fichier 10 000
    // 	private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    // "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    // = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    // "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_FIN_SUPPR
    //= {"WEBER", "WEISS", "WINTERSTEIN", "WOLFF", "YANG",
    //"YILDIRIM", "YILDIZ", "YILMAZ", "ZIEGLER", "ZIMMERMANN"}; //
	
    // Type des listes, peut etre utile pour factoriser les tests
    private static final int CONTIGUE	       = 1;
    private static final int CHAINEE	       = 2;
    private static final int CHAINEE_PLIBRES   = 3;
	
    // Exemple d'utilisation de LectureFichier et remplissage d'une liste
    public static void remplir_liste(ListeTriee liste, String nom_fichier){
	LectureFichier lf = new LectureFichier(nom_fichier);
	// 		
	String[] liste_noms = lf.lireFichier();
	for (int i = 0; i < liste_noms.length; i++) {
	    liste.adjlisT(liste_noms[i]);
	}
    }


	
    public static void main(String [] args){
	/*System.out.println("Bienvenue !");

	//Exemple d'utilisation de la classe EcritureFichier
	EcritureFichier fichier = new EcritureFichier("resultats.csv");
	fichier.ouvrirFichier();
	fichier.ecrireLigne("liste;operation;emplacement;duree");
	fichier.fermerFichier();*/

    ListeTriee lCh= new ListeTriee(new ListeChainee(10000));
    ListeTriee lChP= new ListeTriee(new ListeChaineePlacesLibres(10000));
    ListeTriee lCo= new ListeTriee(new ListeContigue(10000));
    LectureFichier lf = new LectureFichier("noms100.txt");

    //remplissage
    
	// 		
	String[] liste_noms = lf.lireFichier();
    
    //cas 1
    long date_debut = System.nanoTime();
	for (int i = 0; i < 10; i++) {
	   lCh.adjlisT(liste_noms[i]);
	}
    long date_fin = System.nanoTime(); 
    long duree = date_fin - date_debut;

    //cas 2
    long date_debut2 = System.nanoTime();
    for (int i = 0; i < 10; i++) {
        lChP.adjlisT(liste_noms[i]);
    }
    long date_fin2 = System.nanoTime(); 
    long duree2 = date_fin2 - date_debut2;


    //cas 3
    long date_debut3 = System.nanoTime();
    for (int i = 0; i < 10; i++) {
        lCo.adjlisT(liste_noms[i]);
    }
    long date_fin3 = System.nanoTime(); 
    long duree3 = date_fin3 - date_debut3;


    System.out.println("cas 1");
    System.out.println(duree);

    System.out.println("cas 2");
    System.out.println(duree2);

    System.out.println("cas 3");
    System.out.println(duree3);



    //cas 1
    date_debut = System.nanoTime();
	for (int i = liste_noms.length-11; i < liste_noms.length; i++) {
	   lCh.adjlisT(liste_noms[i]);
	}
    date_fin = System.nanoTime(); 
    duree = date_fin - date_debut;

    //cas 2
    date_debut2 = System.nanoTime();
    for (int i = liste_noms.length-11; i < liste_noms.length; i++) {
        lChP.adjlisT(liste_noms[i]);
    }
    date_fin2 = System.nanoTime(); 
    duree2 = date_fin2 - date_debut2;


    //cas 3
     date_debut3 = System.nanoTime();
    for (int i = liste_noms.length-11; i <liste_noms.length ; i++) {
        lCo.adjlisT(liste_noms[i]);
    }
    date_fin3 = System.nanoTime(); 
    duree3 = date_fin3 - date_debut3;

    System.out.println("cas 1");
    System.out.println(duree);

    System.out.println("cas 2");
    System.out.println(duree2);

    System.out.println("cas 3");
    System.out.println(duree3);


    //cas 1
    date_debut = System.nanoTime();        
    for (int i = 0; i < 10; i++) {
        lCh.suplisT(liste_noms[i]);
    }
    date_fin = System.nanoTime(); 
    duree = date_fin - date_debut;
    
        //cas 2
    date_debut2 = System.nanoTime();
    for (int i = 0; i < 10; i++) {
        lChP.suplisT(liste_noms[i]);
    }
    date_fin2 = System.nanoTime(); 
    duree2 = date_fin2 - date_debut2;
    
    
    //cas 3
    date_debut3 = System.nanoTime();
    for (int i = 0; i < 10; i++) {
        lCo.suplisT(liste_noms[i]);
    }
    date_fin3 = System.nanoTime(); 
    duree3 = date_fin3 - date_debut3;
    
    
        System.out.println("cas 1");
        System.out.println(duree);
    
        System.out.println("cas 2");
        System.out.println(duree2);
    
        System.out.println("cas 3");
        System.out.println(duree3);


    //cas 1
    date_debut = System.nanoTime();        
    for (int i = liste_noms.length-11; i < liste_noms.length; i++) {
        lCh.suplisT(liste_noms[i]);
    }
    date_fin = System.nanoTime(); 
    duree = date_fin - date_debut;
    
        //cas 2
    date_debut2 = System.nanoTime();
    for (int i = liste_noms.length-11; i < liste_noms.length; i++) {
        lChP.suplisT(liste_noms[i]);
    }
    date_fin2 = System.nanoTime(); 
    duree2 = date_fin2 - date_debut2;
    
    
    //cas 3
    date_debut3 = System.nanoTime();
    for (int i = liste_noms.length-11; i < liste_noms.length; i++) {
        lCo.suplisT(liste_noms[i]);
    }
    date_fin3 = System.nanoTime(); 
    duree3 = date_fin3 - date_debut3;
    
    
        System.out.println("cas 1");
        System.out.println(duree);
    
        System.out.println("cas 2");
        System.out.println(duree2);
    
        System.out.println("cas 3");
        System.out.println(duree3);


        
    }


}
