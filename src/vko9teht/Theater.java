/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vko9teht;

import java.util.ArrayList;

/**
 *
 * @author Qnaerhi
 */
class Theater {
    public int id;
    public String name;
    public static ArrayList<Show> shows = new ArrayList<>();

    Theater(int i, String d) {
        id = i;
        name = d;
    }
}