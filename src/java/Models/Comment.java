/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import DataBases.MySql;

/**
 *
 * @author Ivan
 */
public class Comment extends MySql {

    public Comment() {
    }
    //this function is used to insert new comments
    public void addComment(String comment, String user, int img_id) {

        super.addComment(comment, user, img_id);
    }
}
