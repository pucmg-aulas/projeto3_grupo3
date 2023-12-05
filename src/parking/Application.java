package parking;

import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import parking.controller.HomeController;
import parking.view.ListarVagaView;

public class Application {

    private static Logger logger = Logger.getLogger(ListarVagaView.class.getName());

    public static void main(String[] args) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        HomeController.getInstance();
    }
}