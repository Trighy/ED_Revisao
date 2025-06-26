import esd.ListaSequencial;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ListaSequencial<String> l = new ListaSequencial<>();

        l.adiciona("um");
        l.adiciona("dois");
        l.adiciona("tres");
        l.adiciona("quatro");
        l.adiciona("cinco");

        for (int j=0; j < l.comprimento(); j++) {
            System.out.println(l.obtem(j));
        }

        l.inverte();
        System.out.println("Após inverter: ");
        for (int j=0; j < l.comprimento(); j++) {
            System.out.println(l.obtem(j));
        }
    }
}
