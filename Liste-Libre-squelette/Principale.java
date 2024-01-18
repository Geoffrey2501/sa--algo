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
    private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
    "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    // NOTE: pour fichier 1 000
    //private static final String[] ELEMENTS_DE_DEBUT_SUPPR
    // = {"ABADIE", "ABDALLAH", "ABRAHAM", "ADAM", "AFONSO",
    // "ALBERT", "ALEXANDRE", "ALI", "ALIX", "ALLAIN"};
    // NOTE: pour fichier 10 000
    private static final String[] ELEMENTS_DE_FIN_SUPPR
     = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
    "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"}; //
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


    public static int testChrono(int type, char c, char s){
        LectureFichier lf = new LectureFichier("noms10000.txt");
        String[] liste_noms = lf.lireFichier();
        ListeTriee l;
        int nbPlace=10000;
        int sum=0;
        if(c=='a' || type==1)nbPlace+=1000;
        

        for(int i=0; i<100; i++){
        if(type==1)l=new ListeTriee(new ListeContigue(nbPlace));
        else if(type==2)l=new ListeTriee(new ListeChainee(nbPlace));
        else l=new ListeTriee(new ListeChaineePlacesLibres(nbPlace));
        

        for(int r=0;r<10000;r++)l.adjlisT(liste_noms[r]);
            long date_debut = System.nanoTime(); 
            for(int j=0; j<10;j++){
                if (c=='a') {
                    if(s=='d')l.adjlisT(ELEMENTS_DE_DEBUT[j]);
                    else l.adjlisT(ELEMENTS_DE_FIN[j]);
                }
                else{ 
                    if(s=='d')l.suplisT(ELEMENTS_DE_DEBUT_SUPPR[j]); 
                    else l.suplisT(ELEMENTS_DE_FIN_SUPPR[j]);
            }
            }
            
            long date_fin = System.nanoTime();
            sum+=date_fin-date_debut;
        }
        return sum/100;
    }


	
    public static void main(String [] args){
	System.out.println("Bienvenue !");

	//Exemple d'utilisation de la classe EcritureFichier
	//EcritureFichier fichier = new EcritureFichier("resultats.csv");
	//fichier.ouvrirFichier();
	//fichier.ecrireLigne("liste;operation;emplacement;duree");
	

    ListeTriee lCh= new ListeTriee(new ListeChainee(10000));
    ListeTriee lChP= new ListeTriee(new ListeChaineePlacesLibres(10000));
    ListeTriee lCo= new ListeTriee(new ListeContigue(10000));
    
    //remplissage

    //remplissage (vrai)
    EcritureFichier fichier = new EcritureFichier("resultats.csv");
    fichier.ouvrirFichier();
    for(int i=0; i<3; i++){
        for(int j=0; j<4; j++){
            String li="";
            String operation;
            String emplacement;
            char c;
            char s;
            switch(i){
                case 0 : li="contigue";
                break;
                case 1 : li="chainee";
                break;
                case 2 : li="chaineePlaceLibre";
                break;
            }
            if(j==0 || j==1){
                operation="ajouter";
                c='a';
            }else{
                operation="supprimer";
                c='s';
            }
            if(j==0 || j==2){
                emplacement="debut";
                s='d';
            }else{
                emplacement="fin";
                s='f';
            }
            fichier.ecrireLigne(li+";"+operation+";"+emplacement+";"+Integer.toString(testChrono(j, 'c', 's')));;

        }
    }
    fichier.fermerFichier();
    }


}
