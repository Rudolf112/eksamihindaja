import java.util.ArrayList;

/**
 * Created by rudolf on 1.02.2017.
 */
public class Andmebaas {
    int suurimTulemus = 0;
    int suurimTulemusIndeks = 0;
    int labinuid;
    int labivus = 0;
    String raskusasteOK = ("Raskusaste seni tundub OK!");
    String raskusastemitteOK = ("Raskusaste seni natuke karm vist...");
    ArrayList<String> tulemused = new ArrayList();
    ArrayList<String> nimed = new ArrayList<>();

    Andmebaas(int arv){
        int[] tulemused = new int[arv];
    }

    void lisaSisestus(String nimi, String tulemus){
        nimed.add(nimi);
        tulemused.add(tulemus);
    }

    String parimTulemus(){
        for (int i = 0; i < tulemused.size(); i++) {
            if(Integer.parseInt(tulemused.get(i))> suurimTulemus)
            {
                suurimTulemus = Integer.parseInt(tulemused.get(i));
                suurimTulemusIndeks = i;
            }
        }
        String suurimTulemusString = ("Parim tulemus seni: "+ nimed.get(suurimTulemusIndeks)+" "+Integer.toString(suurimTulemus));
        return suurimTulemusString;
        }

     String labivusProtsent(){
         double labinuid = 0;
         for (int i = 0; i < tulemused.size(); i++) {
             if(Integer.parseInt(tulemused.get(i))> 50)
             {
                 labinuid++;
             }
         }
         int tulemusi = tulemused.size();
         double labivus = labinuid/tulemusi*100;
         int retval = Double.compare(labivus,70);
         if (retval > 0){
             String labinudString = ("Läbivusprotsent seni: "+ Double.toString(labivus)+"%. "+raskusasteOK);
             return labinudString;
         }
         else {
             String labinudString = ("Läbivusprotsent seni: "+ Double.toString(labivus)+"%. "+raskusastemitteOK);
             return labinudString;
         }
     }
    }
