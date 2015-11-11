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
public class Comment {
    
    
    public Comment(){
    }

    public void addComment(String comment,String user, int img_id){
       MySql sql = new MySql();
       sql.addComment(comment, user, img_id);
               
    }
    
}
