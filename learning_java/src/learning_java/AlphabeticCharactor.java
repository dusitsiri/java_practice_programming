/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning_java;

/**
 *
 * @author onege
 */
public class AlphabeticCharactor {
    public static void main(String[] args) {
        char[] s;
        //ใส่ตัวอักษรภาษาอังกฤษตั้งแต่ A-Z ใน s โดยนำเลข ASCII ไปเพิ่มทีละ 1
        s = new char[26];
        for (int i = 0; i < s.length; i++) {
            s[i] = (char)('A'+i);
        }
        //แสดงผลลัพธ์ใน s
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + "\t");
            if (i == 12) {
                System.out.println();
            }
        }
    }
}
