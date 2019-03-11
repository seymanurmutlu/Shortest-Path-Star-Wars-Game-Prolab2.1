public class KyloRen extends Character {

    int kyloRenNumber;

    public KyloRen(String name, String kind) {
        super(name, kind);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "Kylo Ren";
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = "Kotu";
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public int getKyloRenNumber() {
        return kyloRenNumber;
    }

    public void setKyloRenNumber(int kyloRenNumber) {
        this.kyloRenNumber = kyloRenNumber;
    }

    @Override
    public void shortestPath(int mat[][], int i, int j, int x, int y) {/*Override edilecek t¸m
    hizli gideceg˝ gˆz ˆn¸ne al˝narak hesaplanmal˝.*/

    }

    public Character addKyloRen(Character kyloRen) {
        kyloRen.setName("Darth Vader" + kyloRenNumber);
        kyloRen.setKind("Kotu");
        //kyloRen.setLocation(location); // duzelt ;   location i nasil olusturacagimiz belli degil su an     

        return kyloRen;
    }

    public void incrementkyloRenNumber() {
        this.kyloRenNumber++;
    }

}
