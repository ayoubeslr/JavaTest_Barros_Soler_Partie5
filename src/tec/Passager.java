package tec;


// TODO: Auto-generated Javadoc
/**
 * Cette interface définit un des types abstraits fixant les interactions
 * avec le bus. 
 *
 * Un passager posséde un nom. Il a trois états : dehors, assis, debout. 
 * Dans un bus, un passager est forcément soit assis, soit debout. S'il n'est
 * ni assis, ni debout, il est forcément dehors. 
 * Quand un passager est crée, il est dans l'état dehors.
 * Le nom et la destination du passager sont fixés à l'instanciation.
 * <p>
 * Les méthodes accepterPlaceAssise(), accepterPlaceDebout(), accepterSortie() 
 * changent l'état d'un passager. 
 * <p>
 * A chaque arrét, la methode nouvelArret() est appelée par un objet bus.
 * Le passager peut choisir de changer de place ou de sortir du bus.
 * Si le bus accepte la demande, c'est le bus qui déclenche les modificateurs
 * de passager (les méthodes comme accepterPlaceDebout()).
 * <p>
 * Quand il arrive à son arrét de destination, un passager sort du bus.
 */
interface Passager {
  
  /**
   * fournit le nom de l'usager.
   *
   * @return the string
   */
  public String nom();

  /**
   * Retourne vrai si le passager est hors du bus.
   * @return vrai si le passager est hors du bus.
   */
  public boolean estDehors();
  /**
   * Retourne vrai si le passager est assis dans le bus.
   * @return vrai si le passager est assis dans le bus.
   */
  public boolean estAssis();
  /**
   * Retourne vrai si le passager est debout dans le bus.
   * @return vrai si le passager est debout dans le bus.
   */
  public boolean estDebout();

  /**
   * Change l'état du passager en hors du bus.
   * Cette méthode est appelée par un objet Bus.
   */
  public void accepterSortie();
  /**
   * Change l'état du passager en assis. 
   * Le passager est dans le bus.
   * Cette méthode est appelée par un objet Bus.
   */
  public void accepterPlaceAssise();
  /**
   * Change l'état du passager en debout.
   * Le passager est dans le bus.
   * Cette méthode est appelée par un objet Bus.
   */
  public void accepterPlaceDebout();

  /**
   * Indique au passager qu'il est arrivé à un nouvel arrêt. Cette methode
   * fixe le comportement (changer de place ou sortir). 
   * Cette méthode est appelée par Bus.
   *
   * @param bus le bus dans lequel se trouve le passager.
   * @param numeroArret numero de l'arrêt.
   * @throws UsagerInvalideException the usager invalide exception
   */
  public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException;
}

