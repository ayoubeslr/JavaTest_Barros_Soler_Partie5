package tec;

public abstract class PassagerAbstrait implements Usager, Passager{

	private String nom;
	protected int destination;
	protected EtatPassager etat;
	
	public PassagerAbstrait(String nom, int destination) throws IllegalArgumentException{
		if(destination <= 0 ) {
			throw new IllegalArgumentException("Votre destination doit �tre sup�rieure � 0");
		}
		this.nom = nom;
		this.destination = destination;
		this.etat = new EtatPassager(EtatPassager.Etat.DEHORS);
	}
	
	
	/**
	   * Retourne vrai si l'etat du passager est ex�rieur
	   * @return vrai si l'etat  du passager est Dehors
	   */
	@Override
	public boolean estDehors() {
		return (this.etat.estExterieur()); 
	}

	/**
	   * Retourne vrai si l'etat du passager est assis
	   * @return vrai si l'etat  du passager est assis
	   */
	@Override
	public boolean estAssis() {
		return (this.etat.estAssis());
	}

	/**
	   * Retourne vrai si  l'etat du passager est Debout
	   * @return vrai si l'etat  du passager est Debout
	   */
	@Override
	public boolean estDebout() {
		return (this.etat.estDebout());
	}



	/**
	   * Change l'�tat du passager en dehors
	   * Le passager est dehors
	   */
	@Override
	public void accepterSortie() throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEHORS) {
			throw new IllegalStateException("Ce passager est d�j� dehors!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEHORS;
		
	}

	/**
	   * Change l'�tat du passager en assis
	   * Le passager est assis dans le bus
	   */
	@Override
	public void accepterPlaceAssise() throws IllegalStateException {
		if(this.etat.monEtat == EtatPassager.Etat.ASSIS) {
			throw new IllegalStateException("Ce passager est d�j� assis!");
		}
		this.etat.monEtat = EtatPassager.Etat.ASSIS;
		
	}

	/**
	   * Change l'�tat du passager en debout
	   * Le passager est debout dans le bus
	   */
	@Override
	public void accepterPlaceDebout()  throws IllegalStateException{
		if(this.etat.monEtat == EtatPassager.Etat.DEBOUT) {
			throw new IllegalStateException("Ce passager est d�j� debout!");
		}
		this.etat.monEtat = EtatPassager.Etat.DEBOUT;
		
	}

	public int getDest() {
		return this.destination;
	}

	/**
	   * Retourne le nom du passager
	   * @return nom
	   */
	@Override
	public String nom() {
		return this.nom;
	}
	
	
	
	@Override
	  public String toString() {
	    return this.nom + " " + this.etat.monEtat;
	  }


	@Override
	public abstract void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException;

	@Override
	public abstract void monterDans(Bus serenity) throws UsagerInvalideException;

}
