package OdevIsletimSistemleri;

public class BagliListe {
    Node head;
    int Count;
    public BagliListe() {
        this.head = null;
        this.Count=0;
    }

    public void ekle(Proses data) {
        Node yeniDugum = new Node(data);
        if (head == null) {
            head = yeniDugum;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = yeniDugum;
        }
    }

    public void yazdir() {
        Node temp = head;
        while (temp != null) {
            System.out.println("Varış Zamanı: " + temp.data.varisZamani +
                    ", Öncelik: " + temp.data.oncelik +
                    ", Proses Zamanı: " + temp.data.prosesZamani +
                    ", Mb Alan: " + temp.data.MbAlan +
                    ", Yazıcı Sayısı: " + temp.data.YaziciSayi +
                    ", Tarayıcı Sayısı: " + temp.data.TarayiciSayi +
                    ", Modem Sayısı: " + temp.data.ModemSayi +
                    ", CD Sürücü Sayısı: " + temp.data.CdSurucuSayi);
            temp = temp.next;
        }
    }
    public void Headyazdir() {
        Node temp = head;
        
            System.out.println("Varış Zamanı: " + temp.data.varisZamani +
                    ", Öncelik: " + temp.data.oncelik +
                    ", Proses Zamanı: " + temp.data.prosesZamani +
                    ", Mb Alan: " + temp.data.MbAlan +
                    ", Yazıcı Sayısı: " + temp.data.YaziciSayi +
                    ", Tarayıcı Sayısı: " + temp.data.TarayiciSayi +
                    ", Modem Sayısı: " + temp.data.ModemSayi +
                    ", CD Sürücü Sayısı: " + temp.data.CdSurucuSayi);
            
        
    }
    public void removeHead() {
        if (head != null) {
            head = head.next;
        }
    }
    public void BasDugumSil(BagliListe liste) {
        if (head == null) {
            System.out.println("Liste boş, silme işlemi yapılamaz.");
            return;
        }


         head = head.next;
        System.out.println("Başındaki düğüm başarıyla silindi.");
        Count--;
    }

    public void Sonraki() {
        this.head = this.head.next;
    }
}

