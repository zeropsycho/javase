package javase.patterns.factory;

/**
 * 丙方
 *
 */
public class PartyC implements PartyA{

    @Override
    public void mackEyesWithMan() {
        System.out.println("丙方干活！！！");
    }
}

class TestDemo {
    public static void main(String[] args) {
        PartyB partyB = new PartyB();
        partyB.mackEyesWithMan();

        PartyD partyD = new PartyD();
        PartyB partyB1 = new PartyB(partyD);
        partyB1.mackEyesWithMan();
    }
}
