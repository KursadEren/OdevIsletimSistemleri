package OdevIsletimSistemleri;

import OdevIsletimSistemleri.Node;
import OdevIsletimSistemleri.Proses;

public class Node {
    Proses data;
    Node next;

    public Node(Proses data) {
        this.data = data;
        this.next = null;
    }
}