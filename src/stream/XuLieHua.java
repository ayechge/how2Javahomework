package stream;

import java.io.*;

/**
 * @Author: zhaoty
 * @Date: 2019/6/19 17:07
 * @Version 1.0
 */
public class XuLieHua {
    public static void main(String[] args) {

        Hero[] heros=new Hero[10];
        for(int index=0;index<10;index++){
            Hero h=new Hero();
            h.hp=index*10;
            heros[index]=h;
        }
        File f=new File("D:/heros.lol");
        try(FileOutputStream fos=new FileOutputStream(f);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            FileInputStream fis=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fis)){
            oos.writeObject(heros);
            Hero[] now=(Hero[]) (ois.readObject());
            for(Hero temp:now){
                System.out.println(temp.hp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
