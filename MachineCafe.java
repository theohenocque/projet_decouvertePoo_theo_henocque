import java.util.Scanner;

public class MachineCafe {

// capacitéé max
private static final int MAX_EAU = 100; // cl
private static final int MAX_GRAINS = 50; // g
private static final int MAX_GOBELETS = 10;
private static final int LIMITE_USURE = 5;

// matériel
private int eau;
private int grains;
private int gobelets;
private int compteurCafes;

// Argent
private double monnayeur;
private double caisse;

// Etat machine
private boolean horsService;

// Constructeur
public MachineCafe() {
this.eau = MAX_EAU;
this.grains = MAX_GRAINS;
this.gobelets = MAX_GOBELETS;
this.compteurCafes = 0;
this.monnayeur = 0.0;
this.caisse = 0.0;
this.horsService = false;
}

public void insererArgent(double montant) {
monnayeur += montant;
System.out.println("Crédit actuel : " + monnayeur + " €");
}


public void commanderCafeCourt() {
servirCafe(1.50, 10, 10);
}

public void commanderCafeLong() {
servirCafe(2.00, 20, 10);
}

private void servirCafe(double prix, int eauNecessaire, int grainsNecessaires) {

if (horsService) {
System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
return;
}

if (monnayeur < prix) {
System.out.println("Crédit insuffisant, ajoutez de la monnaie");
return;
}

if (eau < eauNecessaire) {
System.out.println("Erreur : Plus assez d'eau !");
return;
}

if (grains < grainsNecessaires) {
System.out.println("Erreur : Plus assez de grains !");
return;
}

if (gobelets < 1) {
System.out.println("Erreur : Plus de gobelets !");
return;
}

eau -= eauNecessaire;
grains -= grainsNecessaires;
gobelets--;

monnayeur -= prix;
caisse += prix;

compteurCafes++;

if (compteurCafes >= LIMITE_USURE) {
    horsService = true;
}

System.out.println("Votre café est prêt ! ");
}

public void menuTechnicien() {
do {
System.out.println("\n--- MENU TECHNICIEN ---");
System.out.println("1. Recharger les stocks");
System.out.println("2. Détartrer la machine");
System.out.println("3. Récupérer l'argent");
System.out.println("0. Quitter");
choix = scanner.nextInt();

switch (choix) {
case 1:
recharger();
break;
case 2:
detartrer();
break;
case 3:
recupererArgent();
break;
}
} while (choix != 0);
}

private void recharger() {
eau = MAX_EAU;
grains = MAX_GRAINS;
gobelets = MAX_GOBELETS;
System.out.println("Stocks rechargés.");
}

private void detartrer() {
compteurCafes = 0;
horsService = false;
System.out.println("Machine détartrée.");
}

private void recupererArgent() {
System.out.println("Montant récupéré : " + caisse + " €");
caisse = 0.0;
}

public static void main(String[] args) {
MachineCafe machine = new MachineCafe();
Scanner scanner = new Scanner(System.in);
int choix = -1;

while (choix != 0) {
    

System.out.println("\n=== MACHINE À CAFÉ ===");
System.out.println("1. Insérer 1 €");
System.out.println("2. Café court (1.50 €)");
System.out.println("3. Café long (2.00 €)");
System.out.println("4. Menu technicien");
System.out.println("0. Quitter");
choix = scanner.nextInt();

switch (choix) {
case 1:
machine.insererArgent(1.0);
break;
case 2:
machine.commanderCafeCourt();
break;
case 3:
machine.commanderCafeLong();
break;
case 4:
machine.menuTechnicien();
break;
}
} while (choix != 0);

System.out.println("Au revoir !");
}
}
