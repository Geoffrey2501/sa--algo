/**
 * Classe ListeTriee
 * @author Étienne André
 * @since 2021-11-12
 *
 */



public class ListeTriee{

    // Attribut de liste sous-jacente
    private Liste liste;
    
    public ListeTriee(Liste listevide){
	// Affectation de la liste vide à l'attribut privé
	    this.liste = listevide;
    }
    
    /**
     * retourne la premiere place de la liste
     * @return tete de liste
     */
    public int tete(){
	//A COMPLETER
	    return this.liste.tete();
    }
	
    /**
     * permet de connaitre la place suivante dans la liste
     * @param p place en cours
     * @return place derriere p dans la liste
     */
    public int suc(int p){
	//A COMPLETER
        return p+1;
    }
    
    /**
     * retourne la valeur associee a la place p
     * @param p place de la liste
     * @return la valeur associee  p
     */
    public String val(int p){
	//A COMPLETER
        return this.liste.val(p);
    }
 
    /**
     * indique si la place p est a la fin de la liste ou non
     * @param p place de la liste
     * @return vrai si p est a la fin de la liste, faux sinon
     */   
    public boolean finliste(int p){
	//A COMPLETER
        return this.liste.finliste(p);
    }
	
    
    /**
     * ajoute un element au bon endroit dans la liste triee
     * @param chaine element a inserer
     */
    public void adjlisT(String chaine){
	//A COMPLETER
        int p = this.tete();
        if(this.liste.finliste(p)) {this.liste.adjtlis(chaine);}
        else if(chaine.compareTo(this.liste.val(p))<0) {
            this.liste.adjtlis(chaine);
        }
        else{
            int x=p;
            boolean mit=false;
            while(!this.finliste(p) && !mit){
                
            if (chaine.compareTo(this.liste.val(p))<0){
                    mit=true;
                    this.liste.adjlis(x, chaine);
                }
            else{    
                x=p;
                p=this.liste.suc(p);
            }
            }
            if(!mit)this.liste.adjlis(x, chaine);
        }
    }
	
    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    public void suplisT(String chaine){
	//A COMPLETER
        int p=this.tete();
        boolean present=false;
        while(!this.finliste(p) && !present && this.liste.val(p)!=null){
          present=this.liste.val(p).compareTo(chaine)==0;
          p=this.suc(p);
        }
        if(!this.finliste(p))if(present)this.liste.suplis(p);
    }
		
    public String toString(){
	return liste.toString();
    }
}
