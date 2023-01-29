package marathonSoru1;

import marathonSoru1.service.CalisanService;
import marathonSoru1.service.SirketService;

public class Main {
    public static void main(String[] args) {
        CalisanService calisanService = new CalisanService();
        SirketService sirketService = new SirketService();
        sirketService.read();
    }
}
