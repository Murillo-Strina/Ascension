public class AscencionGame {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.setVisible(true);

        menu.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                Hero hero = menu.getHero();
                if (hero != null) {
                    new Floors(hero);
                }
            }
        });
    }
}