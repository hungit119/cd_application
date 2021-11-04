package controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import model.CD;

public class DataSaveCD {
    private PrintWriter print;
    public Scanner scan;

    public void saveFile(ListCD listCD) {
        try {
            print = new PrintWriter("data.txt");
            for (int i = 0; i < listCD.tongCD(); i++) {
                print.println(
                        listCD.getCD(i).getMaCD() + ";" + listCD.getCD(i).getTuaCD() + ";" + listCD.getCD(i).getCaSi()
                                + ";" + listCD.getCD(i).getSoBaiHat() + ";" + listCD.getCD(i).getGiaThanh());
            }
            print.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<CD> read_cd() {
        ArrayList<CD> listCD = new ArrayList<CD>();
        try {
            scan = new Scanner(Paths.get("data.txt"));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                CD cd = createCDFromLine(line);
                listCD.add(cd);
            }
            scan.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return listCD;
    }

    private CD createCDFromLine(String line) {
        String datas[] = line.split("\\;");
        CD newCD = new CD(Integer.parseInt(datas[0]), datas[1], datas[2], Integer.parseInt(datas[3]),
                Float.parseFloat(datas[4]));
        return newCD;
    }
}
