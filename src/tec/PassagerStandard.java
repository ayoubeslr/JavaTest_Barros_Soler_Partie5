package tec;

import tec.EtatPassager.Etat;
/**
 * Cette class impl�mente les methodes de Usager et Passager pour g�rer l'etat d'un passager
 * Elle instancie un passager avec un non, une destination et un etat
 * 
 * @author Soler Ayoube
 *
 */

public class PassagerStandard extends PassagerAbstrait{

	public PassagerStandard(String nom, int destination) throws IllegalArgumentException {
		super(nom, destination);
	}
	
	public PassagerStandard(int destination) throws IllegalArgumentException {
		super("PassagerStandard"+destination, destination);
	}


	/**
	   * Indique au passager qu'il est arriv� � un nouvel arr�t. Cette methode
	   * fixe le comportement (changer de place ou sortir). 
	   * Cette m�thode est appel�e par Bus.
	   *
	   * @param bus le bus dans lequel se trouve le passager.
	   * @param numeroArret numero de l'arr�t.
	   */
	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
		if(this.destination < numeroArret) {
			throw new UsagerInvalideException("L'arret de ce passager a d�j� �t� passer. Erreur");
		}
		if(this.etat.monEtat ==  EtatPassager.Etat.DEHORS) {
			throw new UsagerInvalideException("Le passager n'est pas dans le bus, il ne doit donc pas etre prevenu de ce nouvel arret");
		}
		
		if(this.destination == numeroArret) {
			bus.demanderSortie(this);
		}else if(this.estDebout()) {
			bus.demanderChangerEnAssis(this);
		}
		
	}
	

	/**
	   * Indique que le passager monte dans un bus
	   * cette methode et appel�e pas bus  
	   * @param bus le bus dans lequel va monter le passager
	 */
	@Override
	public void monterDans(Bus b) throws UsagerInvalideException {
		if(this.etat.monEtat != EtatPassager.Etat.DEHORS) {
			throw new UsagerInvalideException("On ne peut faire monter un passager uniquement si il est dehors");
		}
			if(b.aPlaceAssise()) {
				b.demanderPlaceAssise(this);
			}else {
				b.demanderPlaceDebout(this);
			}
	}

}