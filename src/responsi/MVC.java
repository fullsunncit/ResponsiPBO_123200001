/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;

/**
 *
 * @author acer
 */
public class MVC {
    public void menu_utama(){
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
    }
}
