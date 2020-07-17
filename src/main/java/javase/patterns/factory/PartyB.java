package javase.patterns.factory;

/**
 * 乙方：代理人
 */
public class PartyB implements PartyA {

    private PartyA partyA;

    public PartyB () {
        partyA = new PartyC();
    }
    public PartyB (PartyA partyA) {
        this.partyA = partyA;
    }

    @Override
    public void mackEyesWithMan() {
        this.partyA.mackEyesWithMan();
    }
}
